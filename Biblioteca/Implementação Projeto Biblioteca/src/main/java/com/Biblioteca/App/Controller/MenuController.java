package com.Biblioteca.App.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MenuController {

	@GetMapping("/menu/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/menu");	
		
		return mv;
	}
}
