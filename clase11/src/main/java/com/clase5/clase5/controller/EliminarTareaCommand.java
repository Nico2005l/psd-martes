package com.clase5.clase5.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;

public class EliminarTareaCommand implements Command {

    private long id;
    private List<Tarea> tareas;

    public EliminarTareaCommand(long id, List<Tarea> tareas) {
        this.id = id;
        this.tareas = tareas;
    }

    @Override
    public ResponseEntity<Void> execute() {
        Iterator<Tarea> it = tareas.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    
}
