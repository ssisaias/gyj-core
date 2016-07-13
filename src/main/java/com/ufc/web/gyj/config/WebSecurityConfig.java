package com.ufc.web.gyj.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	@Autowired
	CustomAuthenticationSuccessHandler handler;
	//configuração de login 
	//verifica os dados contidos no banco
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select email,senha,ativo from user where email=?")
		.authoritiesByUsernameQuery(
			"select email,role from user where user.email=?");
	  	//Query de funcao testada no SQL server 5.6
	}	
	//aqui ele seta as views de acordo com usuario e senha, mostra página de erro
	//seta a página de login que contém o form de acesso e passa os parâmetros
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//csrf desabilitado
	 http.csrf().disable();
	 http
		 .authorizeRequests()
		 .antMatchers("/teste","/academias","/login**","/cadastro","/","/index","/css/**", "/js/**","/img/**").permitAll()
		 .antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
		 .antMatchers("/moderador/**").hasAnyRole("MOD","ADMIN").anyRequest().authenticated()
		 .antMatchers("/user/**").hasAnyRole("ADMIN","USER","MOD").anyRequest().authenticated()
		 
		 //.antMatchers("/admin/**").authenticated() 
		 //.antMatchers("/**", "/css/**", "/js/**","/img/**","/bootstrap/**","/public/**").permitAll()
         //.anyRequest().authenticated()
         .and()
     .formLogin()
         .loginPage("/login").failureUrl("/login?error").successHandler(handler)
         .usernameParameter("email").passwordParameter("senha")
         .permitAll()
         .and()
     .logout().logoutSuccessUrl("/login?logout") 
        .and()
     .exceptionHandling().accessDeniedPage("/403");
		
	}
	
}
