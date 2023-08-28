package com.company.gamestore.repositories;

import com.company.gamestore.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class GameRepositoryTests {

    @Autowired
    GameRepository gameRepository;

    @BeforeEach
    public void setUp() throws Exception{
        gameRepository.deleteAll();
    }

    @Test
    public void addGame() {

        Game game = new Game();
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(), game);
    }

    @Test
    public void getGameById() {

        Game game = new Game();
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(), game);
    }

    @Test
    public void getAllGames() throws Exception {

        Game game1 = new Game();
        game1.setTitle("Assassin's Creed Valhalla");
        game1.setEsrbRating("Mature");
        game1.setDescription("Viking-themed Action RPG");
        game1.setPrice(BigDecimal.valueOf(54.99));
        game1.setStudio("Ubisoft");
        game1.setQuantity(35);

        gameRepository.save(game1);

        Game game2 = new Game();
        game2.setTitle("FIFA 22");
        game2.setEsrbRating("Everyone");
        game2.setDescription("Sports Simulation");
        game2.setPrice(BigDecimal.valueOf(49.99));
        game2.setStudio("Electronic Arts");
        game2.setQuantity(40);

        gameRepository.save(game2);

        List<Game> gameList = gameRepository.findAll();
        assertEquals(gameList.size(), 2);
    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        gameRepository.save(game);

        game.setPrice(BigDecimal.valueOf(70.20));
        game.setQuantity(20);

        gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(), game);
    }

    @Test
    public void deleteGame() {

        Game game = new Game();
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        gameRepository.save(game);

        gameRepository.deleteById(game.getId());

        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertFalse(game1.isPresent());
    }

    @Test
    public void getGameByStudio() {

        Game game1 = new Game();
        game1.setTitle("Sims 4");
        game1.setEsrbRating("Teen");
        game1.setDescription("Life Simulation");
        game1.setPrice(BigDecimal.valueOf(29.99));
        game1.setStudio("Electronic Arts");
        game1.setQuantity(35);

        gameRepository.save(game1);

        Game game2 = new Game();
        game2.setTitle("FIFA 22");
        game2.setEsrbRating("Everyone");
        game2.setDescription("Sports Simulation");
        game2.setPrice(BigDecimal.valueOf(49.99));
        game2.setStudio("Electronic Arts");
        game2.setQuantity(40);

        gameRepository.save(game2);

        Game game3 = new Game();
        game3.setTitle("Cyberpunk 2077");
        game3.setEsrbRating("Mature");
        game3.setDescription("Open-world Sci-Fi RPG");
        game3.setPrice(BigDecimal.valueOf(39.99));
        game3.setStudio("CD Projekt Red");
        game3.setQuantity(15);

        gameRepository.save(game3);

        Game game4 = new Game();
        game4.setTitle("The Legend of Zelda: Breath of the Wild");
        game4.setEsrbRating("Everyone");
        game4.setDescription("Open-world Adventure");
        game4.setPrice(BigDecimal.valueOf(59.99));
        game4.setStudio("Nintendo");
        game4.setQuantity(30);

        gameRepository.save(game4);

        List<Game> gameList = gameRepository.findGameByStudio("Electronic Arts");

        assertEquals(gameList.size(), 2);
    }

    @Test
    public void getGameByEsrbRating() {

        Game game1 = new Game();
        game1.setTitle("Sims 4");
        game1.setEsrbRating("Everyone");
        game1.setDescription("Life Simulation");
        game1.setPrice(BigDecimal.valueOf(29.99));
        game1.setStudio("Electronic Arts");
        game1.setQuantity(35);

        gameRepository.save(game1);

        Game game2 = new Game();
        game2.setTitle("FIFA 22");
        game2.setEsrbRating("Everyone");
        game2.setDescription("Sports Simulation");
        game2.setPrice(BigDecimal.valueOf(49.99));
        game2.setStudio("Electronic Arts");
        game2.setQuantity(40);

        gameRepository.save(game2);

        Game game3 = new Game();
        game3.setTitle("Cyberpunk 2077");
        game3.setEsrbRating("Mature");
        game3.setDescription("Open-world Sci-Fi RPG");
        game3.setPrice(BigDecimal.valueOf(39.99));
        game3.setStudio("CD Projekt Red");
        game3.setQuantity(15);

        gameRepository.save(game3);

        List<Game> gameList = gameRepository.findGameByEsrbRating("Everyone");

        assertEquals(gameList.size(), 2);
    }

    @Test
    public void getGameByTitle() {

        Game game1 = new Game();
        game1.setTitle("Sims 4");
        game1.setEsrbRating("Everyone");
        game1.setDescription("Life Simulation");
        game1.setPrice(BigDecimal.valueOf(29.99));
        game1.setStudio("Electronic Arts");
        game1.setQuantity(35);

        gameRepository.save(game1);

        Game game2 = new Game();
        game2.setTitle("FIFA 22");
        game2.setEsrbRating("Everyone");
        game2.setDescription("Sports Simulation");
        game2.setPrice(BigDecimal.valueOf(49.99));
        game2.setStudio("Electronic Arts");
        game2.setQuantity(40);

        gameRepository.save(game2);

        Optional<Game> game = gameRepository.findGameByTitle("Sims 4");

        assertEquals(game.get(), game1);
    }
}
