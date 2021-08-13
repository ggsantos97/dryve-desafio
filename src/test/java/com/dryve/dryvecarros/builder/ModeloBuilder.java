package com.dryve.dryvecarros.builder;

import com.dryve.dryvecarros.modelo.Marca;
import com.dryve.dryvecarros.modelo.Modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class ModeloBuilder {

    public static Modelo umModelo(){
     return Modelo.builder()
     .fipeId("4982")
     .id(UUID.randomUUID())
     .marca(new Marca())
     .nome("BWM me competition")
     .veiculo(Collections.singletonList(VeiculoBuilder.umVeiculo()))
     .build();
    }
}
