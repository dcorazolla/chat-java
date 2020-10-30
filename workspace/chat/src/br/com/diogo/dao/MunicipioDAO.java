package br.com.diogo.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.diogo.modelo.*;

public class MunicipioDAO extends DAO<Municipio> {

	private Logger logger = Logger.getLogger(MunicipioDAO.class);

	public MunicipioDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
	
	@SuppressWarnings("unchecked")
	public List<Municipio> pesquisaMunicipios(){
		logger.info("> Buscando municipios no banco");
		Criteria c = session.createCriteria(Municipio.class);
		c.addOrder(Order.asc("nome"));
		
		return c.list();
	}
	
}