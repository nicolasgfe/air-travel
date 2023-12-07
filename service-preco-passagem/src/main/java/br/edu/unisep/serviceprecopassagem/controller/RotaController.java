package br.edu.unisep.serviceprecopassagem.controller;

import br.edu.unisep.serviceprecopassagem.model.Rota;
import br.edu.unisep.serviceprecopassagem.repository.RotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@RestController
@AllArgsConstructor
public class RotaController {
    private final RotaRepository repository;

    @GetMapping("rota")
    private List<Rota> listRota() {
        return repository.findAll();
    }

    @PostMapping("rota")
    private Rota createRota(Rota rota) {
        return repository.save(rota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> obterRotaPorId(@PathVariable Long id) {
        Optional<Rota> optionalRota = repository.findById(id);
        return optionalRota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> atualizarRota(@PathVariable Long id, @RequestBody Rota updatedRota) {
        Optional<Rota> optionalRota = repository.findById(id);
        if (optionalRota.isPresent()) {
            Rota rota = optionalRota.get();
            rota.setNome(updatedRota.getNome());
            rota.setDescricao(updatedRota.getDescricao());
            rota.setAeroportoincio(updatedRota.getAeroportoincio());
            rota.setAeroportofim(updatedRota.getAeroportofim());
            rota.setCiaaereaId(updatedRota.getCiaaereaId());
            rota.setAviaoId(updatedRota.getAviaoId());
            rota.setPrecoTrecho(updatedRota.getPrecoTrecho());

            Rota savedRota = repository.save(rota);
            return ResponseEntity.ok(savedRota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRota(@PathVariable Long id) {
        Optional<Rota> optionalRota = repository.findById(id);
        if (optionalRota.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
