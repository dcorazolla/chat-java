package br.com.diogo.pessoa.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.diogo.dao.PessoaDAO;
import br.com.diogo.modelo.Pessoa;

public class TestePesquisaPessoa{
	public static void main(String[] args) {
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		PessoaDAO pessoaDAO = new PessoaDAO(session, Pessoa.class);

		tx.commit();
		session.close();
	}
}