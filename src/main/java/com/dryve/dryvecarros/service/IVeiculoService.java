package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVeiculoService {

    VeiculoResponseDTO salva(VeiculoDTO dto) throws ErroNegocialException;
     void validaVeiculoNaBase(String placa) throws ErroNegocialException;
     VeiculoResponseDTO buscaPorPlaca(String placa) throws ErroNegocialException;
     Page<VeiculoResponseDTO> listaVeiculosPorMarca(Long idMarca, Pageable pageable) throws ErroNegocialException;
}
