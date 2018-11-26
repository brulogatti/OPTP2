package com.Biblioteca.App.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.App.Model.Resenha;
import com.Biblioteca.App.Service.LivroService;
import com.Biblioteca.App.Service.ResenhaService;


@Controller
public class ResenhaController {
	
	@Autowired
	private ResenhaService service;
	@Autowired
	private LivroService servicelivro;
	
	@GetMapping("/resenha/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/resenha");
		mv.addObject("resenha", service.findAll());

		return mv;
	}
	
	@GetMapping("/resenha/add")
	public ModelAndView add(Resenha resenha) {

		ModelAndView mv = new ModelAndView("/resenhaAdd");
		mv.addObject("resenha", resenha);
		mv.addObject("livros", servicelivro.findAll());

		return mv;
	}
	
	@GetMapping("/resenha/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}
	
	@GetMapping("/resenha/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}
	
	@PostMapping("/resenha/save")
	public ModelAndView save(@Valid Resenha resenha, BindingResult result) {
       
	  
       if (result.hasErrors()) {
			 return add(resenha);
		}
	    
        service.save(resenha);
			return  findAll();
	
       }
}
