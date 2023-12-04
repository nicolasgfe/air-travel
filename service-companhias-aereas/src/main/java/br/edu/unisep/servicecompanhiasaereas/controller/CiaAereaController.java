package br.edu.unisep.servicecompanhiasaereas.controller;

import br.edu.unisep.servicecompanhiasaereas.model.CiaAerea;
import br.edu.unisep.servicecompanhiasaereas.repository.CiaAereaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
