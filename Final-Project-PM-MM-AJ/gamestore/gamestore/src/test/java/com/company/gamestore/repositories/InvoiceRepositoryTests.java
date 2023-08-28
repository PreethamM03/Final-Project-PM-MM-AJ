package com.company.gamestore.repositories;

import com.company.gamestore.models.Invoice;
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
public class InvoiceRepositoryTests {

    @Autowired
    InvoiceRepository invoiceRepository;

    @BeforeEach
    public void setUp() throws Exception{
        invoiceRepository.deleteAll();
    }

    @Test
    public void addInvoice() {

        Invoice invoice = new Invoice();
        invoice.setCity("New York");
        invoice.setQuantity(2);
        invoice.setName("name");
        invoice.setItemId(2);
        invoice.setItemType("console");
        invoice.setProcessingFee(BigDecimal.valueOf(.33));
        invoice.setStreet("1st Street");
        invoice.setSubtotal(BigDecimal.valueOf(9.99));
        invoice.setState("VA");
        invoice.setTotal(BigDecimal.valueOf(10.99));
        invoice.setTax(BigDecimal.valueOf(.99));
        invoice.setUnitPrice(BigDecimal.valueOf(8.99));
        invoice.setZipcode("22222");


        invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertEquals(invoice1.get(), invoice);
    }

    @Test
    public void getInvoiceById() {

        Invoice invoice = new Invoice();
        invoice.setCity("New York");
        invoice.setQuantity(2);
        invoice.setName("name");
        invoice.setItemId(2);
        invoice.setItemType("console");
        invoice.setProcessingFee(BigDecimal.valueOf(.33));
        invoice.setStreet("1st Street");
        invoice.setSubtotal(BigDecimal.valueOf(9.99));
        invoice.setState("VA");
        invoice.setTotal(BigDecimal.valueOf(10.99));
        invoice.setTax(BigDecimal.valueOf(.99));
        invoice.setUnitPrice(BigDecimal.valueOf(8.99));
        invoice.setZipcode("22222");


        invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertEquals(invoice1.get(), invoice);
    }

    @Test
    public void getAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setCity("New York");
        invoice.setQuantity(2);
        invoice.setName("name");
        invoice.setItemId(2);
        invoice.setItemType("console");
        invoice.setProcessingFee(BigDecimal.valueOf(.33));
        invoice.setStreet("1st Street");
        invoice.setSubtotal(BigDecimal.valueOf(9.99));
        invoice.setState("VA");
        invoice.setTotal(BigDecimal.valueOf(10.99));
        invoice.setTax(BigDecimal.valueOf(.99));
        invoice.setUnitPrice(BigDecimal.valueOf(8.99));
        invoice.setZipcode("22222");
        invoiceRepository.save(invoice);

        Invoice invoice2 = new Invoice();
        invoice2.setCity("New York");
        invoice2.setQuantity(2);
        invoice2.setName("name");
        invoice2.setItemId(2);
        invoice2.setItemType("console");
        invoice2.setProcessingFee(BigDecimal.valueOf(.33));
        invoice2.setStreet("1st Street");
        invoice2.setSubtotal(BigDecimal.valueOf(9.99));
        invoice2.setState("VA");
        invoice2.setTotal(BigDecimal.valueOf(10.99));
        invoice2.setTax(BigDecimal.valueOf(.99));
        invoice2.setUnitPrice(BigDecimal.valueOf(8.99));
        invoice2.setZipcode("22222");
        invoiceRepository.save(invoice2);

        List<Invoice> invoices = invoiceRepository.findAll();

        assertEquals(invoices.size(), 2);
    }

    @Test
    public void updateInvoice() {

        Invoice invoice = new Invoice();
        invoice.setCity("New York");
        invoice.setQuantity(2);
        invoice.setName("name");
        invoice.setItemId(2);
        invoice.setItemType("console");
        invoice.setProcessingFee(BigDecimal.valueOf(.33));
        invoice.setStreet("1st Street");
        invoice.setSubtotal(BigDecimal.valueOf(9.99));
        invoice.setState("VA");
        invoice.setTotal(BigDecimal.valueOf(10.99));
        invoice.setTax(BigDecimal.valueOf(.99));
        invoice.setUnitPrice(BigDecimal.valueOf(8.99));
        invoice.setZipcode("22222");
        invoiceRepository.save(invoice);

        invoice.setName("name2");
        invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertEquals(invoice1.get(), invoice);
    }

    @Test
    public void deleteInvoice() {

        Invoice invoice = new Invoice();
        invoice.setCity("New York");
        invoice.setQuantity(2);
        invoice.setName("name");
        invoice.setItemId(2);
        invoice.setItemType("console");
        invoice.setProcessingFee(BigDecimal.valueOf(.33));
        invoice.setStreet("1st Street");
        invoice.setSubtotal(BigDecimal.valueOf(9.99));
        invoice.setState("VA");
        invoice.setTotal(BigDecimal.valueOf(10.99));
        invoice.setTax(BigDecimal.valueOf(.99));
        invoice.setUnitPrice(BigDecimal.valueOf(8.99));
        invoice.setZipcode("22222");
        invoiceRepository.save(invoice);

        invoiceRepository.delete(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertFalse(invoice1.isPresent());
    }

}
