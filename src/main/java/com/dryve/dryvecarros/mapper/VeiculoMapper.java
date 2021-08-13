package com.dryve.dryvecarros.mapper;

import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.modelo.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    @Mappings({
            @Mapping(target="modelo.fipeId", source="dto.idModelo")

    })
    Veiculo toEntity(VeiculoDTO dto);

    @Mappings({
            @Mapping(target = "modelo", source = "entity.modelo.nome"),
            @Mapping(target = "marca", source = "entity.modelo.marca.nome"),
    })
    VeiculoResponseDTO toResponseDTO(Veiculo entity);

    Veiculo toEntityUpdate(VeiculoDTO dto, @MappingTarget Veiculo entity);
}
