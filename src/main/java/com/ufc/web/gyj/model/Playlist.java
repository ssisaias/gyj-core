package com.ufc.web.gyj.model;

import java.util.Date;
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
@Table(name="Playlist")
public class Playlist {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column 
	private String nome;
	
	@Column
	private boolean ativa;
	
	@Column
	private Date dataCriacao;
	
	@Column
	private Date ultimaAlteracao;
	
	@NotNull
	@ManyToOne
	private Academia academia;
	
	@OneToMany(mappedBy="playlist")
	private List<Musica> musicas;
	
	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
