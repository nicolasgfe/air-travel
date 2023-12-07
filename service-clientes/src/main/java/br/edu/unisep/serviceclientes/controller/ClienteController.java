package br.edu.unisep.serviceclientes.controller;

import br.edu.unisep.serviceclientes.dto.ClienteResponseDTO;
import br.edu.unisep.serviceclientes.model.Client;
import br.edu.unisep.serviceclientes.repository.ClientRepository;
import br.edu.unisep.serviceclientes.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/cliente")
@RequiredArgsConstructor
@RestController
public class ClienteController {

    private final ClientService clientService;

    @Autowired
    private ClientRepository repository;

    @GetMapping("/clientes")
    public List<Client> getAllClient(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            return ResponseEntity.ok(new ClienteResponseDTO().convert(optionalClient.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ClienteResponseDTO register(Client client) {
        Client cliente = repository.save(client);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        return clienteResponseDTO.convert(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody Client updatedClient) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setNome(updatedClient.getNome());
            client.setEmail(updatedClient.getEmail());
            client.setCpf(updatedClient.getCpf());
            Client savedClient = repository.save(client);
            return ResponseEntity.ok(new ClienteResponseDTO().convert(savedClient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
