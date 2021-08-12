package com.dryve.dryvecarros.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VeiculoResponseDTO {

	
		private String placa;
		@JsonProperty("preco_anucio")
		private BigDecimal precoAnuncio;  
		private int ano;
		@JsonProperty("preco_fipe")
		private BigDecimal precoFipe; 
		@JsonProperty("data_cadastro")
		private LocalDate dataCadastro; 
		private String modelo;
		private String Marca;		
}
