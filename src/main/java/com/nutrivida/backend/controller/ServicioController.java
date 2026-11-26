package com.nutrivida.backend.controller;

import com.nutrivida.backend.dto.ServicioRequest;
import com.nutrivida.backend.model.Servicio;
import com.nutrivida.backend.repository.ServicioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {
    private final ServicioRepository repository;

    @GetMapping public List<Servicio> listar(@RequestParam(required=false) String tipo) { return tipo == null || tipo.isBlank() ? repository.findAll() : repository.findByTipoIgnoreCaseOrderByIdAsc(tipo); }
    @GetMapping("/{id}") public Servicio obtener(@PathVariable Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado")); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) @PreAuthorize("hasRole('ADMIN')")
    public Servicio crear(@Valid @RequestBody ServicioRequest r) { return repository.save(mapear(new Servicio(), r)); }
    @PutMapping("/{id}") @PreAuthorize("hasRole('ADMIN')")
    public Servicio actualizar(@PathVariable Long id, @Valid @RequestBody ServicioRequest r) { return repository.save(mapear(obtener(id), r)); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id) { if (!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado"); repository.deleteById(id); }
    private Servicio mapear(Servicio s, ServicioRequest r) { s.setTipo(r.tipo().trim().toLowerCase()); s.setNombre(r.nombre()); s.setDescripcion(r.descripcion()); s.setDuracion(r.duracion()); s.setModalidad(r.modalidad()); s.setProfesional(r.profesional()); s.setPrecio(r.precio()); return s; }
}
