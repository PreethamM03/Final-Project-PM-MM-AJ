package com.company.gamestore.repositories;

import com.company.gamestore.models.Tshirt;
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
public class TshirtRepositoryTests {

    @Autowired
    TshirtRepository tshirtRepository;

    @BeforeEach
    public void setUp() throws Exception{
        tshirtRepository.deleteAll();
    }

    @Test
    public void addTshirt(){

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        tshirtRepository.save(tshirt);

        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        assertEquals(tshirt1.get(), tshirt);
    }

    @Test
    public void getTshirtById(){

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        tshirtRepository.save(tshirt);

        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        assertEquals(tshirt1.get(), tshirt);
    }

    @Test
    public void getAllTshirts(){

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setColor("Blue");
        tshirt1.setDescription("Short sleeves");
        tshirt1.setPrice(BigDecimal.valueOf(19.99));
        tshirt1.setSize("Medium");
        tshirt1.setQuantity(2);

        tshirtRepository.save(tshirt1);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setColor("Blue");
        tshirt2.setDescription("Short sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(19.99));
        tshirt2.setSize("Medium");
        tshirt2.setQuantity(2);

        tshirtRepository.save(tshirt2);

        List<Tshirt> tshirtList = tshirtRepository.findAll();

        assertEquals(tshirtList.size(), 2);
    }

    @Test
    public void updateTshirt(){

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        tshirtRepository.save(tshirt);

        tshirt.setQuantity(1);

        tshirtRepository.save(tshirt);

        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        assertEquals(tshirt1.get(), tshirt);
    }

    @Test
    public void deleteTshirt(){

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        tshirtRepository.save(tshirt);

        tshirtRepository.deleteById(tshirt.getId());

        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        assertFalse(tshirt1.isPresent());
    }

    @Test
    public void getTshirtByColor(){

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setColor("Blue");
        tshirt1.setDescription("Short sleeves");
        tshirt1.setPrice(BigDecimal.valueOf(19.99));
        tshirt1.setSize("Medium");
        tshirt1.setQuantity(2);

        tshirtRepository.save(tshirt1);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setColor("Red");
        tshirt2.setDescription("Long sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(25.00));
        tshirt2.setSize("Large");
        tshirt2.setQuantity(2);

        tshirtRepository.save(tshirt2);

        List<Tshirt> tshirtList = tshirtRepository.findTshirtByColor("Blue");

        assertEquals(tshirtList.size(), 1);
    }

    @Test
    public void getTshirtBySize(){

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setColor("Blue");
        tshirt1.setDescription("Short sleeves");
        tshirt1.setPrice(BigDecimal.valueOf(19.99));
        tshirt1.setSize("Medium");
        tshirt1.setQuantity(2);

        tshirtRepository.save(tshirt1);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setColor("Red");
        tshirt2.setDescription("Long sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(25.00));
        tshirt2.setSize("Large");
        tshirt2.setQuantity(2);

        tshirtRepository.save(tshirt2);

        List<Tshirt> tshirtList = tshirtRepository.findTshirtBySize("Medium");

        assertEquals(tshirtList.size(), 1);
    }
}