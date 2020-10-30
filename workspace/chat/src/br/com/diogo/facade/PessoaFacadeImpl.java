package br.com.diogo.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.diogo.dao.PessoaDAO;
import br.com.diogo.modelo.Pessoa;

public class PessoaFacadeImpl implements PessoaFacade {

	private static final long serialVersionUID = 1818242808424001885L;
	
	private PessoaDAO pessoaDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Pessoa p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		pessoaDAO = new PessoaDAO(session, Pessoa.class);
		
		this.pessoaDAO.save(p);
		
		tx.commit();
		session.close();
	}

	public void atualiza(Pessoa p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		pessoaDAO = new PessoaDAO(session, Pessoa.class);
		
		this.pessoaDAO.merge(p);
		
		tx.commit();
		session.close();
	}

	public void remove(Pessoa p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		pessoaDAO = new PessoaDAO(session, Pessoa.class);
		
		this.pessoaDAO.delete(p);
		
		tx.commit();
		session.close();
	}

	public List<Pessoa> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		pessoaDAO = new PessoaDAO(session, Pessoa.class);
				
		List<Pessoa> lista = this.pessoaDAO.list();
		
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public boolean autentica(String email, String senha){
		boolean autenticado; 
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		pessoaDAO = new PessoaDAO(session, Pessoa.class);

		autenticado = this.pessoaDAO.verificaEmailSenha(email, senha);
		
		tx.commit();
		session.close();
		
		return autenticado; 
	}

	@Override
	public Pessoa procura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}