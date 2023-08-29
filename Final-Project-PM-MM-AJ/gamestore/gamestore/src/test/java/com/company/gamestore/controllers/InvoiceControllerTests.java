package com.company.gamestore.controllers;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.repositories.InvoiceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTests {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceRepository invoiceRepository;

    // Testing POST /invoices/
    @Test
    public void shouldAddInvoiceAndReturnStatusCreated() throws Exception {

        Invoice invoice = new Invoice();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("Stateville");
        invoice.setZipcode("54321");
        invoice.setItemType("Product");
        invoice.setItemId(3);
        invoice.setUnitPrice(BigDecimal.valueOf(15.00));
        invoice.setQuantity(5);
        invoice.setTax(BigDecimal.valueOf(2.25));
        invoice.setProcessingFee(BigDecimal.valueOf(1.50));
        invoice.setSubtotal(BigDecimal.valueOf(75.00));
        invoice.setTotal(BigDecimal.valueOf(78.75));

        String inputJson = objectMapper.writeValueAsString(invoice);

        mockMvc.perform(
                        post("/invoices")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing GET /invoices/{id}
    @Test
    public void shouldGetInvoiceByIdAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/invoices/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /invoices
    @Test
    public void shouldGetAllInvoicesAndReturnStatusOK() throws  Exception {

        mockMvc.perform(
                        get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET /invoices/name/{name}
    @Test
    public void shouldGetInvoiceByNameAndReturnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/invoices/name/Alice Johnson"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
