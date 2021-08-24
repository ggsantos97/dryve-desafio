package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.modelo.Modelo;

public interface IModeloService {

    Modelo buscaModeloPorFipeId(String fipeId) throws ErroNegocialException;
}
