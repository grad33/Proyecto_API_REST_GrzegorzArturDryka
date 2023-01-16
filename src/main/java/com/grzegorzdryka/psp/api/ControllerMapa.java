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
public class ControllerMapa {

    private final MapaRepository _MapaRepository;

    @Autowired
    public ControllerMapa(MapaRepository mapaRepository) {
        _MapaRepository = mapaRepository;
    }
    @GetMapping("/mapa")
    public Iterable<Mapa> getAllMapas() {
        return _MapaRepository.findAll();
    }

    @GetMapping("/mapa/{id}")
    public ResponseEntity<Mapa> getMapaById(@PathVariable("id") int id) {
        return ResponseEntity.of(_MapaRepository.findById(id));
    }

    @PostMapping("/mapa")
    public ResponseEntity<Mapa> createMapa(@RequestBody AddMapaDTO mapaDTO) {
        Mapa mapa= _MapaRepository.save(mapaDTO.toEntity(mapaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapa);
    }

    @PutMapping("/mapa")
    public ResponseEntity<Mapa> updateMapa(@Valid @RequestBody Mapa map) {
        Optional<Mapa> mapas = _MapaRepository.findById(map.getId());
        if (!mapas.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Mapa MapaCreado = _MapaRepository.save(map);
        return ResponseEntity.status(HttpStatus.CREATED).body(MapaCreado);
    }

    @DeleteMapping("/mapa")
    public ResponseEntity<Mapa> deleteMapa(@RequestParam(value = "id") int id_mapa) {
        Optional<Mapa> mapas = _MapaRepository.findById(id_mapa);
        if (mapas.isEmpty())
            return ResponseEntity.notFound().build();
        _MapaRepository.deleteById(mapas.get().getId());
        return ResponseEntity.noContent().build();
    }
}
