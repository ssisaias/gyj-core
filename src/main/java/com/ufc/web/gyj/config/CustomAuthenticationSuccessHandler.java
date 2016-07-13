package com.ufc.web.gyj.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ufc.web.gyj.DAO.UserDAO;
import com.ufc.web.gyj.model.User;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserDAO uDao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
			HttpSession session = request.getSession();
			String email = (String) SecurityContextHolder.getContext().getAuthentication().getName();
			User usuarioAutenticado = uDao.findOneByEmail(email);
			System.err.println(usuarioAutenticado.getEmail() + usuarioAutenticado.getNome() + usuarioAutenticado.getId() + usuarioAutenticado.getRole() + usuarioAutenticado.getSenha());
			
			response.sendRedirect("/home");
	}
}
