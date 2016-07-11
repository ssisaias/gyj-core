package com.ufc.web.gyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufc.web.gyj.DAO.AcademiaDAO;
import com.ufc.web.gyj.model.Academia;

@Controller
public class CadastroAcademiaController {
	
	@Autowired
	AcademiaDAO dao;
	
	@RequestMapping(value={"/moderador/cadastroAcademia"},method = RequestMethod.POST)
	public String cadastrarAcademia(Model model, HttpServletRequest request){
		String nome = request.getParameter("nomeAcademia");
		String endereco = request.getParameter("enderecoAcademia");
		String cidade = request.getParameter("cidadeAcademia");
		String telefone = request.getParameter("telefoneAcademia");
		String email = request.getParameter("emailAcademia");
		Academia academia = new Academia();
		academia.setNome(nome);
		academia.setEndereco(endereco);
		academia.setCidade(cidade);
		academia.setEmail(email);
		academia.setTelefone(telefone);
		dao.save(academia);
		
		return "home";
	}
}
