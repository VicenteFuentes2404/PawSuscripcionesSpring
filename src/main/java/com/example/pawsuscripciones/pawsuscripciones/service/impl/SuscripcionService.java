package com.example.pawsuscripciones.pawsuscripciones.service.impl;

import com.example.pawsuscripciones.pawsuscripciones.model.Suscripcion;
import com.example.pawsuscripciones.pawsuscripciones.repository.SuscripcionRepository;
import com.example.pawsuscripciones.pawsuscripciones.service.ISuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService implements ISuscripcionService {

    @Autowired
    private SuscripcionRepository repository;

    @Override
    public List<Suscripcion> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Suscripcion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Suscripcion guardar(Suscripcion suscripcion) {
        return repository.save(suscripcion);
    }

    @Override
    public Suscripcion actualizar(Long id, Suscripcion suscripcion) {
        Optional<Suscripcion> existente = repository.findById(id);
        if (existente.isPresent()) {
            Suscripcion s = existente.get();
            s.setNombre(suscripcion.getNombre());
            s.setMonto(suscripcion.getMonto());
            s.setFechaVencimiento(suscripcion.getFechaVencimiento()); // ✅ tipo Long
            s.setMetodoPago(suscripcion.getMetodoPago());
            s.setEtiqueta(suscripcion.getEtiqueta());
            return repository.save(s);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
