package com.clase5.clase5.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class CrearTareaCommand implements Command {

    private Tarea tarea;
    private List<Tarea> tareas;
    private long id;

    public CrearTareaCommand(Tarea tarea, List<Tarea> tareas, long id) {
        this.tarea = tarea;
        this.tareas = tareas;
        this.id = id;
    }

    @Override
    public ResponseEntity<Tarea> execute() {
        tarea.setId(id);
        tarea.setCompletada(false);
        tareas.add(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarea);
    }
}
