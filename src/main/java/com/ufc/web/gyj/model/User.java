package com.ufc.web.gyj.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
	
	

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;

	@Column 
	private String senha;
	
	@Column
	private boolean ativo = true;
	
	@Column
	private String role = "USER"; //funcao do usuario
	
	@OneToMany(mappedBy="moderador")
	private List<Academia> academias; //academias que ele é MOD
	
	@ManyToOne
	private Academia academia;//Academias que ele malha
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Academia> getAcademias() {
		return academias;
	}

	public void setAcademias(List<Academia> academias) {
		this.academias = academias;
	}

	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
}
