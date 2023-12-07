package br.edu.unisep.serviceprecopassagem.controller;

import br.edu.unisep.serviceprecopassagem.model.Aviao;
import br.edu.unisep.serviceprecopassagem.repository.AviaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AviaoController {
    private final AviaoRepository repository;

    @GetMapping("aviao")
    private List<Aviao> listAviao() {
        return repository.findAll();
    }

    @PostMapping("aviao")
    private Aviao createAviao(Aviao aviao){
        int aviaocod = aviao.getCodigo();
        Optional<Aviao> aviaoResponse = repository.findByCod(aviaocod);
        if (aviaoResponse.isPresent()) {
            throw new Error("codigo já existe");
        }
        return repository.save(aviao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aviao> obterAviaoPorId(@PathVariable Long id) {
        Optional<Aviao> optionalAviao = repository.findById(id);
        return optionalAviao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aviao> atualizarAviao(@PathVariable Long id, @RequestBody Aviao updatedAviao) {
        Optional<Aviao> optionalAviao = repository.findById(id);
        if (optionalAviao.isPresent()) {
            Aviao existingAviao = optionalAviao.get();
            existingAviao.setCodigo(updatedAviao.getCodigo());
            existingAviao.setQtdassentos(updatedAviao.getQtdassentos());

            Aviao savedAviao = repository.save(existingAviao);
            return ResponseEntity.ok(savedAviao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAviao(@PathVariable Long id) {
        Optional<Aviao> optionalAviao = repository.findById(id);
        if (optionalAviao.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
