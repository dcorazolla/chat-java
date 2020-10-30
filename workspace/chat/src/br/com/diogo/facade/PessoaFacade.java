package br.com.diogo.facade;

import java.util.List;

import br.com.diogo.modelo.Pessoa;

public interface PessoaFacade extends BaseFacade<Pessoa>{
	public void salva(Pessoa p);
	
	public void atualiza(Pessoa p);

	public void remove(Pessoa p);
	
	public boolean autentica(String email, String senha);
}