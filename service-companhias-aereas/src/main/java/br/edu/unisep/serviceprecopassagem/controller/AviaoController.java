package br.edu.unisep.serviceprecopassagem.controller;

import br.edu.unisep.serviceprecopassagem.model.Aviao;
import br.edu.unisep.serviceprecopassagem.repository.AviaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AviaoController {
    private final AviaoRepository aviaoRepository;

    @GetMapping("aviao")
    private List<Aviao> listAviao() {
        return aviaoRepository.findAll();
    }

    @PostMapping("aviao")
    private Aviao createAviao(Aviao aviao){
        int aviaocod = aviao.getCodigo();
        Optional<Aviao> aviaoResponse = aviaoRepository.findByCod(aviaocod);
        if (aviaoResponse.isPresent()) {
            throw new Error("codigo já existe");
        }
        return aviaoRepository.save(aviao);
    }
}
