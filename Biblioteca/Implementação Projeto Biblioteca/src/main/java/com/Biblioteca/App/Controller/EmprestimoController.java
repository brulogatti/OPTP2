package com.Biblioteca.App.Controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.App.Model.Emprestimo;
import com.Biblioteca.App.Service.EmprestimoService;
import com.Biblioteca.App.Service.LivroService;
import com.Biblioteca.App.Service.PessoaService;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService service;
	@Autowired
	private LivroService servicelivro;
	@Autowired
	private PessoaService servicepessoa;
	
	@GetMapping("/emprestimo/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/emprestimo");
		mv.addObject("emprestimo", service.findAll());

		return mv;
	}
	
	@GetMapping("/emprestimo/add")
	public ModelAndView add(Emprestimo emprestimo) {

		ModelAndView mv = new ModelAndView("/emprestimoAdd");
		mv.addObject("emprestimo", emprestimo);
		mv.addObject("livros", servicelivro.findAll());
		mv.addObject("pessoas", servicepessoa.findAll());

		return mv;
	}
	
	@GetMapping("/emprestimo/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}
	
	@GetMapping("/emprestimo/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}
	
	@PostMapping("/emprestimo/save")
	public ModelAndView save(@Valid Emprestimo emprestimo, BindingResult result)throws ParseException, IOException, ServletException {

		if (result.hasErrors()) {
			return add(emprestimo);
		}

		service.save(emprestimo);

		return findAll();
	}
}
