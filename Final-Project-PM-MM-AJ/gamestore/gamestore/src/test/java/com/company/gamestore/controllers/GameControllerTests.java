package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.repositories.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
public class GameControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GameRepository gameRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {}

    // Testing POST /games/
    @Test
    public void shouldAddGameAndReturnStatusCreated() throws Exception {

        Game game = new Game();
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        String inputJson = objectMapper.writeValueAsString(game);

        mockMvc.perform(
                        post("/games")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing GET /games/{id}
    @Test
    public void shouldGetGameByIdAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/games/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /games
    @Test
    public void shouldGetAllGamesAndReturnStatusOK() throws  Exception {

        mockMvc.perform(
                        get("/games"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing PUT /games/
    @Test
    public void shouldUpdateGameAndReturnStatusNoContent() throws Exception {

        Game game = new Game();
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(new BigDecimal("54.99"));
        game.setStudio("Ubisoft");
        game.setQuantity(20);

        String inputJson = objectMapper.writeValueAsString(game);

        mockMvc.perform(
                        put("/games")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());   // Created Status should be 204;
    }

    // Testing DELETE games/{id}
    @Test
    public void shouldDeleteGameByIdAndReturnStatusNoContent() throws Exception {

        mockMvc.perform(
                        delete("/games/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing GET /games/studio/{studio}
    @Test
    public void shouldGetGameByStudioAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/games/studio/Ubisoft"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /games/ESRB/{esrbRating}
    @Test
    public void shouldGetGameByEsrbRatingAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/games/ESRB/Mature"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /games/title/{title}
    @Test
    public void shouldGetGameByTitleAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/games/title/Assassin's Creed Valhalla"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
