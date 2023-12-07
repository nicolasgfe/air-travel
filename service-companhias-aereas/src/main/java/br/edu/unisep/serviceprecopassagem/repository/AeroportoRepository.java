package br.edu.unisep.serviceprecopassagem.repository;

import br.edu.unisep.serviceprecopassagem.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
    @Query(name = "select * from aeroporto where codigo = cod")
    Optional<Aeroporto> findByCod(@Param("cod") int cod);

}
