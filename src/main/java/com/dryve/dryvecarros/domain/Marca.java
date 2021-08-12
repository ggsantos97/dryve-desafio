package com.dryve.dryvecarros.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Marca implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6093975916559642789L;
	
	@EmbeddedId
	private  MarcaId id;
	@Column(name = "name")
	private String nome;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Modelo> modelos;	
	
	
	
}
