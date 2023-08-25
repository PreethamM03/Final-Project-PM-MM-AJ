package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.repositories.ConsoleRepository;
import com.company.gamestore.repositories.GameRepository;
import com.company.gamestore.repositories.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    ConsoleRepository consoleRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    TshirtRepository tshirtRepository;

    @QueryMapping
    public Console getConsoleById(@Argument int id) {
        Optional<Console> console = consoleRepository.findById(id);
        if (console.isPresent()) {
            return console.get();
        }else {
            return null;
        }
    }
    @QueryMapping
    public List<Console> getConsoles() {
        return consoleRepository.findAll();
    }

    @QueryMapping
    public List<Console> getConsoleByManufacturer(String manufacturer) {
        return consoleRepository.findConsoleByManufacturer(manufacturer);
    }
}
