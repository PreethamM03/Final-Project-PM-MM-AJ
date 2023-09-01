package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    // A POST route that creates a game
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return serviceLayer.saveGame(game);
    }

    // A GET route that returns a specific game by id
    @GetMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable Integer id) {
       return serviceLayer.findGameById(id);
    }

    // A GET route that gets all games
    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return serviceLayer.findAllGames();
    }


    // A PUT route that updates game
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game) {
        serviceLayer.updateGame(game);
    }

    // A DELETE route that delete by game ID
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable Integer id) {
        serviceLayer.removeGame(id);
    }

    // A GET route that gets games by studio
    @GetMapping("/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio) {
        return serviceLayer.findGameByStudio(studio);
    }

    // A GET route that gets games by ESRB Rating
    @GetMapping("/games/ESRB/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByEsrbRating(@PathVariable String esrbRating) {
        return serviceLayer.findGameByEsrbRating(esrbRating);
    }

    // A GET route that gets a game by title
    @GetMapping("/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameByTitle(@PathVariable String title) {
        return serviceLayer.findGameByTitle(title);
    }
}
