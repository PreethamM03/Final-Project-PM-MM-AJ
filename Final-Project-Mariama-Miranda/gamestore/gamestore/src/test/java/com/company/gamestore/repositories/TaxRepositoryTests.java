package com.company.gamestore.repositories;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Tax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TaxRepositoryTests {

    @Autowired
    TaxRepository taxRepository;

    @BeforeEach
    public void setUp() throws Exception{
        taxRepository.deleteAll();
    }

    @Test
    public void addTax() {
        Tax tax = new Tax();
        tax.setState("VA");
        tax.setRate(BigDecimal.valueOf(0.55));

        taxRepository.save(tax);
        Optional tax1 = taxRepository.findById(tax.getState());

        assertEquals(tax1.get(), tax);
    }

    @Test
    public void getTaxByState() {
        Tax tax = new Tax();
        tax.setState("VA");
        tax.setRate(BigDecimal.valueOf(0.55));

        taxRepository.save(tax);
        Optional tax1 = taxRepository.findById(tax.getState());

        assertEquals(tax1.get(), tax);
    }

    @Test
    public void updateTax() {
        Tax tax = new Tax();
        tax.setState("VA");
        tax.setRate(BigDecimal.valueOf(0.55));

        taxRepository.save(tax);
        tax.setRate(BigDecimal.valueOf(0.55));
        taxRepository.save(tax);
        Optional tax1 = taxRepository.findById(tax.getState());

        assertEquals(tax1.get(), tax);
    }

    @Test
    public void deleteTax() {
        Tax tax = new Tax();
        tax.setState("VA");
        tax.setRate(BigDecimal.valueOf(0.55));

        taxRepository.save(tax);
        taxRepository.deleteById(tax.getState());
        Optional tax1 = taxRepository.findById(tax.getState());

        assertFalse(tax1.isPresent());
    }

}
