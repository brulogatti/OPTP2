package com.Biblioteca.App.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.App.Model.Livro;
import com.Biblioteca.App.Service.AutorService;
import com.Biblioteca.App.Service.EditoraService;
import com.Biblioteca.App.Service.LivroService;

@Controller
public class LivroController {
	
	@Autowired
	private  LivroService service;
	@Autowired
	private AutorService serviceautor;
	@Autowired
	private EditoraService serviceeditora;
	
	
	@GetMapping("/livro/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/livro");
		mv.addObject("livro", service.findAll());

		return mv;
	}
	
	@GetMapping("/livro/add")
	public ModelAndView add(Livro livro) {

		ModelAndView mv = new ModelAndView("/livroAdd");
		mv.addObject("livro", livro);
		mv.addObject("autores", serviceautor.findAll());
		mv.addObject("editoras", serviceeditora.findAll());

		return mv;
	}
	
	@GetMapping("/livro/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}
	
	@GetMapping("/livro/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}
	
	@PostMapping("/livro/save")
	public ModelAndView save(@Valid Livro livro, BindingResult result) {

		if (result.hasErrors()) {
			return add(livro);
		}

		service.save(livro);

		return findAll();
	}

}
