package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.repositories.ConsoleRepository;
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

@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTests {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleRepository consoleRepository;

    // Testing POST /consoles/
    @Test
    public void shouldAddConsoleAndReturnStatusCreated() throws Exception {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        String inputJson = objectMapper.writeValueAsString(console);

        mockMvc.perform(
                        post("/consoles")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing GET /consoles/{id}
    @Test
    public void shouldGetConsoleByIdAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/consoles/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /consoles/
    @Test
    public void shouldGetAllConsolesAndReturnStatusOK() throws Exception {

        mockMvc.perform(
                        get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing PUT /consoles
    @Test
    public void shouldUpdateConsoleAndReturnStatusNoContent() throws Exception {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        String inputJson = objectMapper.writeValueAsString(console);

        mockMvc.perform(
                        put("/consoles")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing DELETE /consoles/{id}
    @Test
    public void shouldDeleteConsoleByIdAndReturnStatusNoContent() throws Exception {

        mockMvc.perform(
                        delete("/consoles/1"))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing GET /consoles/manufacturer/{id}
    @Test
    public void  shouldGetConsoleByManufacturerAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/consoles/manufacturer/Sony"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
