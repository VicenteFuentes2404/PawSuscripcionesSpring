package com.example.pawsuscripciones.pawsuscripciones.controller;

import com.example.pawsuscripciones.pawsuscripciones.model.Suscripcion;
import com.example.pawsuscripciones.pawsuscripciones.service.ISuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
@CrossOrigin(origins = "*") // Permite llamadas desde Android o React
public class SuscripcionController {

    @Autowired
    private ISuscripcionService service;

    @GetMapping
    public List<Suscripcion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Suscripcion guardar(@RequestBody Suscripcion suscripcion) {
        return service.guardar(suscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suscripcion> actualizar(@PathVariable Long id, @RequestBody Suscripcion suscripcion) {
        Suscripcion actualizado = service.actualizar(id, suscripcion);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
