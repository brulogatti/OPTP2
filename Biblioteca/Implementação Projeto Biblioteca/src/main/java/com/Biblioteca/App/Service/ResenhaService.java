package com.Biblioteca.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Resenha;
import com.Biblioteca.App.Repository.ResenhaRepository;

@Service
public class ResenhaService {
	
	@Autowired
	private ResenhaRepository repository;

	public List<Resenha> findAll() {
		return repository.findAll();
	}

	public Resenha findOne(int id) {
		return repository.findOne(id);
	}

	public Resenha save(Resenha post) {
		
		  return repository.saveAndFlush(post);
	
	}

	public void delete(int id) {
		repository.delete(id);
	}
	
	
}
