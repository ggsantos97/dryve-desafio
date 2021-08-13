package com.dryve.dryvecarros.controller;

import com.dryve.dryvecarros.controler.VeiculoController;
import com.dryve.dryvecarros.service.VeiculoService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {VeiculoController.class, VeiculoService.class})
@WebMvcTest
public class VeiculoControllerIntegrationTest {
}
