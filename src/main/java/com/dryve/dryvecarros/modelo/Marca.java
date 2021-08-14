package com.dryve.dryvecarros.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Getter
@Setter
@Entity
@Table(name = "marca")
public class Marca implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6093975916559642789L;
	@Id
	@Column(name = "id",  updatable = false,  nullable = false)
	@Type(type = "uuid-char")
	private UUID id = UUID.randomUUID();

	@Column(name = "fipe_id")
	private Long fipeId;

	@Column(name = "name")
	private String nome;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Modelo> modelos;	
	
	
	
}
