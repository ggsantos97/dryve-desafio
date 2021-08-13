package com.dryve.dryvecarros.builder;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.modelo.Modelo;
import com.dryve.dryvecarros.modelo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VeiculoBuilder {

    public static Veiculo umVeiculo(){
        return Veiculo.builder()
                .dataCadastro(LocalDate.now())
                .ano(2020)
                .modelo(new Modelo())
                .placa("PBC-8827")
                .precoAnuncio(BigDecimal.valueOf(55.000))
                .precoFipe(BigDecimal.valueOf(52.000))
                .build();
    }

    public static VeiculoDTO umVeiculoDTO(){
        return VeiculoDTO.builder()
                .ano(2020)
                .idModelo("4430")
                .idarca(23)
                .placa("PBC-8827")
                .precoAnuncio(BigDecimal.valueOf(55.000))
                .build();
    }

    public static VeiculoResponseDTO umVeiculoResponseDTO(){
        return VeiculoResponseDTO.builder()
                .ano(2020)
                .dataCadastro(LocalDate.now())
                .marca("VW")
                .placa("PBC-8827")
                .precoAnuncio(BigDecimal.valueOf(55.000))
                .build();
    }

}
