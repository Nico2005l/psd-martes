package com.clase5.clase5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();
    private AtomicLong idGenerator = new AtomicLong();

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea nuevaTarea) {
        long id = idGenerator.incrementAndGet();
        CrearTareaCommand command = new CrearTareaCommand(nuevaTarea, tareas, id);
        return command.execute();
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTodas() {
        ObtenerTodasTareasCommand command = new ObtenerTodasTareasCommand(tareas);
        return command.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerPorId(@PathVariable long id) {
        ObtenerTareaCommand command = new ObtenerTareaCommand(id, tareas);
        return command.execute();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable long id, @RequestBody Tarea actualizada) {
        ActualizarTareaCommand command = new ActualizarTareaCommand(id, tareas, actualizada);
        return command.execute();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable long id) {
        EliminarTareaCommand command = new EliminarTareaCommand(id, tareas);
        return command.execute();
    }
}

class Tarea {
    private long id;
    private String descripcion;
    private boolean completada;

    public Tarea(long id, String descripcion, boolean completada) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                '}';
    }
}