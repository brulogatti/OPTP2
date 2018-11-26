package com.Biblioteca.App.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_Livro")
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7168761579867654974L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Campo do Nome não pode estar vazio..")
    @Pattern(regexp ="(\\b[A-zÀ-ú'\\s]{2,40})+$" ,message=" Este Nome Informado é Invalido... Ex:Nome Sobrenome")
	private String nome;
	
	@Min(value=1900,message="Ano do Livro Minimo permitido 1900...Ano do Livro Inválido...")
	@Max(value=2018,message="Ano do Livro Máximo permitido 2018...Ano do Livro Inválido...")
	@NotEmpty(message="Campo do Ano não pode estar vazio Ex:2000")
	private String ano;
	
	@NotEmpty(message="Campo da Edição não pode estar vazio Ex:7a Ed")
	@Pattern(regexp ="((\\b[A-zÀ-ú'0-9\\s]{2,40}\\b))+$" ,message=" Este Endereço Informado é Invalido...Ex:7 Ed ou 7 Edição")
	private String edicao;
	
	@Max(value=1000,message="Quantidade Mánima de páginas permitidas 1000...Quantidade de Páginas Inválidas...")
	@Min(value=35,message="Quantidade Mínima de páginas permitidas 35...Quantidade de Páginas Inválidas...")
	@NotEmpty(message="Campo do Nome não pode estar vazio Ex:100")
    private String qtdpg;
	
	@NotNull(message="Campo Autor não pode estar vazio..")
	@ManyToOne
	private Autor autor;
	
	@NotNull(message="Campo Editora não pode estar vazio..")
	@ManyToOne
	private Editora editora;
	
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
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getQtdpg() {
		return qtdpg;
	}
	public void setQtdpg(String qtdpg) {
		this.qtdpg = qtdpg;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
}
