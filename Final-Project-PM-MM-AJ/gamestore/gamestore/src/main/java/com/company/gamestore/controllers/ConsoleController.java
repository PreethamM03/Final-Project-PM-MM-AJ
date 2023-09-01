package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    // A POST route that creates a console
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody @Valid Console console) {
        return serviceLayer.saveConsole(console);
    }

    // A GET route that returns a specific console by id
    @GetMapping("/consoles/{id}")
    public Console getConsoleById(@PathVariable int id) {
        return serviceLayer.findConsoleById(id);
    }

    // A GET route that gets all consoles
    @GetMapping("/consoles")
    public List<Console> getAllConsoles() {
        return serviceLayer.findAllConsoles();
    }

    // A PUT route that updates console
    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console) {
        serviceLayer.updateConsole(console);
    }

    // A DELETE route that delete by console ID
    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsoleById(@PathVariable int id) {
        serviceLayer.removeConsole(id);
    }

    // A GET route that gets consoles by manufacturer
    @GetMapping("/consoles/manufacturer/{manufacturer}")
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.findConsoleByManufacturer(manufacturer);
    }
}
