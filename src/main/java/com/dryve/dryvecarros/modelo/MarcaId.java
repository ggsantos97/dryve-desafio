package com.dryve.dryvecarros.modelo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Getter
@Setter
public class MarcaId  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



}
