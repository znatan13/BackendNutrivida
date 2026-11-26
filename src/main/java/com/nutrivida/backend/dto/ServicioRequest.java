package com.nutrivida.backend.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ServicioRequest(
    @NotBlank @Size(max=30) String tipo,
    @NotBlank @Size(max=150) String nombre,
    @NotBlank @Size(max=1000) String descripcion,
    @NotBlank @Size(max=80) String duracion,
    @NotBlank @Size(max=80) String modalidad,
    @NotBlank @Size(max=120) String profesional,
    @NotNull @DecimalMin("0.0") BigDecimal precio
) {}
