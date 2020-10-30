package br.com.diogo.facade;

import br.com.diogo.modelo.Municipio;

public interface MunicipioFacade extends BaseFacade<Municipio>{
	
	public void salva(Municipio m);
	
	public void atualiza(Municipio m);

	public void remove(Municipio m);
		
}