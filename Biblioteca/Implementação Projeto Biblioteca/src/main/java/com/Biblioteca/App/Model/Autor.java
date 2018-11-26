package com.Biblioteca.App.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_Autor")
public class Autor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7065890685400743901L;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Campo do Nome não pode estar vazio..")
    @Pattern(regexp ="((\\b[A-zÀ-ú']{2,40}\\b)\\s*){2,}$" ,message=" Este Nome Informado é Invalido... Ex:Nome Sobrenome")
	private String nome;
	
	@NotEmpty(message="Campo do Data não pode estar vazio..")
	@DateTimeFormat(pattern = "dd/MM/yyyy ")
	private String dtnasc;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}
}
