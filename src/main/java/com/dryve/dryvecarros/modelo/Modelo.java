package com.dryve.dryvecarros.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modelo")
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
	private  List<Veiculo> veiculos;
}
