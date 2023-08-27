package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleRepository consoleRepository;

    // A POST route that creates a console
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody Console console) {
        return consoleRepository.save(console);
    }

    // A GET route that returns a specific console by id
    @GetMapping("/consoles/{id}")
    public Console getConsoleById(@PathVariable int id) {
        Optional<Console> returnedConsole = consoleRepository.findById(id);
        return returnedConsole.orElse(null);
    }

    // A GET route that gets all consoles
    @GetMapping("/consoles")
    public List<Console> getAllConsoles() {
        return consoleRepository.findAll();
    }

    // A PUT route that updates console
    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Console updateConsole(@RequestBody Console console) {
        return consoleRepository.save(console);
    }

    // A DELETE route that delete by console ID
    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsoleById(@PathVariable int id) {
        consoleRepository.deleteById(id);
    }

    // A GET route that gets consoles by manufacturer
    @GetMapping("/consoles/manufacturer/{manufacturer}")
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer) {
        List<Console> returnedConsoles = consoleRepository.findConsoleByManufacturer(manufacturer);
        return returnedConsoles;
    }
}
