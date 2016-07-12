package com.ufc.web.gyj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="musica")
public class Musica {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@ManyToOne
	private Playlist playlist; //
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	//duracao em segundos totais
	@Column(name="duracao")
	private int duracao;
	
	//indice de aprovacao da musica dentro da playlist
	@Column(name="aprovacao")
	private int aprovacao=100;
}
