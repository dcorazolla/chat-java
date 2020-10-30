package br.com.diogo.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbr_municipio")

public class Municipio implements Serializable {

	private static final long serialVersionUID = -3249585639483881119L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="int_idamunicipio")
	private Long id;
	
	@OneToMany(mappedBy = "idmunicipio")
    private List<Pessoa> pessoaCollection;
	
	@Column(name="vhr_nome", nullable=false, length=100)
	private String nome; 
	
	@Column(name="vhr_uf", nullable=false, length=2)
	private String uf; 
	
	@Column(name="vhr_pais", nullable=false, length=50)
	private String pais; 
	
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(List<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
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
		if( (obj instanceof Municipio) && ( ((Municipio)obj).getNome().equals(this.nome)) ){
			return true; 
		}else{
			return false; 
		}
	}
	
	
}
