package br.edu.unisep.serviceprecopassagem.controller;

import br.edu.unisep.serviceprecopassagem.model.Aeroporto;
import br.edu.unisep.serviceprecopassagem.repository.AeroportoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AeroportoController {

    private final AeroportoRepository aeroportoRepository;
    @GetMapping("aeroporto")
    private List<Aeroporto> listAeroporto(){
        return aeroportoRepository.findAll();
    }

    private Aeroporto createAeroporto(Aeroporto aeroporto){
        int codResquest = aeroporto.getCodigo();
        Optional<Aeroporto> aeroportoresponse = aeroportoRepository.findByCod(codResquest);
        if (aeroportoresponse.isPresent()) {
            throw new Error("Codigo do aeroporto já existente");
        }

        return aeroportoRepository.save(aeroporto);
    }
}
