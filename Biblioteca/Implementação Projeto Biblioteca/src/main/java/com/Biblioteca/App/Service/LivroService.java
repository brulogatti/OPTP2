package com.Biblioteca.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Livro;
import com.Biblioteca.App.Repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro findOne(int id) {
		return repository.findOne(id);
	}

	public Livro save(Livro post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
