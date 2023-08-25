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
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTests {

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    private List<Console> consoleList;

    @MockBean
    private ConsoleRepository consoleRepository;


    private LocalDate date;

    // Testing POST /consoles/

//    console_id int primary key auto_increment,
//    model varchar(50) not null,
//    manufacturer varchar(50) not null,
//    memory_amount varchar(20),
//    processor varchar(20),
//    price decimal(5, 2) not null,
//    quantity int not null
    @Test
    public void shouldReturnConsole() throws Exception {


        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        String inputJson = mapper.writeValueAsString(console);
        Console console2 = new Console();
        console2.setModel("2");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("infinite");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);



        mockMvc.perform(post("/consoles")
                        .content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }

    // Testing GET /consoles/{id}
    @Test
    public void shouldReturnConsolebyId() throws Exception {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        console.setId(1);

        mockMvc.perform(get("/consoles/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // Testing GET /consoles/
    @Test
    public void shouldReturnAllConsoles() throws Exception {

        mockMvc.perform(get("/consoles")).andDo(print()).andExpect(status().isOk());

    }

    // Testing PUT /consoles
    @Test
    public void shouldUpdateConsole() throws Exception {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        console.setId(1);

        String inputJson = mapper.writeValueAsString(console);

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
    public void shouldDeleteConsoleById() throws Exception {
        mockMvc.perform(delete("/consoles/1")).andDo(print()).andExpect(status().isNoContent());

    }

    // Testing GET /consoles/author/{id}
    @Test
    public void getReturnConsoleByManufacturer() throws Exception {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        console.setId(1);

        mockMvc.perform(get("/consoles/manufacturer/Sony"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
