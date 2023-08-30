package com.company.gamestore.service;

import com.company.gamestore.models.*;
import com.company.gamestore.repositories.*;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {
    ServiceLayer service;
    ConsoleRepository consoleRepository;
    FeeRepository feeRepository;
    GameRepository gameRepository;
    InvoiceRepository invoiceRepository;
    TaxRepository taxRepository;
    TshirtRepository tshirtRepository;

    @BeforeEach
    public void setUp() throws Exception {
        setUpConsoleRepositoryMock();
        setUpGameRepositoryMock();
        setUpTshirtRepositoryMock();
        setUpInvoiceRepositoryMock();
        setUpFeeRepositoryMock();
        setUpTaxRepositoryMock();
        service = new ServiceLayer(consoleRepository,gameRepository,tshirtRepository, invoiceRepository, feeRepository, taxRepository);

    }
    private void setUpConsoleRepositoryMock() {
        consoleRepository = mock(ConsoleRepository.class);

        Console console = new Console();
        console.setId(1);
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        Console console2 = new Console();
        console2.setId(2);
        console2.setModel("2");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("infinite");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);

        List<Console> aList = new ArrayList<>();
        aList.add(console);
        aList.add(console2);

        doReturn(console).when(consoleRepository).save(console);
        doReturn(console2).when(consoleRepository).save(console2);
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(Optional.of(console2)).when(consoleRepository).findById(2);
        doReturn(aList).when(consoleRepository).findAll();
        doReturn(aList).when(consoleRepository).findConsoleByManufacturer("Sony");
    }
    private void setUpGameRepositoryMock() {
        gameRepository = mock(GameRepository.class);

        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game game2 = new Game();
        game2.setId(2);
        game2.setTitle("Assassin's Creed Valhalla");
        game2.setEsrbRating("Mature");
        game2.setDescription("Viking-themed Action RPG");
        game2.setPrice(BigDecimal.valueOf(54.99));
        game2.setStudio("Ubisoft");
        game2.setQuantity(35);

        List<Game> aList = new ArrayList<>();
        aList.add(game);
        aList.add(game2);

        doReturn(game).when(gameRepository).save(game);
        doReturn(game2).when(gameRepository).save(game2);
        doReturn(Optional.of(game)).when(gameRepository).findById(1);
        doReturn(Optional.of(game)).when(gameRepository).findGameByTitle("Assassin's Creed Valhalla");
        doReturn(Optional.of(game2)).when(gameRepository).findById(2);
        doReturn(aList).when(gameRepository).findAll();
        doReturn(aList).when(gameRepository).findGameByStudio("Ubisoft");
        doReturn(aList).when(gameRepository).findGameByEsrbRating("Mature");


    }
    private void setUpTshirtRepositoryMock() {
        tshirtRepository = mock(TshirtRepository.class);

        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setId(2);
        tshirt2.setColor("Blue");
        tshirt2.setDescription("Short sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(19.99));
        tshirt2.setSize("Medium");
        tshirt2.setQuantity(2);

        List<Tshirt> aList = new ArrayList<>();
        aList.add(tshirt);
        aList.add(tshirt2);

        doReturn(tshirt).when(tshirtRepository).save(tshirt);
        doReturn(tshirt2).when(tshirtRepository).save(tshirt2);
        doReturn(Optional.of(tshirt)).when(tshirtRepository).findById(1);
        doReturn(Optional.of(tshirt2)).when(tshirtRepository).findById(2);
        doReturn(aList).when(tshirtRepository).findAll();
        doReturn(aList).when(tshirtRepository).findTshirtByColor("Blue");
        doReturn(aList).when(tshirtRepository).findTshirtBySize("Medium");
    }
    private void setUpInvoiceRepositoryMock() {
        invoiceRepository = mock(InvoiceRepository.class);

        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(BigDecimal.valueOf(15.00));
        invoice.setQuantity(5);
        invoice.setTax(BigDecimal.valueOf(2.25));
        invoice.setProcessingFee(BigDecimal.valueOf(1.50));
        invoice.setSubtotal(BigDecimal.valueOf(75.00));
        invoice.setTotal(BigDecimal.valueOf(78.75));

        Invoice invoice2 = new Invoice();
        invoice2.setId(2);
        invoice2.setName("Alice Johnson");
        invoice2.setStreet("789 Pine St");
        invoice2.setCity("Villageville");
        invoice2.setState("VA");
        invoice2.setZipcode("54321");
        invoice2.setItemType("Game");
        invoice2.setItemId(1);
        invoice2.setUnitPrice(BigDecimal.valueOf(15.00));
        invoice2.setQuantity(5);
        invoice2.setTax(BigDecimal.valueOf(2.25));
        invoice2.setProcessingFee(BigDecimal.valueOf(1.50));
        invoice2.setSubtotal(BigDecimal.valueOf(75.00));
        invoice2.setTotal(BigDecimal.valueOf(78.75));

        List<Invoice> aList = new ArrayList<>();
        aList.add(invoice);
        aList.add(invoice2);

        doReturn(invoice).when(invoiceRepository).save(any());
        doReturn(invoice2).when(invoiceRepository).save(invoice2);
        doReturn(Optional.of(invoice)).when(invoiceRepository).findById(1);
        doReturn(Optional.of(invoice2)).when(invoiceRepository).findById(2);
        doReturn(aList).when(invoiceRepository).findAll();
    }
    private void setUpFeeRepositoryMock() {
        feeRepository = mock(FeeRepository.class);

        Fee fee = new Fee();
        fee.setFee(BigDecimal.valueOf(1.49));
        fee.setProductType("Console");

        Fee fee2 = new Fee();
        fee2.setFee(BigDecimal.valueOf(1.98));
        fee2.setProductType("Game");

        List<Fee> aList = new ArrayList<>();
        aList.add(fee);
        aList.add(fee2);

        doReturn(fee).when(feeRepository).save(fee);
        doReturn(fee2).when(feeRepository).save(fee2);
        doReturn(Optional.of(fee)).when(feeRepository).findById("Console");
        doReturn(Optional.of(fee2)).when(feeRepository).findById("Game");
        doReturn(aList).when(feeRepository).findAll();
    }
    private void setUpTaxRepositoryMock() {
        taxRepository = mock(TaxRepository.class);

        Tax tax = new Tax();
        tax.setState("VA");
        tax.setRate(BigDecimal.valueOf(0.55));

        Tax tax2 = new Tax();
        tax2.setState("WA");
        tax2.setRate(BigDecimal.valueOf(0.05));

        List<Tax> aList = new ArrayList<>();
        aList.add(tax);
        aList.add(tax2);

        doReturn(tax).when(taxRepository).save(tax);
        doReturn(tax2).when(taxRepository).save(tax2);
        doReturn(Optional.of(tax)).when(taxRepository).findById("VA");
        doReturn(Optional.of(tax2)).when(taxRepository).findById("WA");
        doReturn(aList).when(taxRepository).findAll();
    }


    @Test
    public void shouldSaveConsole(){
        Console console = new Console();
        console.setId(1);
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        Console expectedResult = new Console();
        expectedResult.setId(1);
        expectedResult.setModel("2");
        expectedResult.setManufacturer("Sony");
        expectedResult.setMemoryAmount("infinite");
        expectedResult.setProcessor("processor");
        expectedResult.setPrice(BigDecimal.valueOf(499.99));
        expectedResult.setQuantity(1);

        Console consoleReturned = service.saveConsole(console);
        assertEquals(consoleReturned,expectedResult);
    }

    @Test
    public void shouldSaveGame(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game expectedResult = new Game();
        expectedResult.setId(1);
        expectedResult.setTitle("Assassin's Creed Valhalla");
        expectedResult.setEsrbRating("Mature");
        expectedResult.setDescription("Viking-themed Action RPG");
        expectedResult.setPrice(BigDecimal.valueOf(54.99));
        expectedResult.setStudio("Ubisoft");
        expectedResult.setQuantity(35);

        Game gameReturned = service.saveGame(game);
        assertEquals(gameReturned,expectedResult);
    }

    @Test
    public void shouldSaveTshirt(){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt expectedResult = new Tshirt();
        expectedResult.setId(1);
        expectedResult.setColor("Blue");
        expectedResult.setDescription("Short sleeves");
        expectedResult.setPrice(BigDecimal.valueOf(19.99));
        expectedResult.setSize("Medium");
        expectedResult.setQuantity(2);

        Tshirt tshirtReturned = service.saveTshirt(tshirt);
        assertEquals(tshirtReturned,expectedResult);
    }

    @Test
    public void shouldSaveInvoiceViewModel(){
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setQuantity(5);

        InvoiceViewModel expectedResult = new InvoiceViewModel();
        expectedResult.setId(1);
        expectedResult.setName("Alice Johnson");
        expectedResult.setStreet("789 Pine St");
        expectedResult.setCity("Villageville");
        expectedResult.setState("VA");
        expectedResult.setZipcode("54321");
        expectedResult.setItemType("Game");
        expectedResult.setItemId(1);
        expectedResult.setUnitPrice(BigDecimal.valueOf(15.00));
        expectedResult.setQuantity(5);
        expectedResult.setTax(BigDecimal.valueOf(2.25));
        expectedResult.setProcessingFee(BigDecimal.valueOf(1.50));
        expectedResult.setSubtotal(BigDecimal.valueOf(75.00));
        expectedResult.setTotal(BigDecimal.valueOf(78.75));

        InvoiceViewModel invoiceViewModelReturned = service.saveInvoice(invoice);
        assertEquals(invoiceViewModelReturned, expectedResult);
    }

    @Test
    public void shouldFindConsole(){
        Console console = new Console();
        console.setId(1);
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        Console consoleToFind = service.findConsoleById(1);
        assertEquals(consoleToFind,console);
    }

    @Test
    public void shouldFindAllConsoles(){
        Console console = new Console();
        console.setId(1);
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        Console console2 = new Console();
        console2.setId(2);
        console2.setModel("2");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("infinite");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);

        List<Console> consoles = List.of(console,console2);
        List<Console> consolesToFind = service.findAllConsoles();

        assertEquals(consolesToFind.size(), 2);
        assertTrue(consoles.containsAll(consoles));
    }

    @Test
    public void shouldUpdateConsole(){
        Console console = new Console();
        console.setId(1);
        console.setModel("3");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);



        service.updateConsole(console);
        verify(consoleRepository).save(console);
    }

    @Test
    public void shouldRemoveConsole(){
        service.removeConsole(1);
        verify(consoleRepository).deleteById(1);
    }

    @Test
    public void shouldFindConsoleByManufacturer(){
        Console console = new Console();
        console.setId(1);
        console.setModel("2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("infinite");
        console.setProcessor("processor");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(1);

        Console console2 = new Console();
        console2.setId(2);
        console2.setModel("2");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("infinite");
        console2.setProcessor("processor");
        console2.setPrice(BigDecimal.valueOf(499.99));
        console2.setQuantity(1);

        List<Console> consoles = List.of(console,console2);
        List<Console> consolesToFind = service.findConsoleByManufacturer("Sony");

        assertEquals(consolesToFind.size(), 2);
        assertTrue(consolesToFind.containsAll(consoles));
    }

    @Test
    public void shouldFindGameById(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game gameToFind = service.findGameById(1);
        assertEquals(gameToFind,game);
    }

    @Test
    public void shouldFindGameByTitle(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game gameToFind = service.findGameByTitle("Assassin's Creed Valhalla");
        assertEquals(gameToFind,game);
    }

    @Test
    public void shouldFindGameByEsrbRating(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game game2 = new Game();
        game2.setId(2);
        game2.setTitle("Assassin's Creed Valhalla");
        game2.setEsrbRating("Mature");
        game2.setDescription("Viking-themed Action RPG");
        game2.setPrice(BigDecimal.valueOf(54.99));
        game2.setStudio("Ubisoft");
        game2.setQuantity(35);
        List<Game> games = List.of(game,game2);
        List<Game> gamesToFind = service.findGameByEsrbRating("Mature");
        assertEquals(gamesToFind.size(),2);
        assertTrue(gamesToFind.containsAll(games));
    }

    @Test
    public void shouldFindGameByStudio(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game game2 = new Game();
        game2.setId(2);
        game2.setTitle("Assassin's Creed Valhalla");
        game2.setEsrbRating("Mature");
        game2.setDescription("Viking-themed Action RPG");
        game2.setPrice(BigDecimal.valueOf(54.99));
        game2.setStudio("Ubisoft");
        game2.setQuantity(35);
        List<Game> games = List.of(game,game2);
        List<Game> gamesToFind = service.findGameByStudio("Ubisoft");
        assertEquals(gamesToFind.size(),2);
        assertTrue(gamesToFind.containsAll(games));
    }

    @Test
    public void shouldFindAllGames(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        Game game2 = new Game();
        game2.setId(2);
        game2.setTitle("Assassin's Creed Valhalla");
        game2.setEsrbRating("Mature");
        game2.setDescription("Viking-themed Action RPG");
        game2.setPrice(BigDecimal.valueOf(54.99));
        game2.setStudio("Ubisoft");
        game2.setQuantity(35);
        List<Game> games = List.of(game,game2);
        List<Game> gamesToFind = service.findAllGames();
        assertEquals(gamesToFind.size(),2);
        assertTrue(gamesToFind.containsAll(games));
    }

    @Test
    public void shouldUpdateGame(){
        Game game = new Game();
        game.setId(1);
        game.setTitle("Assassin's Creed Valhalla");
        game.setEsrbRating("Mature");
        game.setDescription("Viking-themed Action RPG");
        game.setPrice(BigDecimal.valueOf(54.99));
        game.setStudio("Ubisoft");
        game.setQuantity(35);

        service.updateGame(game);
        verify(gameRepository).save(game);
    }

    @Test
    public void shouldRemoveGame(){
        service.removeGame(1);
        verify(gameRepository).deleteById(1);
    }

    @Test
    public void shouldFindTshirtById(){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt tshirtToFind = service.findTshirtById(1);
        assertEquals(tshirtToFind,tshirt);
    }

    @Test
    public void shouldFindAllTshirts(){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setId(2);
        tshirt2.setColor("Blue");
        tshirt2.setDescription("Short sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(19.99));
        tshirt2.setSize("Medium");
        tshirt2.setQuantity(2);

        List<Tshirt> tshirts = List.of(tshirt, tshirt2);
        List<Tshirt> tshirtsReturned = service.findAllTshirts();
        assertEquals(tshirtsReturned.size(), 2);
        assertTrue(tshirtsReturned.containsAll(tshirts));
    }

    @Test
    public void shouldFindTshirtsByColor(){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setId(2);
        tshirt2.setColor("Blue");
        tshirt2.setDescription("Short sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(19.99));
        tshirt2.setSize("Medium");
        tshirt2.setQuantity(2);

        List<Tshirt> tshirts = List.of(tshirt, tshirt2);
        List<Tshirt> tshirtsReturned = service.findTshirtByColor("Blue");
        assertEquals(tshirtsReturned.size(), 2);
        assertTrue(tshirtsReturned.containsAll(tshirts));
    }

    @Test
    public void shouldFindTshirtsBySize(){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setId(2);
        tshirt2.setColor("Blue");
        tshirt2.setDescription("Short sleeves");
        tshirt2.setPrice(BigDecimal.valueOf(19.99));
        tshirt2.setSize("Medium");
        tshirt2.setQuantity(2);

        List<Tshirt> tshirts = List.of(tshirt, tshirt2);
        List<Tshirt> tshirtsReturned = service.findTshirtBySize("Medium");
        assertEquals(tshirtsReturned.size(), 2);
        assertTrue(tshirtsReturned.containsAll(tshirts));
    }

    @Test
    public void shouldUpdateTshirt(){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setColor("Blue");
        tshirt.setDescription("Short sleeves");
        tshirt.setPrice(BigDecimal.valueOf(19.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(2);

        service.updateTshirt(tshirt);
        verify(tshirtRepository).save(tshirt);
    }

    @Test
    public void shouldRemoveTshirt(){
        service.removeTshirt(1);
        verify(tshirtRepository).deleteById(1);
    }

    @Test
    public void validateOrderRequestValidatesValidOrder(){
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setQuantity(5);

        try {
            service.validateOrderRequest(invoice);
        } catch (Exception e) {
            fail("Exception thrown for valid input");
        }
    }

    @Test
    public void validateOrderRequestThrowsItemNotFound(){
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Game");
        invoice.setItemId(3);
        invoice.setQuantity(5);

        try {
            service.validateOrderRequest(invoice);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
    }

    @Test
    public void validateOrderRequestThrowsIllegalArgumentExceptionForWrongItemType(){
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Product");
        invoice.setItemId(3);
        invoice.setQuantity(5);

        try {
            service.validateOrderRequest(invoice);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void validateOrderRequestThrowsIllegalArgumentExceptionForTooLargeQuantity(){
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Product");
        invoice.setItemId(1);
        invoice.setQuantity(55);

        try {
            service.validateOrderRequest(invoice);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void calculateInvoiceTotalShouldReturnTotal(){
        Invoice invoice = new Invoice();
        invoice.setName("Alice Johnson");
        invoice.setStreet("789 Pine St");
        invoice.setCity("Villageville");
        invoice.setState("VA");
        invoice.setZipcode("54321");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setQuantity(5);

        Invoice expectedResult = new Invoice();
        expectedResult.setId(1);
        expectedResult.setName("Alice Johnson");
        expectedResult.setStreet("789 Pine St");
        expectedResult.setCity("Villageville");
        expectedResult.setState("VA");
        expectedResult.setZipcode("54321");
        expectedResult.setItemType("Game");
        expectedResult.setItemId(1);
        expectedResult.setUnitPrice(BigDecimal.valueOf(15.00));
        expectedResult.setQuantity(5);
        expectedResult.setTax(BigDecimal.valueOf(2.25));
        expectedResult.setProcessingFee(BigDecimal.valueOf(1.50));
        expectedResult.setSubtotal(BigDecimal.valueOf(75.00));
        expectedResult.setTotal(BigDecimal.valueOf(78.75));

        Invoice invoiceReturned = service.calculateInvoiceTotal(invoice);

    }

}
