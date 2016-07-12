package com.ufc.web.gyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufc.web.gyj.DAO.AcademiaDAO;
import com.ufc.web.gyj.DAO.UserDAO;
import com.ufc.web.gyj.model.Academia;
import com.ufc.web.gyj.model.User;

@Controller
public class ModeradorController {
	
	@Autowired
	UserDAO uDao;
	@Autowired
	AcademiaDAO aDao;
	
	@RequestMapping(value={"moderador/academias"})
	public String myAcademias(Model model, @RequestParam String moderador){
		//pegar academias do moderador ou admin
		User user = uDao.getOne(Long.valueOf(moderador));
		model.addAttribute("academias", user.getAcademias() );
		return "moderador/academias";
	}
	
	@RequestMapping(value={"moderador/profile"})
	public String myAcademias(Model model){
		return "moderador/profile";
	}
	
	@RequestMapping(value={"moderador/academia/{id}"})
	public String academia(Model model, @PathVariable("id") int id){
		//pegar academias do moderador ou admin
		Academia gym = aDao.getOne((long) id);
		model.addAttribute("playlists", gym.getPlaylists());
		return "moderador/academia/playlists";
	}
	
	@RequestMapping(value={"/moderador/cadastroAcademia"},method = RequestMethod.GET)
	public String cadastrarAcademia(Model model, HttpServletRequest request){
		return "/moderador/cadastroAcademia";
	}
}
