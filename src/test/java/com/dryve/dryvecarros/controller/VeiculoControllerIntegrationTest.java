package com.dryve.dryvecarros.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.dryve.dryvecarros.builder.VeiculoBuilder;
import com.dryve.dryvecarros.modelo.Veiculo;
import com.dryve.dryvecarros.repository.VeiculoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerIntegrationTest {
	
	
    private final String BASE_URL = "/veiculos";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VeiculoRepository repository;
    
  
    
    @Test
    public void deveSalvarUmVeiculo() throws JsonProcessingException, Exception {
    	mockMvc.perform(post(BASE_URL)
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(objectMapper.writeValueAsString(VeiculoBuilder.umVeiculoDTO()))
    			).andExpect(status().isCreated());
    	
    	Veiculo entity = repository.findByPlaca(VeiculoBuilder.umVeiculoDTO().getPlaca()).get();
    	assertEquals(entity.getPlaca(), VeiculoBuilder.umVeiculoDTO().getPlaca());
    }
    
}
