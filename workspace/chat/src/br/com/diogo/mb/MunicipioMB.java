package br.com.diogo.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.diogo.facade.*;
import br.com.diogo.modelo.*;

public class MunicipioMB implements Serializable {
	
	private static final long serialVersionUID = -9170198943060032123L;

	private Municipio municipio = new Municipio();

	private Long id;
	
	public MunicipioMB(){
//		System.out.println(" >>> construtor bean municipio <<< ");
		
		if(this.municipio == null){
			this.municipio = new Municipio(); 
		}
		
	}

	public String save(){
		MunicipioFacade municipioService = new MunicipioFacadeImpl();
		municipioService.salva(this.municipio);
		
		this.municipio = new Municipio(); 
		return "cadastraSucesso";
	}

	public String delete(){
		MunicipioFacade municipioService = new MunicipioFacadeImpl();
		this.municipio.setId(id);
		municipioService.remove(this.municipio);
		
		this.municipio = new Municipio(); 
		return "removeSucesso";
	}
	
	public String merge(){
		MunicipioFacade municipioService = new MunicipioFacadeImpl();
		municipioService.atualiza(this.municipio);
		
		this.municipio = new Municipio(); 		
		return "atualizaSucesso";
	}
	
	public String load(){
		MunicipioFacade municipioService = new MunicipioFacadeImpl();
		
		this.municipio = municipioService.procura(this.id);
		return "pesquisaSucesso";
	}

	public List<Municipio> getMunicipios(){
		MunicipioFacade municipioService = new MunicipioFacadeImpl();		
		
		return municipioService.lista();
	}
	
	public List<SelectItem> getMunicipiosSelect(){
		List<Municipio> municipios = getMunicipios();
		List<SelectItem> temp = new ArrayList<SelectItem>(); 
		
		temp.add(new SelectItem(null, ". selecione ."));
		
		for (Municipio municipio : municipios)
		{
			temp.add(new SelectItem(String.valueOf(municipio.getId()), municipio.getNome())); 
		}
		
		return temp;
	}

	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}