package com.example.pawsuscripciones.pawsuscripciones.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double monto;

    //ahora es Long en vez de LocalDate
    @Column(name = "fecha_vencimiento")
    private Long fechaVencimiento;

    @Column(name = "metodo_pago")
    private String metodoPago;

    private String etiqueta;
}
