package com.ufc.web.gyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufc.web.gyj.DAO.UserDAO;
import com.ufc.web.gyj.model.User;

@Controller
public class ModeradorController {
	
	@Autowired
	UserDAO uDao;
	
	@RequestMapping(value={"moderador/academias"})
	public String myAcademias(Model model, @RequestParam String moderador){
		//pegar academias do moderador ou admin
		User user = uDao.getOne(Long.valueOf(moderador));
		model.addAttribute("academias", user.getAcademias() );
		return "moderador/academias";
	}
}
