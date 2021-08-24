package com.dryve.dryvecarros.builder;

import java.util.Collections;
import java.util.UUID;

import com.dryve.dryvecarros.modelo.Marca;
import com.dryve.dryvecarros.modelo.Modelo;

public class ModeloBuilder {

    public static Modelo umModelo(){
     return Modelo.builder()
     .fipeId("4982")
     .id(UUID.randomUUID())
     .marca(new Marca())
     .nome("BWM me competition")
     .veiculos(Collections.singletonList(VeiculoBuilder.umVeiculo()))
     .build();
    }
}
