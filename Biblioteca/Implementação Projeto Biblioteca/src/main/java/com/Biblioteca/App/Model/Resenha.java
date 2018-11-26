package com.Biblioteca.App.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_Resenha")
public class Resenha implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1508384262852332381L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty(message="Campo Descrição não pode estar vazio...")
    private String descricao;
	
	@NotNull(message="Campo Livro de Fundação não pode estar vazio...")
	@ManyToOne
	private Livro livro;
    
	
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
