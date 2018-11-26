package com.Biblioteca.App.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_Emprestimo")
public class Emprestimo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8150710750158997422L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Campo Data de Empréstimo não pode estar vazio..")
	@Pattern(regexp ="[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$",message="Informe a Data com os Digitos válidos Ex:dia/mes/ano")
	private String dtempres;
	
	@NotEmpty(message="Campo da Data de Devolução não pode estar vazio..")
	@Pattern(regexp ="[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$",message="Informe a Data com os Digitos válidos Ex:dia/mes/ano")
	private String dtdev;

	
	@NotNull(message="Campo Livro não pode estar vazio..")
	@ManyToOne
	private Livro livro;
	
	@NotNull(message="Campo Pessoa não pode estar vazio..")
	@ManyToOne
	private Pessoa pessoa;
	
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDtempres() {
		return dtempres;
	}
	public void setDtempres(String dtempres) {
		this.dtempres = dtempres;
	}
	public String getDtdev() {
		return dtdev;
	}
	public void setDtdev(String dtdev) {
		this.dtdev = dtdev;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
