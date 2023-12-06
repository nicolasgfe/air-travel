package br.edu.unisep.servicecompanhiasaereas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aviao")
@Getter
@Setter
@Entity
public class Aviao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codigo;
    private int qtdassentos;
}
