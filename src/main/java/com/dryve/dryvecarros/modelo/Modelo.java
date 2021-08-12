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
public class Modelo implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3586694470755734030L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id", updatable = false, nullable = false)
	private  UUID id =  UUID.randomUUID();
	
	@Column(name = "name")
	private String nome;

	@Column(name = "fipe_id")
	private String fipeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_marca", referencedColumnName = "id")
	private Marca marca;

	@OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Veiculo> veiculo;
}
