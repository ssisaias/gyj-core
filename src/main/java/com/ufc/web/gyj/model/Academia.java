package com.ufc.web.gyj.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Academia")
public class Academia {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String cidade;
	
	@OneToMany(mappedBy="academia")
	private List<Playlist> playlists;
	
	@NotNull
	@ManyToOne
	private User moderador;
	
	@OneToMany(mappedBy="academia")
	private List<User> usuarios;
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public User getModerador() {
		return moderador;
	}

	public void setModerador(User moderador) {
		this.moderador = moderador;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
}
