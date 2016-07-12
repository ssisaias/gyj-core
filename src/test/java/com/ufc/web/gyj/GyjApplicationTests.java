package com.ufc.web.gyj;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ufc.web.gyj.DAO.UserDAO;
import com.ufc.web.gyj.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GyjApplication.class)
@WebAppConfiguration
public class GyjApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	//@Autowired
	//private UserDAO userDAO;
	
	
//	public void testarAdicionarUsuarioDaoHibernate(){
//		User user = new User();
//		user.setAtivo(true);
//		user.setNome("admin");
//		user.setEmail("admin@gyj.com");
//		user.setRole("ADMIN");
//		user.setSenha("123");
//		user = userDAO.save(user);
//		Assert.assertNotNull(user);
//	}
}
