package com.dryve.dryvecarros.mapper;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.modelo.Veiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    Veiculo toEntity(VeiculoDTO dto);
}
