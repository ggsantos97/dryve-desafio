package com.dryve.dryvecarros.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5246952853687145051L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private  UUID id;
	
	@Column(unique = true)
	private String placa;
	
	@Column
	private BigDecimal  precoFipe;
	
	@Column
	private int ano;
	
	@Column
	private LocalDate  dataCadastro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Modelo modelo;
	
}
