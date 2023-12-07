package br.edu.unisep.serviceprecopassagem.controller;

import br.edu.unisep.serviceprecopassagem.model.CiaAerea;
import br.edu.unisep.serviceprecopassagem.repository.CiaAereaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ciaaerea")
@RestController
@RequiredArgsConstructor
public class CiaAereaController {

    private final CiaAereaRepository ciaAereaRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private CiaAerea createCiaAerea(CiaAerea ciaAerea){
        return ciaAereaRepository.save(ciaAerea);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    private List<CiaAerea> listCiaAerea(){
        return ciaAereaRepository.findAll();
    }

//    @GetMapping("/list/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    private List<CiaAerea> listByIdCiaAerea(Long ciaAereaId){
//        Optional<CiaAerea> ciaAerea = ciaAereaRepository.findById(ciaAereaId);
//        if (ciaAerea == null) {
//            throw ;
//        }
//    }
}
