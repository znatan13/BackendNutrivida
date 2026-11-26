package com.nutrivida.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trabajadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String nombre;
    @Column(length = 500)
    private String imagen;
    @Column(nullable = false, length = 180)
    private String especialidad;
    @Column(name = "dias_horario", nullable = false, length = 180)
    private String diasHorario;
    @Column(nullable = false, length = 80)
    private String horario;
}
