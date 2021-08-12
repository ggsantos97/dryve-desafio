package com.dryve.dryvecarros.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Modelo implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3586694470755734030L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private  UUID id;
	
	@Column(name = "name")
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;

	@OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Veiculo> veiculo;
}
