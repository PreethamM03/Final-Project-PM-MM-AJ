package com.company.gamestore.controllers;

import com.company.gamestore.service.ServiceLayer;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    // A POST route that creates an invoice
    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel invoice) {
        return serviceLayer.saveInvoice(invoice);
    }

    // A GET route that returns a specific invoice by id
    @GetMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoiceById(@PathVariable Integer id) {
        return serviceLayer.findInvoiceById(id);
    }

    // A GET route that gets all invoices
    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    // A GET route that gets invoices by name
    @GetMapping("/invoices/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getInvoiceByName(@PathVariable String name) {
        return serviceLayer.findInvoiceByName(name);
    }
}
