package br.edu.unisep.servicecompanhiasaereas.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "aeroporto")
@NoArgsConstructor
@AllArgsConstructor
public class Aeroporto {
    private Long id;
    private String nome;
    private int codigo;
    private String cidade;

}
