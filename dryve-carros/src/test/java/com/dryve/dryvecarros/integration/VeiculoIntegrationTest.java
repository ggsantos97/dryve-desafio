package com.dryve.dryvecarros.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.dryve.dryvecarros.builder.VeiculoBuilder;
import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.mapper.VeiculoMapper;
import com.dryve.dryvecarros.modelo.Modelo;
import com.dryve.dryvecarros.modelo.Veiculo;
import com.dryve.dryvecarros.repository.VeiculoRepository;
import com.dryve.dryvecarros.service.ModeloService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoIntegrationTest {
	
	
    private final String BASE_URL = "/veiculos";

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private VeiculoMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private ModeloService modeloService;
    
    
    @Test
    @Order(1)
    public void deveSalvarUmVeiculo() throws JsonProcessingException, Exception {
    	mockMvc.perform(post(BASE_URL)
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(objectMapper.writeValueAsString(VeiculoBuilder.umVeiculoDTO()))
    			).andExpect(status().isCreated());
    	
    	Veiculo entity = repository.findByPlaca(VeiculoBuilder.umVeiculoDTO().getPlaca()).get();
    	assertEquals(entity.getPlaca(), VeiculoBuilder.umVeiculoDTO().getPlaca());
    }
    
    
    @Test
    @Order(2)
    public void deveAtualizarUmVeiculo() throws JsonProcessingException, Exception {
    	VeiculoDTO  dtoAtualizado =  VeiculoBuilder.umVeiculoDTOUpdate();
    	dtoAtualizado.setPrecoAnuncio(BigDecimal.valueOf(29000L));  
    	salvaUmVeiculoProTeste();
    	mockMvc.perform(put(BASE_URL+"/"+VeiculoBuilder.umVeiculoDTOUpdate().getPlaca(), dtoAtualizado)
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(objectMapper.writeValueAsString(dtoAtualizado))
    			).andExpect(status().isOk());
    }
    
 
    
    @Test
    @Order(3)
    public void naoDeveSalvarUmVeiculoVazio() throws JsonProcessingException, Exception {
    	mockMvc.perform(post(BASE_URL)
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(objectMapper.writeValueAsString(new VeiculoDTO()))
    			).andExpect(status().isBadRequest());
    	
    }
    
    @Test
    @Order(4)
    public void deveBuscarUmVeiculoPorPlaca() throws JsonProcessingException, Exception {
    	//VeiculoResponseDTO esperado  = mapper.toResponseDTO();   	
    	 mockMvc.perform(get(BASE_URL+"?placa=PBC-2418")
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(objectMapper.writeValueAsString(new VeiculoDTO()))
    			).andExpect(status().isOk());
    	
    }
    
    
    private Veiculo salvaUmVeiculoProTeste() throws ErroNegocialException {
    	Veiculo entity = Veiculo.builder().ano("2020-5")
    			.placa("PBC-2418")
    			.dataCadastro(LocalDate.now())
    			.precoAnuncio(BigDecimal.valueOf(28000L))
    			.modelo(modeloService.buscaModeloPorFipeId("940"))
    			.build();
    		return repository.save(entity);
    }
    
}
