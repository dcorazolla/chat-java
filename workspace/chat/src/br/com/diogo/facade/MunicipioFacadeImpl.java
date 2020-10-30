package br.com.diogo.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.diogo.dao.*;
import br.com.diogo.modelo.*;

public class MunicipioFacadeImpl implements MunicipioFacade {

	private static final long serialVersionUID = 1818242808424001885L;
	
	private MunicipioDAO municipioDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Municipio m) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		municipioDAO = new MunicipioDAO(session, Municipio.class);
		
		this.municipioDAO.save(m);
		
		tx.commit();
		session.close();
	}

	public void atualiza(Municipio m) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		municipioDAO = new MunicipioDAO(session, Municipio.class);
		
		this.municipioDAO.merge(m);
		
		tx.commit();
		session.close();
	}

	public void remove(Municipio m) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		municipioDAO = new MunicipioDAO(session, Municipio.class);
		
		this.municipioDAO.delete(m);
		
		tx.commit();
		session.close();
	}

	public List<Municipio> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		municipioDAO = new MunicipioDAO(session, Municipio.class);
				
		List<Municipio> lista = this.municipioDAO.list();
		
		tx.commit();
		session.close();
		
		return lista;
	}

	@Override
	public Municipio procura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}