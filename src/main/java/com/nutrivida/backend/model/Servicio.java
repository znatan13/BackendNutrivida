package com.nutrivida.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String tipo;
    @Column(nullable = false, length = 150)
    private String nombre;
    @Column(nullable = false, length = 1000)
    private String descripcion;
    @Column(nullable = false, length = 80)
    private String duracion;
    @Column(nullable = false, length = 80)
    private String modalidad;
    @Column(nullable = false, length = 120)
    private String profesional;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
}
