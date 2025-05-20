package com.clase5.clase5.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public class ActualizarTareaCommand implements Command {

    private long id;
    private List<Tarea> tareas;
    private Tarea actualizada;

    public ActualizarTareaCommand(long id, List<Tarea> tareas, Tarea actualizada) {
        this.id = id;
        this.tareas = tareas;
        this.actualizada = actualizada;
    }

    @Override
    public ResponseEntity<Tarea> execute() {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.setDescripcion(actualizada.getDescripcion());
                t.setCompletada(actualizada.isCompletada());
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

   
}
