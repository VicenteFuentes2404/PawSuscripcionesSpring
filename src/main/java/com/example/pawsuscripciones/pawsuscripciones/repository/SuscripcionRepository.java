package com.example.pawsuscripciones.pawsuscripciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pawsuscripciones.pawsuscripciones.model.Suscripcion;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
}