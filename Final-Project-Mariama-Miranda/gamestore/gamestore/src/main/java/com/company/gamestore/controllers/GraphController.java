package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
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


    //GET all Consoles
    @QueryMapping
    public List<Console> getConsoles() {
        return consoleRepository.findAll();
    }
    //GET Console by ID
    @QueryMapping
    public Console getConsoleById(@Argument Integer id) {
        Optional<Console> console = consoleRepository.findById(id);
        if (console.isPresent()) {
            return console.get();
        }else {
            return null;
        }
    }

   //GET Consoles by Manufacturer
    @QueryMapping
    public List<Console> getConsoleByManufacturer(@Argument String manufacturer) {
        return consoleRepository.findConsoleByManufacturer(manufacturer);
    }

    //GET all Games
    @QueryMapping
    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    //GET Game by ID
    @QueryMapping
    public Game getGameById(@Argument Integer id){
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()){
            return game.get();
        } else{
            return null;
        }
    }

    //GET Game by Title
    @QueryMapping
    public Optional<Game> getGameByTitle(@Argument String title){
        return gameRepository.findGameByTitle(title);
    }

    //GET Games by ESRB Rating
    @QueryMapping
    public List<Game> getGameByEsrbRating(@Argument String esrbRating){
        return gameRepository.findGameByEsrbRating(esrbRating);
    }

    //GET Games by Studio
    @QueryMapping
    public List<Game> getGameByStudio(@Argument String studio){
        return gameRepository.findGameByStudio(studio);
    }
}
