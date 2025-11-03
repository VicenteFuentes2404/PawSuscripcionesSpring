package com.example.pawsuscripciones.pawsuscripciones.service;

import com.example.pawsuscripciones.pawsuscripciones.model.Suscripcion;
import java.util.List;
import java.util.Optional;

public interface ISuscripcionService {

    List<Suscripcion> listar();

    Optional<Suscripcion> obtenerPorId(Long id);

    Suscripcion guardar(Suscripcion suscripcion);

    Suscripcion actualizar(Long id, Suscripcion suscripcion);

    void eliminar(Long id);
}
