package br.edu.unisep.serviceprecopassagem.repository;

import br.edu.unisep.serviceprecopassagem.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {
}
