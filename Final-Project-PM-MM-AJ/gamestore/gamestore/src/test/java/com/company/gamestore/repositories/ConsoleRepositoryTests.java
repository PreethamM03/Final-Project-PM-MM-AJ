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

    @BeforeEach
    public void setUp() throws Exception{
        consoleRepository.deleteAll();
    }

    @Test
    public void addConsole() {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);
    }

    @Test
    public void getConsoleById() {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);
    }

    @Test
    public void getAllConsoles() {

        Console console1 = new Console();
        console1.setModel("2");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("infinite");
        console1.setProcessor("processor");
        console1.setPrice(BigDecimal.valueOf(499.99));
        console1.setQuantity(1);

        consoleRepository.save(console1);

        Console console2 = new Console();
        console2.setModel("2");
        console2.setManufacturer("Xbox");
        console2.setMemoryAmount("30GB");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);

        consoleRepository.save(console2);

        List<Console> consoleList = consoleRepository.findAll();

        assertEquals(consoleList.size(), 2);
    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        consoleRepository.save(console);

        console.setModel("Modelll");

        consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);
    }

    @Test
    public void deleteConsole() {

        Console console = new Console();
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        consoleRepository.save(console);

        consoleRepository.deleteById(console.getId());

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertFalse(console1.isPresent());
    }

    @Test
    public void getConsoleByManufacturer() {

        Console console1 = new Console();
        console1.setModel("2");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("infinite");
        console1.setProcessor("processor");
        console1.setPrice(BigDecimal.valueOf(499.99));
        console1.setQuantity(1);

        consoleRepository.save(console1);

        Console console2 = new Console();
        console2.setModel("2");
        console2.setManufacturer("Xbox");
        console2.setMemoryAmount("30GB");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);

        consoleRepository.save(console2);

        List<Console> consoleList = consoleRepository.findConsoleByManufacturer(console1.getManufacturer());

        assertEquals(consoleList.size(), 1);
    }
}
