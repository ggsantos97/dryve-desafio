package com.dryve.dryvecarros.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponseDTO {

	
		private String placa;
		@JsonProperty("preco_anucio")
		private BigDecimal precoAnuncio;  
		private String ano;
		@JsonProperty("preco_fipe")
		private BigDecimal precoFipe; 
		@JsonProperty("data_cadastro")
		private LocalDate dataCadastro; 
		private String modelo;
		private String marca;
}
