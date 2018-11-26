package com.Biblioteca.App.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_Editora")
public class Editora implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2469521069921962842L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Campo do Nome não pode estar vazio..")
    @Pattern(regexp ="(\\b[A-zÀ-ú'\\s]{2,40})+$" ,message=" Este Nome Informado é Invalido... Ex:Nome ou Nome Fantasia")
	private String nome;
	
	@NotEmpty(message="Campo Ano de Fundação não pode estar vazio Ex:2000")
	@Min(value=1950,message="Ano Minimo permitido 1950...Ano Inválido...")
	@Max(value=2018,message="Ano Máximo permitido 2018...Ano Inválido...")
	private String anofund;
	
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
	public String getAnofund() {
		return anofund;
	}
	public void setAnofund(String anofund) {
		this.anofund = anofund;
	}
	
}
