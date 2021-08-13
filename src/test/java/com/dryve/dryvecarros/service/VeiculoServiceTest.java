package com.dryve.dryvecarros.service;

import com.dryve.dryvecarros.builder.ModeloBuilder;
import com.dryve.dryvecarros.builder.VeiculoBuilder;
import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.EnumMensagensErro;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.mapper.VeiculoMapperImpl;
import com.dryve.dryvecarros.modelo.Modelo;
import com.dryve.dryvecarros.modelo.Veiculo;
import com.dryve.dryvecarros.repository.VeiculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

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
        doReturn(ModeloBuilder.umModelo()).when(modeloService).buscaModeloPorFipeId(anyString());
        doReturn(VeiculoBuilder.umVeiculoResponseDTO()).when(mapper).toResponseDTO(any(Veiculo.class));
        when(repository.save(any(Veiculo.class))).thenReturn(VeiculoBuilder.umVeiculo());
        VeiculoResponseDTO resultado = service.salva(VeiculoBuilder.umVeiculoDTO());
        Assertions.assertNotNull(resultado.getAno());
       // Mockito.verify(service, Mockito.times(1)).salva(VeiculoBuilder.umVeiculoDTO());
    }

    @Test
    @Order(2)
    public void deveEstourarExceptionAoValidaVeiculoNaBase(){
        doReturn(Optional.of(VeiculoBuilder.umVeiculo())).when(repository).findByPlaca(anyString());
        ErroNegocialException erro =Assertions.assertThrows(ErroNegocialException.class, () ->
                service.validaVeiculoNaBase(VeiculoBuilder.umVeiculoDTO().getPlaca()));
        Assertions.assertEquals(EnumMensagensErro.VEICULO_CADASTRADO_NA_BASE.getMensagem(), erro.getMessage());
    }

    @Test
    @Order(3)
    public void deveBuscarVeiculoPorPlaca() throws ErroNegocialException {
        doReturn(Optional.of(VeiculoBuilder.umVeiculo())).when(repository).findByPlaca(anyString());
        doReturn(VeiculoBuilder.umVeiculoResponseDTO()).when(mapper).toResponseDTO(any(Veiculo.class));
        VeiculoResponseDTO dto = service.buscaPorPlaca(VeiculoBuilder.umVeiculoDTO().getPlaca());
        Assertions.assertNotNull(dto.getPrecoAnuncio());
    }

    @Test
    @Order(4)
    public void deveBuscarVeiculosPaginadoPorMarcaId() throws ErroNegocialException {
        doReturn(new PageImpl<Veiculo>(Collections.singletonList(VeiculoBuilder.umVeiculo())))
                .when(repository).selectByIdMarcaAndPage(anyLong(), any(Pageable.class));
        doReturn(VeiculoBuilder.umVeiculoResponseDTO()).when(mapper).toResponseDTO(any(Veiculo.class));

        Page<VeiculoResponseDTO> result = service.listaVeiculosPorMarca(23L, Pageable.ofSize(12));
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    @Order(5)
    public void deveAtualizarVeiculo() throws ErroNegocialException {
       doReturn(Optional.of(VeiculoBuilder.umVeiculo())).when(repository).findByPlaca(anyString());
        when(repository.save(any(Veiculo.class))).thenReturn(VeiculoBuilder.umVeiculo());
       doReturn(VeiculoBuilder.umVeiculo()).when(mapper).toEntityUpdate(any(VeiculoDTO.class), any(Veiculo.class));
       doReturn(VeiculoBuilder.umVeiculoResponseDTO()).when(mapper).toResponseDTO(any(Veiculo.class));
       VeiculoResponseDTO dto = service.atualiza(VeiculoBuilder.umVeiculoDTO(), VeiculoBuilder.umVeiculoDTO().getPlaca());
    }

    @Test
    @Order(6)
    public void deveEstourarErroNegocialExceptionAoBuscarPorPlaca(){
        doReturn(Optional.ofNullable(null)).when(repository).findByPlaca(anyString());
        ErroNegocialException erro = Assertions.assertThrows(ErroNegocialException.class, ()->
                service.buscaPorPlaca(VeiculoBuilder.umVeiculoDTO().getPlaca()));

        Assertions.assertEquals(EnumMensagensErro.VEICULO_NAO_ENCONTRADO.getMensagem(), erro.getMessage());
    }

    @Test
    @Order(7)
    public void deveEstourarErroNegocialExceptionAoTentarAtualizar(){
        doReturn(Optional.ofNullable(null)).when(repository).findByPlaca(anyString());
        ErroNegocialException erro = Assertions.assertThrows(ErroNegocialException.class, ()->
                service.atualiza(VeiculoBuilder.umVeiculoDTO(), VeiculoBuilder.umVeiculoDTO().getPlaca()));
        Assertions.assertEquals(EnumMensagensErro.VEICULO_NAO_ENCONTRADO.getMensagem(), erro.getMessage());
    }



}
