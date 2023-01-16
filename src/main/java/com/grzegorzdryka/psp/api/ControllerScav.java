package com.grzegorzdryka.psp.api;
import com.grzegorzdryka.psp.data.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tarkov")
public class ControllerScav {

    private final ScavRepository _ScavRepository;

    @Autowired
    public ControllerScav(ScavRepository scavRepositoryRepository) {
        _ScavRepository = scavRepositoryRepository;
    }
    @GetMapping("/scav")
    public Iterable<Scav> getAllScav() {
        return _ScavRepository.findAll();
    }

    @GetMapping("/scav/{id}")
    public ResponseEntity<Scav> getScavById(@PathVariable("id") int id) {
        return ResponseEntity.of(_ScavRepository.findById(id));
    }

    @PostMapping("/scav")
    public ResponseEntity<Scav> createScav(@Valid @RequestBody Scav scav) {
        Optional<Scav> Scavs = _ScavRepository.findById(scav.getId_scav());
        if (Scavs.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Scav ScavCreado = _ScavRepository.save(scav);
        return ResponseEntity.status(HttpStatus.CREATED).body(ScavCreado);
    }

    @PutMapping("/scav")
    public ResponseEntity<Scav> updateScav(@Valid @RequestBody Scav scav) {
        Optional<Scav> Scavs = _ScavRepository.findById(scav.getId_scav());
        if (!Scavs.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Scav ScavCreado = _ScavRepository.save(scav);
        return ResponseEntity.status(HttpStatus.CREATED).body(ScavCreado);
    }

    @DeleteMapping("/scav")
    public ResponseEntity<Scav> deleteScav(@RequestParam(value = "id") int id_scav) {
        Optional<Scav> Scavs = _ScavRepository.findById(id_scav);
        if (Scavs.isEmpty())
            return ResponseEntity.notFound().build();
        _ScavRepository.deleteById(Scavs.get().getId_scav());
        return ResponseEntity.noContent().build();
    }
}
