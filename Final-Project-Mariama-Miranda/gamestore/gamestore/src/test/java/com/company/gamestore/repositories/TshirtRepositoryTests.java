package com.company.gamestore.repositories;

import com.company.gamestore.models.Tshirt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TshirtRepositoryTests {

    @Autowired
    TshirtRepository tshirtRepository;

    @BeforeEach
    public void setUp() throws Exception{
        tshirtRepository.deleteAll();
    }

    @Test
    public void shouldAddTshirt(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        //Act
        tshirt = tshirtRepository.save(tshirt);
        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        //Assert
        assertEquals(tshirt1.get(), tshirt);
    }

    @Test
    public void shouldGetAllTshirts(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setColor("Blue");
        tshirt2.setDescription("Short sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(19.99));
        tshirt2.setSize("Medium");
        tshirt2.setQuantity(2);

        //Act
        tshirtRepository.save(tshirt);
        tshirtRepository.save(tshirt2);
        List<Tshirt> tshirtList = tshirtRepository.findAll();

        //Arrange
        assertEquals(2, tshirtList.size());
    }

    @Test
    public void shouldGetTshirtById(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        //Act
        tshirt = tshirtRepository.save(tshirt);
        int id = tshirt.getId();
        Optional<Tshirt> foundTshirt = tshirtRepository.findById(id);

        //Assert
        assertEquals(foundTshirt.get(), tshirt);
    }

    @Test
    public void shouldUpdateTshirt(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        //Act
        tshirt = tshirtRepository.save(tshirt);
        tshirt.setQuantity(1);
        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        //Assert
        assertNotEquals(tshirt1.get(), tshirt);
    }

    @Test
    public void shouldDeleteTshirt(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        //Act
        tshirt = tshirtRepository.save(tshirt);
        tshirtRepository.delete(tshirt);

        //Assert
        assertFalse(tshirtRepository.findById(tshirt.getId()).isPresent());
    }

    @Test
    public void shouldGetTshirtByColor(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        //Act
        tshirt = tshirtRepository.save(tshirt);
        String color = "Blue";
        List<Tshirt> foundTshirt = tshirtRepository.findByColor(color);

        //Assert
        assertTrue(foundTshirt.contains(tshirt));
    }

    @Test
    public void shouldGetTshirtBySize(){
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        //Act
        tshirt = tshirtRepository.save(tshirt);
        String size = "Medium";
        List<Tshirt> foundTshirt = tshirtRepository.findBySize(size);

        //Assert
        assertTrue(foundTshirt.contains(tshirt));
    }
}