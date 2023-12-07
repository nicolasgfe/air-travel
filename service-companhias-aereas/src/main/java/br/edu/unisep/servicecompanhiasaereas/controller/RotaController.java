package br.edu.unisep.servicecompanhiasaereas.controller;

import br.edu.unisep.servicecompanhiasaereas.model.Rota;
import br.edu.unisep.servicecompanhiasaereas.repository.RotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
@AllArgsConstructor
public class RotaController {
    private final RotaRepository rotaRepository;

    @GetMapping("rota")
    private List<Rota> listRota() {
        return rotaRepository.findAll();
    }

    @PostMapping("rota")
    private Rota createRota(Rota rota) {
        return rotaRepository.save(rota);
    }
}
