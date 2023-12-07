package br.edu.unisep.serviceprecopassagem.repository;

import br.edu.unisep.serviceprecopassagem.model.Aviao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Long> {
    @Query(name = "select * from aviao where codigo = cod")
    Optional<Aviao> findByCod(@Param("cod") int cod);
}
