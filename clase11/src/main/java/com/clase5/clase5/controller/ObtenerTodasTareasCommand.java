package com.clase5.clase5.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public class ObtenerTodasTareasCommand implements Command {

    private List<Tarea> tareas;

    public ObtenerTodasTareasCommand(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public ResponseEntity<List<Tarea>> execute() {
        return ResponseEntity.ok(tareas);
    }
    
}
