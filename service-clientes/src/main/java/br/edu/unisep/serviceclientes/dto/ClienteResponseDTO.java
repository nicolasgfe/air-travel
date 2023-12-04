package br.edu.unisep.serviceclientes.dto;

import br.edu.unisep.serviceclientes.model.Client;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ClienteResponseDTO {
    private Long id ;
    private String nome;
    private String email;
    private String cpf;

    public ClienteResponseDTO convert(Client cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setId(cliente.getId());
        clienteResponseDTO.setNome(cliente.getNome());
        clienteResponseDTO.setEmail(cliente.getEmail());
        clienteResponseDTO.setCpf(cliente.getCpf());
        return clienteResponseDTO;
    }
}
