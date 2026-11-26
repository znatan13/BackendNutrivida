package com.nutrivida.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TrabajadorRequest(
    @NotBlank @Size(max=120) String nombre,
    @Size(max=500) String imagen,
    @NotBlank @Size(max=180) String especialidad,
    @NotBlank @Size(max=180) String diasHorario,
    @NotBlank @Size(max=80) String horario
) {}
