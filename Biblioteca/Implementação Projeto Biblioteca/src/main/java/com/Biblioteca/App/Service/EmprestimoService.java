package com.Biblioteca.App.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Emprestimo;
import com.Biblioteca.App.Repository.EmprestimoRepository;
@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;

	public List<Emprestimo> findAll() {
		return repository.findAll();
	}

	public Emprestimo findOne(int id) {
		return repository.findOne(id);
	}

	public Emprestimo save(Emprestimo post) throws ParseException {
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		Date d1=df.parse (post.getDtempres());
		Date d2=df.parse (post.getDtdev());
		long dt = (d2.getTime() - d1.getTime()) + 3600000;
		
		if((dt/ 86400000)<=5){
		   return repository.saveAndFlush(post);
		}else{
		
			return post;
		}
	}

	public void delete(int id) {
		repository.delete(id);
	}
	
	
	
	
}
