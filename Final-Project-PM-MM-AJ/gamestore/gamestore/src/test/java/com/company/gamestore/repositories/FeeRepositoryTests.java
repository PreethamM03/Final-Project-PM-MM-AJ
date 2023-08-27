package com.company.gamestore.repositories;

import com.company.gamestore.models.Fee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class FeeRepositoryTests {

    @Autowired
    FeeRepository feeRepository;

    @BeforeEach
    public void setUp() throws Exception{
        feeRepository.deleteAll();
    }

    @Test
    public void addFee() {
        Fee fee = new Fee();
        fee.setFee(BigDecimal.valueOf(0.55));
        fee.setProductType("Console");

        feeRepository.save(fee);
        Optional fee1 = feeRepository.findById(fee.getProductType());

        assertEquals(fee1.get(), fee);
    }

    @Test
    public void getFeeByState() {
        Fee fee = new Fee();
        fee.setFee(BigDecimal.valueOf(0.55));
        fee.setProductType("Console");

        feeRepository.save(fee);
        Optional fee1 = feeRepository.findById(fee.getProductType());

        assertEquals(fee1.get(), fee);
    }

    @Test
    public void updateFee() {
        Fee fee = new Fee();
        fee.setFee(BigDecimal.valueOf(0.50));
        fee.setProductType("Console");

        feeRepository.save(fee);
        fee.setFee(BigDecimal.valueOf(0.55));
        feeRepository.save(fee);
        Optional fee1 = feeRepository.findById(fee.getProductType());

        assertEquals(fee1.get(), fee);
    }

    @Test
    public void deleteFee() {
        Fee fee = new Fee();
        fee.setFee(BigDecimal.valueOf(0.55));
        fee.setProductType("Console");

        feeRepository.save(fee);
        feeRepository.deleteById(fee.getProductType());
        Optional fee1 = feeRepository.findById(fee.getProductType());

        assertFalse(fee1.isPresent());
    }

}
