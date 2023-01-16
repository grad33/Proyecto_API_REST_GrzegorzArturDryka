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
public class ControllerPmc {

    private final PmcRepository _JugadorRepository;

    @Autowired
    public ControllerPmc(PmcRepository jugadorRepository) {
        _JugadorRepository = jugadorRepository;
    }

    @GetMapping("/jugador")
    public Iterable<Pmc> getAllPmc() {
        return _JugadorRepository.findAll();
    }

    @GetMapping("/jugador/{id}")
    public ResponseEntity<Pmc> getPmcById(@PathVariable("id") Integer id) {
        Optional<Pmc> pmcs = _JugadorRepository.findById(id);
        return ResponseEntity.of(pmcs);
    }

    @PostMapping("/jugador")
    public ResponseEntity<Pmc> createPmc(@RequestBody AddPmcDTO pmcDTO) {
        Pmc pmc=_JugadorRepository.save(pmcDTO.toEntity(pmcDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(pmc);
    }

    @PutMapping("/jugador")
    public ResponseEntity<Pmc> updatePmc(@Valid @RequestBody Pmc pmc) {
        Optional<Pmc> pmcs = _JugadorRepository.findById(pmc.getId_player());
        if (!pmcs.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Pmc PmcCreado = _JugadorRepository.save(pmc);
        return ResponseEntity.status(HttpStatus.CREATED).body(PmcCreado);
    }

    @DeleteMapping("/jugador")
    public ResponseEntity<Pmc> deletePmc(@RequestParam(value = "id") int id_pmc) {
        Optional<Pmc> pmcs = _JugadorRepository.findById(id_pmc);
        if (pmcs.isEmpty())
            return ResponseEntity.notFound().build();
        _JugadorRepository.deleteById(pmcs.get().getId_player());
        return ResponseEntity.noContent().build();
    }
}
