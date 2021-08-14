package com.dryve.dryvecarros.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dryve.dryvecarros.builder.ModeloBuilder;
import com.dryve.dryvecarros.builder.VeiculoBuilder;
import com.dryve.dryvecarros.modelo.Modelo;
import com.dryve.dryvecarros.modelo.Veiculo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VeiculoRepositoryTest {
	
	 @Autowired
	    private VeiculoRepository repository;
	@Test
	public void teste() {
		Veiculo entity = repository.save(VeiculoBuilder.umVeiculo());
		Assertions.assertNotNull(entity.getId());
	}

}
