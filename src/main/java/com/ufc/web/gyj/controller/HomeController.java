package com.ufc.web.gyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/index","/"})
	public String index(Model model){
		return "index";
	}
	
	@RequestMapping(value={"/cadastro"})
	public String cadastro(Model model){
		return "cadastro";
	}
	
	@RequestMapping(value={"/home"})
	public String home(Model model){
		return "home";
	}
	
	@RequestMapping(value={"/login"})
	public String login(Model model){
		return "login";
	}
	
}	
