package br.com.diogo.pessoa.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.diogo.dao.DAO;
import br.com.diogo.modelo.Pessoa;

public class PessoaTest{
	private static Pessoa PESSOA_TESTE = new Pessoa();

	SessionFactory sf;
	Session session;
	Transaction tx;
	DAO<Pessoa> dao;

	@Before
	public void runBeforeEveryTest(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		dao = new DAO<Pessoa>(session, Pessoa.class);
	}

	@After
	public void runAfterEveryTest(){
		tx.commit();
		session.close();
	}

	@Test
	public void testCadastra(){
		PESSOA_TESTE.setNome("Diogo Corazolla");
		PESSOA_TESTE.setEmail("diogocorazolla@gmail.com");
		PESSOA_TESTE.setNascimento(new Date());
		PESSOA_TESTE.setSenha("123456");

		dao.save(PESSOA_TESTE);
	}

	@Test
	public void testProcura() {
		Pessoa buscada; 

		buscada = dao.load(PESSOA_TESTE.getId()); 

		assertEquals(PESSOA_TESTE.getId(), buscada.getId());
		assertEquals(PESSOA_TESTE.getNome(), buscada.getNome());
		assertEquals(PESSOA_TESTE.getEmail(), buscada.getEmail());
		assertEquals(PESSOA_TESTE.getNascimento(), buscada.getNascimento());
		assertEquals(PESSOA_TESTE.getSenha(), buscada.getSenha());
	}

	@Test
	public void testAtualiza(){
		Pessoa buscadoParaAtualizacao;
	    Pessoa buscadoAposAtualizacao;

	    buscadoParaAtualizacao = dao.load(PESSOA_TESTE.getId());
	    buscadoParaAtualizacao.setNome("Nome modificado");
	    buscadoParaAtualizacao.setEmail("email@modificado.com");
	    buscadoParaAtualizacao.setNascimento(new Date());
	    buscadoParaAtualizacao.setSenha("654321");

	    dao.merge(buscadoParaAtualizacao); 

	    buscadoAposAtualizacao = dao.load(PESSOA_TESTE.getId());
	    assertEquals(buscadoParaAtualizacao.getId(), buscadoAposAtualizacao.getId());
	    assertEquals(buscadoParaAtualizacao.getNome(), buscadoAposAtualizacao.getNome());
	    assertEquals(buscadoParaAtualizacao.getEmail(), buscadoAposAtualizacao.getEmail());
	    assertEquals(buscadoParaAtualizacao.getNascimento(), buscadoAposAtualizacao.getNascimento());
	    assertEquals(buscadoParaAtualizacao.getSenha(), buscadoAposAtualizacao.getSenha());
	}

//	@Test
//	public void testRemove(){
//		Pessoa pessoa = PESSOA_TESTE;
//		pessoa.setId(1l);
//		dao.delete(pessoa);
//	}
}