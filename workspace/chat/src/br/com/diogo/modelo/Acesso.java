package br.com.diogo.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_acesso")

public class Acesso implements Serializable {

	private static final long serialVersionUID = 3697323782282950080L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="int_idaacesso")
	private Long id;
	
	@JoinColumn(name = "int_idfpessoa", referencedColumnName = "int_idapessoa")
    @ManyToOne
    private Pessoa idpessoa;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dte_entrada")
	private Date entrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dte_saida")
	private Date saida;
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public Pessoa getPessoa() {
        return idpessoa;
    }

    public void setPessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

	public Pessoa getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Pessoa idpessoa) {
		this.idpessoa = idpessoa;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
	/*	
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
	*/
	
}
