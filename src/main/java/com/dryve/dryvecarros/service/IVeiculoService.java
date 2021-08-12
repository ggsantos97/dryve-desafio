package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.ErroNegocialException;

public interface IVeiculoService {

    VeiculoResponseDTO salva(VeiculoDTO dto) throws ErroNegocialException;
}
