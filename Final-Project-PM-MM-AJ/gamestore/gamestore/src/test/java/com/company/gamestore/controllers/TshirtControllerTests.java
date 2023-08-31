package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import com.company.gamestore.repositories.TshirtRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebMvcTest(TshirtController.class)
public class TshirtControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TshirtRepository tshirtRepository;

    private ObjectMapper objectMapper = new ObjectMapper();


    // Testing POST /tshirts/
    @Test
    public void shouldAddTshirtAndReturnStatusCreated() throws Exception{

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        String inputJson = objectMapper.writeValueAsString(tshirt);

        mockMvc.perform(
                        post("/tshirts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(inputJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing GET /tshirts/{id}
    @Test
    public void shouldGetTshirtByIdAndReturnStatusOk() throws Exception{

        mockMvc.perform(
                        get("/tshirts/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /tshirts
    @Test
    public void shouldGetAllGamesAndReturnStatusOK() throws Exception{

        mockMvc.perform(
                        get("/tshirts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing PUT /tshirts/
    @Test
    public void shouldUpdateTshirtAndReturnStatusNoContent() throws Exception{

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        String inputJson = objectMapper.writeValueAsString(tshirt);

        mockMvc.perform(
                        put("/tshirts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(inputJson))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing DELETE /tshirts/{id}
    @Test
    public void shouldDeleteTshirtByIdAndReturnStatusOk() throws Exception{

        mockMvc.perform(
                        delete("/tshirts/1"))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing GET /tshirts/color/{color}
    @Test
    public void shouldGetTshirtByColorAndReturnStatusOk() throws Exception{

        mockMvc.perform(
                        get("/tshirts/color/Blue"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /tshirts/size/{size}
    @Test
    public void shouldGetTshirtBySizeAndReturnStatusOk() throws Exception{

        mockMvc.perform(
                        get("/tshirts/size/Medium"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn4xxErrorDueToInvalidId() throws Exception{
        mockMvc.perform(
                        get("/tshirts/id/99999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturn4xxErrorDueToInvalidJson() throws Exception {
        String invalidJson = "{\"size\": \"M\", \"color\": \"Blue\", \"price\": 19.99,}";
        mockMvc.perform(
                        post("/tshirts")
                                .content(invalidJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}