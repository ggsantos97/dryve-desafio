package com.dryve.dryvecarros.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponseDTO implements Serializable {

	
		private String placa;
		@JsonProperty("preco_anucio")
		private BigDecimal precoAnuncio;  
		private String ano;
		@JsonProperty("preco_fipe")
		private BigDecimal precoFipe;

		@JsonProperty("data_cadastro")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
		private LocalDate dataCadastro; 
		private String modelo;
		private String marca;
}
