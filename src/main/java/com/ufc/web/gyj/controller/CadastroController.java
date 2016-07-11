package com.ufc.web.gyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufc.web.gyj.DAO.UserDAO;
import com.ufc.web.gyj.model.User;

@Controller
public class CadastroController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value={"/cadastro"},method = RequestMethod.POST)
	public String cadastrar(Model model, HttpServletRequest request){
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");	
		User user = new User();
		user.setNome(nome);
		user.setEmail(email);
		user.setSenha(senha);
		userDAO.save(user);
		
		if(userDAO.save(user)== null){
			model.addAttribute("erro",true);
			return "cadastro";
		}
		
		model.addAttribute("sucesso",true);
		return "index";
	}
}
