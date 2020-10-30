package br.com.diogo.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.diogo.facade.PessoaFacade;
import br.com.diogo.facade.PessoaFacadeImpl;
import br.com.diogo.modelo.Pessoa;

public class PessoaMB implements Serializable {
	
	private static final long serialVersionUID = -333995781063775201L;

	private Pessoa pessoa = new Pessoa();

	private Long id;

	public PessoaMB(){
//		System.out.println(" >>> construtor pessoa manage bean <<< ");
		
		if(this.pessoa == null){
			this.pessoa = new Pessoa(); 
		}
	}

	public String login() throws Exception{
        boolean logado = false;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        PessoaFacade pessoaService = new PessoaFacadeImpl();
		
        logado = pessoaService.autentica(this.pessoa.getEmail(), this.pessoa.getSenha());
           
        if(logado){
            session.setAttribute("user", logado);
            rp.sendRedirect(rq.getContextPath() + "/pages/index.jsf");
            return "success";
        }else{
            session.setAttribute("user", null);
            session.removeAttribute("user");
            rp.sendRedirect(rq.getContextPath() + "/pages/login/login.jsf");
            return "failure";
        }
    }
	
	public String logout() {
		HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		try {
			rp.sendRedirect(rq.getContextPath() + "/pages/login/login.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "logoutOk";
	}

	public String save(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
				
		pessoaService.salva(this.pessoa);
		
		this.pessoa = new Pessoa(); 
		return "cadastraSucesso";
	}

	public String delete(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		this.pessoa.setId(id);
		pessoaService.remove(this.pessoa);
		this.pessoa = new Pessoa(); 
		
		return "removeSucesso";
	}
	
	public String merge(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		pessoaService.atualiza(this.pessoa);
		
		this.pessoa = new Pessoa(); 
		return "atualizaSucesso";
	}
	
	public String load(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		this.pessoa = pessoaService.procura(this.id);
		
		return "pesquisaSucesso";
	}

	public List<Pessoa> getPessoas(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();		
		
		return pessoaService.lista();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}