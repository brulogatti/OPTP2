package com.Biblioteca.App.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tb_Pessoa")
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7242013561006635110L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	
	@Column(unique=true)
	@NotEmpty(message="Campo do CPF não pode estar vazio..")
	@Pattern(regexp ="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$",message="CPF Informado Inválido...Informe um CPF válido Ex:674.402.757-30")
	private String cpf;
	
	@NotEmpty(message="Campo do Nome não pode estar vazio..")
    @Pattern(regexp ="((\\b[A-zÀ-ú']{2,40}\\b)\\s*){2,}$" ,message=" Este Nome Informado é Invalido... Ex:Nome Sobrenome")
	private String nome;
	
	@NotEmpty(message="Campo do Endereço não pode estar vazio..")
	@Pattern(regexp ="((\\b[A-zÀ-ú'0-9]{2,40}\\b)\\s*){2,}$" ,message=" Este Endereço Informado é Invalido...Ex:Nome da Rua")
	private String endereco;
	
	@NotEmpty(message="Campo do Telefone não pode estar vazio..")
	@Pattern(regexp = "\\([0-9]{2}\\)[\\s][0-9]{4}-[0-9]{4,5}$" ,message=" Este Telefone Informado é Invalido Ex:(xx) xxxx-xxxx ou (xx) xxxx-xxxxx")
	private String telefone;
	
	@NotEmpty(message="Campo do E-mail não pode estar vazio..")
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z.-]+\\.[a-z]{2,4}$",message="Este E-mail Informado é Invalido... Ex:nome@nomeprovedor.com ")
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}