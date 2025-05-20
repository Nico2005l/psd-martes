package com.clase5.clase5.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface Command {
    Object execute();
}