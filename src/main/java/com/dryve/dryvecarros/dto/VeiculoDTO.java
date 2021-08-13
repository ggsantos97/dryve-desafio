package com.dryve.dryvecarros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeiculoDTO {

    @NotBlank
    private String placa;
    @JsonProperty("preco_anuncio")
    private BigDecimal precoAnuncio;
    private int ano;
//    @JsonProperty("preco_fipe")
//    private BigDecimal precoFipe;

    @JsonProperty("id_marca")
    @NotNull
    private long idarca;

    @JsonProperty("id_modelo")
    @NotBlank
    private String idModelo;

}
