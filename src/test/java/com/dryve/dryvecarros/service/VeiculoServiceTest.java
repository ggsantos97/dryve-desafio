package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.builder.ModeloBuilder;
import com.dryve.dryvecarros.builder.VeiculoBuilder;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.mapper.VeiculoMapperImpl;
import com.dryve.dryvecarros.modelo.Veiculo;
import com.dryve.dryvecarros.repository.VeiculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class VeiculoServiceTest {

    @Mock
    VeiculoRepository repository;
    @Spy
    ModeloService modeloService;
    @Spy
    VeiculoMapperImpl mapper;

    @InjectMocks
    VeiculoService service;

    @Test
    @Order(1)
    public void deveSalvarUmVeiculo() throws ErroNegocialException {
//        when(modeloService.buscaModeloPorFipeId(anyString()))
//                .thenReturn(ModeloBuilder.umModelo());
        doReturn(VeiculoBuilder.umVeiculoResponseDTO()).when(mapper).toResponseDTO(any(Veiculo.class));
        when(repository.save(any(Veiculo.class))).thenReturn(VeiculoBuilder.umVeiculo());
        VeiculoResponseDTO resultado = service.salva(VeiculoBuilder.umVeiculoDTO());

        Assertions.assertNotNull(resultado.getAno());
    }



}
