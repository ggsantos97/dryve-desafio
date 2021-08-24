package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.exception.EnumMensagensErro;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.modelo.Modelo;
import com.dryve.dryvecarros.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeloService implements IModeloService{

    @Autowired
    ModeloRepository repository;
    @Override
    public Modelo buscaModeloPorFipeId(String fipeId) throws ErroNegocialException {
        Optional<Modelo> optional = repository.findByfipeId(fipeId);
        if(!optional.isPresent()){
            throw new ErroNegocialException(EnumMensagensErro.MODELO_NAO_EXISTE);
        }
        return optional.get();
    }
}
