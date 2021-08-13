package com.dryve.dryvecarros.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dryve.dryvecarros.modelo.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID>{
			
	Optional<Veiculo> findByPlaca(String placa);
	@Query(value = "select v from Veiculo v inner join v.modelo m where m.marca.fipeId= :idMarca ORDER BY v.id",
	countQuery = "SELECT count(*) from Veiculo ",
	nativeQuery = true)
	Page<Veiculo> selectByIdMarcaAndPage(@Param("idMarca") Long idMarca, Pageable page);

	@Query(value="SELECT v from Veiculo v inner join v.modelo m where m.marca.fipeId = :idMarca")
	List<Veiculo> listaTeste(@Param("idMarca") Long idMarca);
}
