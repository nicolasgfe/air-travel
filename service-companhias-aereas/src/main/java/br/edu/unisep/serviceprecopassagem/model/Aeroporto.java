package br.edu.unisep.serviceprecopassagem.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aeroporto")
@Getter
@Setter
@Entity
public class Aeroporto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int codigo;
    private String cidade;

}
