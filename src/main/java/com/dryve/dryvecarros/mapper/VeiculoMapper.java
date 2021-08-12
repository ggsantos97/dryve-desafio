package com.dryve.dryvecarros.mapper;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.modelo.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    @Mappings({
            @Mapping(target="modelo.id", source="dto.idModelo")

    })
    Veiculo toEntity(VeiculoDTO dto);
}
