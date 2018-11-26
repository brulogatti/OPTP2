package com.Biblioteca.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Autor;
import com.Biblioteca.App.Repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;

	public List<Autor> findAll() {
		return repository.findAll();
	}

	public Autor findOne(int id) {
		return repository.findOne(id);
	}
    
	public Autor save(Autor post) {
	   
		return repository.saveAndFlush(post);
	
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
