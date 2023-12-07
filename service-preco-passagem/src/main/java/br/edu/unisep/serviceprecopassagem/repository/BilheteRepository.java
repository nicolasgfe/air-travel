package br.edu.unisep.serviceprecopassagem.repository;

import br.edu.unisep.serviceprecopassagem.model.Bilhete;
import br.edu.unisep.serviceprecopassagem.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {
}
