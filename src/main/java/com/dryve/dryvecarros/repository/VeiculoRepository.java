package com.dryve.dryvecarros.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dryve.dryvecarros.modelo.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID>{
			
	Optional<Veiculo> findByPlaca(String placa);
}
