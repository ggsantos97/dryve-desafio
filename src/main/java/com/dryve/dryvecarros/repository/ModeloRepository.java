package com.dryve.dryvecarros.repository;

import com.dryve.dryvecarros.modelo.Modelo;
import com.dryve.dryvecarros.modelo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ModeloRepository extends JpaRepository<Modelo, UUID> {
    Optional<Modelo> findByfipeId(String fipeId);
}
