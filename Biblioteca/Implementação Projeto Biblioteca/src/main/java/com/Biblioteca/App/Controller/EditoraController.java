package com.Biblioteca.App.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.App.Model.Editora;
import com.Biblioteca.App.Service.EditoraService;

@Controller
public class EditoraController {
	
	@Autowired
	private EditoraService service;
	
	@GetMapping("/editora/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/editora");
		mv.addObject("editora", service.findAll());

		return mv;
	}
	
	@GetMapping("/editora/add")
	public ModelAndView add(Editora editora) {

		ModelAndView mv = new ModelAndView("/editoraAdd");
		mv.addObject("editora", editora);

		return mv;
	}
	
	@GetMapping("/editora/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}
	
	@GetMapping("/editora/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}
	
	@PostMapping("/editora/save")
	public ModelAndView save(@Valid Editora editora, BindingResult result) {

		if (result.hasErrors()) {
			return add(editora);
		}

		service.save(editora);

		return findAll();
	}
	
	
}
