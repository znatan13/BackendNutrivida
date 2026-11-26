package com.nutrivida.backend.controller;

import com.nutrivida.backend.dto.TrabajadorRequest;
import com.nutrivida.backend.model.Trabajador;
import com.nutrivida.backend.repository.TrabajadorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {
    private final TrabajadorRepository repository;

    @GetMapping public List<Trabajador> listar() { return repository.findAll(); }
    @GetMapping("/{id}") public Trabajador obtener(@PathVariable Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabajador no encontrado")); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) @PreAuthorize("hasRole('ADMIN')")
    public Trabajador crear(@Valid @RequestBody TrabajadorRequest r) { return repository.save(Trabajador.builder().nombre(r.nombre()).imagen(r.imagen()).especialidad(r.especialidad()).diasHorario(r.diasHorario()).horario(r.horario()).build()); }
    @PutMapping("/{id}") @PreAuthorize("hasRole('ADMIN')")
    public Trabajador actualizar(@PathVariable Long id, @Valid @RequestBody TrabajadorRequest r) { Trabajador t=obtener(id); t.setNombre(r.nombre()); t.setImagen(r.imagen()); t.setEspecialidad(r.especialidad()); t.setDiasHorario(r.diasHorario()); t.setHorario(r.horario()); return repository.save(t); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id) { if (!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabajador no encontrado"); repository.deleteById(id); }
}
