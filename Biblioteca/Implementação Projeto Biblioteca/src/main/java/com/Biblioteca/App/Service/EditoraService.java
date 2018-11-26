package com.Biblioteca.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Editora;
import com.Biblioteca.App.Repository.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository repository;

	public List<Editora> findAll() {
		return repository.findAll();
	}

	public Editora findOne(int id) {
		return repository.findOne(id);
	}

	public Editora save(Editora post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
