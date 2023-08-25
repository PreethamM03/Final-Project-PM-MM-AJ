package com.company.gamestore.repositories;

import com.company.gamestore.models.Console;
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
public class ConsoleRepositoryTests {
    @Autowired
    ConsoleRepository consoleRepository;

    private Console console;
    private Console console2;

    @BeforeEach
    public void setUp() throws Exception{
        consoleRepository.deleteAll();
    }

    @Test
    public void addConsole() {
        console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        consoleRepository.save(console);

        Optional console1 = consoleRepository.findById(console.getId());
        assertEquals(console1.get(), console);
    }
    @Test
    public void getConsoleById() {
        console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        consoleRepository.save(console);

        Optional console1 = consoleRepository.findById(console.getId());
        assertEquals(console1.get(), console);
    }
    @Test
    public void getAllConsoles() {
        console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        consoleRepository.save(console);

        console2 = new Console();
        console2.setModel("2");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("infinite");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);
        consoleRepository.save(console2);
        List<Console> consoles = consoleRepository.findAll();
        assertEquals(consoles.size(), 2);
    }

    @Test
    public void updateConsole() {
        console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        consoleRepository.save(console);

        console.setModel("Modelll");
        consoleRepository.save(console);

        Optional console1 = consoleRepository.findById(console.getId());
        assertEquals(console1.get(), console);
    }
    @Test
    public void deleteConsole() {
        console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);
        consoleRepository.save(console);

        consoleRepository.deleteById(console.getId());

        Optional author1 = consoleRepository.findById(console.getId());
        assertFalse(author1.isPresent());
    }
}
