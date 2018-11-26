package com.Biblioteca.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Pessoa;
import com.Biblioteca.App.Repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa findOne(int id) {
		return repository.findOne(id);
	}

	public Pessoa save(Pessoa post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
