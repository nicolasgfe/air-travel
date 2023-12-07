package br.edu.unisep.servicecompanhiasaereas.repository;

import br.edu.unisep.servicecompanhiasaereas.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {
}
