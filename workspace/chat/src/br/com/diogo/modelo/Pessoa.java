package br.com.diogo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_pessoa")

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 6435798689041532013L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="int_idapessoa")
	private Long id;
	
	@OneToMany(mappedBy = "idpessoa")
    private List<Acesso> acessoCollection;
	
	@JoinColumn(name = "int_idfmunicipio", referencedColumnName = "int_idamunicipio")
    @ManyToOne
    private Municipio idmunicipio;
	
	@Column(name="vhr_nome", nullable=false, length=100)
	private String nome; 
	
	@Column(name="vhr_email", nullable=false, length=100)
	private String email;
	
	@Column(name="vhr_senha", nullable=false, length=45)
	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dte_nascimento")
	private Date nascimento;
	
	@Column(name="vhr_logradouro", nullable=false, length=250)
	private String logradouro; 
	
	@Column(name="vhr_complemento", nullable=true, length=250)
	private String complemento;
	
	@Column(name="vhr_bairro", nullable=false, length=100)
	private String bairro; 
	
	@Column(name="vhr_cep", nullable=false, length=8)
	private String cep; 
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
    public List<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(List<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }
    
    public Municipio getMunicipio() {
        return idmunicipio;
    }

    public void setMunicipio(Municipio idMunicipio) {
        this.idmunicipio = idMunicipio;
    }
    
    public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public int hashCode(){
		return this.nome.length() * 23;
	}
	
	@Override
	public String toString(){
		return nome; 
	}

	@Override
	public boolean equals(Object obj){
		if( (obj instanceof Pessoa) && ( ((Pessoa)obj).getEmail().equals(this.email)) ){
			return true; 
		}else{
			return false; 
		}
	}
	
}
