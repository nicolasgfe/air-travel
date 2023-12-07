package br.edu.unisep.serviceprecopassagem.model;

import br.edu.unisep.serviceprecopassagem.enums.SituacaoBilhete;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bilhete")
@Getter
@Setter
@Entity
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String assento;
    private float preco;

    @Enumerated(EnumType.STRING)
    private SituacaoBilhete situacao;

    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;

    //join column
    private int pessoa;
}
