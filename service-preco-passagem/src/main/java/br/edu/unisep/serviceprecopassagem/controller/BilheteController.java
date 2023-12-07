package br.edu.unisep.serviceprecopassagem.controller;

import br.edu.unisep.serviceprecopassagem.model.Bilhete;
import br.edu.unisep.serviceprecopassagem.repository.BilheteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@RestController
@AllArgsConstructor
public class BilheteController {

    private final BilheteRepository bilheteRepository;

    @GetMapping
    public List<Bilhete> getAllBilhetes() {
        return bilheteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bilhete> getBilheteById(@PathVariable Long id) {
        Optional<Bilhete> bilhete = bilheteRepository.findById(id);
        return bilhete.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bilhete> createBilhete(@RequestBody Bilhete bilhete) {
        Bilhete createdBilhete = bilheteRepository.save(bilhete);
        return new ResponseEntity<>(createdBilhete, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bilhete> updateBilhete(@PathVariable Long id, @RequestBody Bilhete bilhete) {
        if (bilheteRepository.existsById(id)) {
            bilhete.setId(id);
            Bilhete updatedBilhete = bilheteRepository.save(bilhete);
            return new ResponseEntity<>(updatedBilhete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilhete(@PathVariable Long id) {
        bilheteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

