package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.modelo.Veiculo;
import com.dryve.dryvecarros.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService implements IVeiculoService{

    @Autowired
    VeiculoRepository repository;
   // @Autowired
    //VeiculoMapper mapper;

    @Override
    public VeiculoResponseDTO salva(VeiculoDTO dto) throws ErroNegocialException {
        //validaVeiculoNaBase(dto.getPlaca());
        //Veiculo entity = mapper.toEntity(dto);
           //return mapper.toResponseDTO(repository.save(entity)) ;
        return null;
    }

    public void validaVeiculoNaBase(String placa) throws ErroNegocialException {
        Optional<Veiculo> veiculoOptional = repository.findByPlaca(placa);
        if(veiculoOptional.isPresent()){
            throw new ErroNegocialException("EnumMensagensErro.VEICULO_CADASTRADO_NA_BASE");
        }
    }
}
