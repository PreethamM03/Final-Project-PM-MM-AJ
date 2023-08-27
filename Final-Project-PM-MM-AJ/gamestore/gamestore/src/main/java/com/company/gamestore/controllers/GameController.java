package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    // A POST route that creates a game
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    // A GET route that returns a specific game by id
    @GetMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable Integer id) {
        Optional<Game> returnedGame = gameRepository.findById(id);
        return returnedGame.orElse(null);
    }

    // A GET route that gets all games
    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }


    // A PUT route that updates game
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game) {
        gameRepository.save(game);
    }

    // A DELETE route that delete by game ID
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable Integer id) {
        gameRepository.deleteById(id);
    }

    // A GET route that gets games by studio
    @GetMapping("/games/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio) {
        List<Game> returnedGames = gameRepository.findGameByStudio(studio);
        return returnedGames;
    }

    // A GET route that gets games by ESRB Rating
    @GetMapping("/games/ESRB/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByEsrbRating(@PathVariable String esrbRating) {
        List<Game> returnedGames = gameRepository.findGameByEsrbRating(esrbRating);
        return returnedGames;
    }

    // A GET route that gets a game by title
    @GetMapping("/games/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Game> getGameByTitle(@PathVariable String title) {
        Optional<Game> returnedGame = gameRepository.findGameByTitle(title);
        return returnedGame;
    }
}
