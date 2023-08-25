package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import com.company.gamestore.repositories.TshirtRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
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

@WebMvcTest(TshirtController.class)
public class TshirtControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TshirtRepository tshirtRepository;
    private ObjectMapper mapper = new ObjectMapper();


    Tshirt tshirt = new Tshirt("M", "Blue", "Short Sleeved", BigDecimal.valueOf(19.99), 5);

    @BeforeEach
    public void setUp() throws Exception{
        tshirtRepository.deleteAll();
    }


    @Test
    public void testPostTshirtShouldReturn201() throws Exception{
        String tshirtJson = mapper.writeValueAsString(tshirt);

        mockMvc.perform(post("/tshirts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tshirtJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void testPutShouldReturnNoContent() throws Exception{
        String tshirtJson = mapper.writeValueAsString(tshirt);

        mockMvc.perform(put("/tshirts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tshirtJson))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
    @Test
    public void testGetTshirtByIdShouldReturn200() throws Exception{
        int id = tshirt.getId();

        mockMvc.perform(get("/tshirts/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void testGetAllTshirtsShouldReturn200() throws Exception{
        mockMvc.perform(get("/tshirts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteShouldReturnNoContent() throws Exception{
        int id = tshirt.getId();

        mockMvc.perform(delete("/tshirts/{id}", id))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void testGetByColorShouldReturn200() throws Exception{
        String color = tshirt.getColor();

        mockMvc.perform(get("/tshirts/color/{color}", color))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void testGetBySizeShouldReturn200() throws Exception{
        String size = tshirt.getSize();
        mockMvc.perform(get("/tshirts/size/{size}", size))
                .andDo(print())
                .andExpect(status().isOk());
    }
}