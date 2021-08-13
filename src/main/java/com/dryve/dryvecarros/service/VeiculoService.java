package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.EnumMensagensErro;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.mapper.VeiculoMapper;
import com.dryve.dryvecarros.modelo.Veiculo;
import com.dryve.dryvecarros.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VeiculoService implements IVeiculoService{

    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    IModeloService modeloService;
    @Autowired
    VeiculoMapper mapper;

    @Override
    public VeiculoResponseDTO salva(VeiculoDTO dto) throws ErroNegocialException {
        validaVeiculoNaBase(dto.getPlaca());
        Veiculo entity = mapper.toEntity(dto);
        entity.setDataCadastro(LocalDate.now());
        entity.setModelo(modeloService.buscaModeloPorFipeId(dto.getIdModelo()));
           return mapper.toResponseDTO(veiculoRepository.save(entity)) ;
    }

    public void validaVeiculoNaBase(String placa) throws ErroNegocialException {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findByPlaca(placa);
        if(veiculoOptional.isPresent()){
            throw new ErroNegocialException(EnumMensagensErro.VEICULO_CADASTRADO_NA_BASE);
        }
    }

    @Override
    public VeiculoResponseDTO buscaPorPlaca(String placa) throws ErroNegocialException {
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findByPlaca(placa);
        return mapper.toResponseDTO(optionalVeiculo.get());
    }

    @Override
    public Page<VeiculoResponseDTO> listaVeiculosPorMarca(Long idMarca, Pageable pageable) throws ErroNegocialException {
        Page<VeiculoResponseDTO> veiculos = veiculoRepository.selectByIdMarcaAndPage(idMarca, pageable).map(
                v -> mapper.toResponseDTO(v)
        );
        //List<Veiculo> veiculos = veiculoRepository.listaTeste(idMarca);
        return veiculos;
    }


}
