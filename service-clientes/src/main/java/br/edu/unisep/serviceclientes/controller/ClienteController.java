package br.edu.unisep.serviceclientes.controller;

import br.edu.unisep.serviceclientes.dto.ClienteResponseDTO;
import br.edu.unisep.serviceclientes.model.Client;
import br.edu.unisep.serviceclientes.repository.ClientRepository;
import br.edu.unisep.serviceclientes.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/cliente")
@RequiredArgsConstructor
@RestController
public class ClienteController {
    private final ClientService clientService;
    private ClientRepository clientRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ClienteResponseDTO register(Client client) {
        Client cliente = clientRepository.save(client);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        return clienteResponseDTO.convert(cliente);
    }
}
