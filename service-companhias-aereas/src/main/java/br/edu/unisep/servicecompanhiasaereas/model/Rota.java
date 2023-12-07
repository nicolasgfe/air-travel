package br.edu.unisep.servicecompanhiasaereas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rota")
@Getter
@Setter
@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    //joincolumn
    private int aeroportoincio;
    //joincolumn
    private int aeroportofim;
    //joincolumn
    private Long ciaaereaId;
    //joincolumn
    private Long aviaoId;
    private Float precoTrecho;
}
