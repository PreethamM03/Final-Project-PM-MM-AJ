package com.company.gamestore.controllers;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

    // A POST route that creates an invoice
    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // A GET route that returns a specific invoice by id
    @GetMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable Integer id) {
        Optional<Invoice> returnedInvoice = invoiceRepository.findById(id);
        return returnedInvoice.orElse(null);
    }

    // A GET route that gets all invoices
    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // A GET route that gets invoices by name
    @GetMapping("/invoices/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoiceByName(@PathVariable String name) {
        List<Invoice> returnedInvoices = invoiceRepository.findInvoiceByName(name);
        return returnedInvoices;
    }
}
