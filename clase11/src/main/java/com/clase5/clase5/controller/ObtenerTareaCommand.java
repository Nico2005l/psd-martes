package com.clase5.clase5.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public class ObtenerTareaCommand implements Command {

    private long id;
    private List<Tarea> tareas;

    public ObtenerTareaCommand(long id, List<Tarea> tareas) {
        this.id = id;
        this.tareas = tareas;
    }

    @Override
    public ResponseEntity<Tarea> execute() {
       for (Tarea t : tareas) {
            if (t.getId() == id) {
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    
}
