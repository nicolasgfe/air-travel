package br.edu.unisep.serviceclientes.repository;

import br.edu.unisep.serviceclientes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
