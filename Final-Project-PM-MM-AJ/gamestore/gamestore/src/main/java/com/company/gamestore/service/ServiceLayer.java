package com.company.gamestore.service;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.models.Invoice;
import com.company.gamestore.models.Tshirt;
import com.company.gamestore.repositories.*;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;

    private GameRepository gameRepository;

    private TshirtRepository tshirtRepository;

    private InvoiceRepository invoiceRepository;

    private FeeRepository feeRepository;

    private TaxRepository taxRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository,
                        TshirtRepository tshirtRepository, InvoiceRepository invoiceRepository,
                        FeeRepository feeRepository, TaxRepository taxRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tshirtRepository = tshirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.feeRepository = feeRepository;
        this.taxRepository = taxRepository;
    }

    //
    //   Invoice API
    //

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setUnitPrice(ivm.getUnitPrice());
        ivm.setTax(ivm.getTax());
        ivm.setSubtotal(ivm.getSubtotal());
        ivm.setProcessingFee(ivm.getProcessingFee());
        ivm.setTotal(ivm.getTotal());

        return ivm;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {

        //business rules

        Invoice invoice = new Invoice();
        //invoice.setId(viewModel.getId());
        invoice.setStreet(viewModel.getStreet());
        invoice.setCity(viewModel.getCity());
        invoice.setState(viewModel.getState());
        invoice.setZipcode(viewModel.getZipcode());
        invoice.setItemType(viewModel.getItemType());
        invoice.setItemId(viewModel.getItemId());
        invoice.setQuantity(viewModel.getQuantity());

        //calculations

        invoice = invoiceRepository.save(invoice);
        viewModel.setId(invoice.getId());

        //set view model calculations

        return viewModel;
    }

    public InvoiceViewModel findInvoiceById(Integer id) {
        Optional<Invoice> returnedInvoice = invoiceRepository.findById(id);
        return returnedInvoice.isPresent() ? buildInvoiceViewModel(returnedInvoice.get()) : null;
    }

    public List<InvoiceViewModel> findAllInvoices() {
        List<Invoice> returnedInvoices = invoiceRepository.findAll();

        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for(Invoice invoice: returnedInvoices) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    public List<InvoiceViewModel> findInvoiceByName(String name) {
        List<Invoice> returnedInvoices = invoiceRepository.findInvoiceByName(name);

        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for(Invoice invoice: returnedInvoices) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    //
    //   Console API
    //
    public Console saveConsole(Console console) {
        return consoleRepository.save(console);
    }

    public Console findConsoleById(Integer id) {
        Optional<Console> returnedConsole = consoleRepository.findById(id);
        return returnedConsole.orElse(null);
    }

    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    public void updateConsole(Console console) {
        consoleRepository.save(console);
    }

    public void removeConsole(Integer id) {
        consoleRepository.deleteById(id);
    }

    public List<Console> findConsoleByManufacturer(String manufacturer) {
        List<Console> returnedConsoles = consoleRepository.findConsoleByManufacturer(manufacturer);
        return returnedConsoles;
    }

    //
    //   Game API
    //
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public Game findGameById(Integer id) {
        Optional<Game> returnedGame = gameRepository.findById(id);
        return returnedGame.orElse(null);
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public void updateGame(Game game) {
        gameRepository.save(game);
    }

    public void removeGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public List<Game> findGameByStudio(String studio) {
        List<Game> returnedGames = gameRepository.findGameByStudio(studio);
        return returnedGames;
    }

    public List<Game> findGameByEsrbRating(String esrbRating) {
        List<Game> returnedGames = gameRepository.findGameByEsrbRating(esrbRating);
        return returnedGames;
    }

    public Game findGameByTitle(String title) {
        Optional<Game> returnedGame = gameRepository.findGameByTitle(title);
        return returnedGame.orElse(null);
    }

    //
    //   Tshirt API
    //
    public Tshirt saveTshirt(Tshirt tshirt) {
        return tshirtRepository.save(tshirt);
    }

    public Tshirt findTshirtById(Integer id) {
        Optional<Tshirt> returnedTshirt = tshirtRepository.findById(id);
        return returnedTshirt.orElse(null);
    }

    public List<Tshirt> findAllTshirts() {
        return tshirtRepository.findAll();
    }

    public void updateTshirt(Tshirt tshirt) {
        tshirtRepository.save(tshirt);
    }

    public void removeTshirt(Integer id) {
        tshirtRepository.deleteById(id);
    }

    public List<Tshirt> findTshirtByColor(String color) {
        List<Tshirt> returnedTshirts = tshirtRepository.findTshirtByColor(color);
        return returnedTshirts;
    }

    public List<Tshirt> findTshirtBySize(String size) {
        List<Tshirt> returnedTshirts = tshirtRepository.findTshirtBySize(size);
        return returnedTshirts;
    }


    //Order quantity must be less than or equal to the number of items available in the inventory.

    //The order must contain a valid state code.

    public void validateOrderRequest(InvoiceViewModel viewModel) {
    }
}

