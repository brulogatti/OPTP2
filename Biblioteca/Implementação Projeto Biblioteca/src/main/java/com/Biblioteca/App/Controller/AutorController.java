package com.Biblioteca.App.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.App.Model.Autor;
import com.Biblioteca.App.Service.AutorService;

@Controller
public class AutorController {
	
	@Autowired
	private AutorService service;
	
	@GetMapping("/autor/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/autor");
		mv.addObject("autor", service.findAll());
        
		return mv;
	}
	
	@GetMapping("/autor/add")
	public ModelAndView add(Autor autor) {

		ModelAndView mv = new ModelAndView("/autorAdd");
		mv.addObject("autor", autor);

		return mv;
	}
	
	@GetMapping("/autor/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}
	
	@GetMapping("/autor/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}
	
	@PostMapping("/autor/save")
	public ModelAndView save(@Valid Autor autor, BindingResult result){

		if (result.hasErrors()) {
			return add(autor); 
		}

		service.save(autor);

		return findAll();
	}
}
