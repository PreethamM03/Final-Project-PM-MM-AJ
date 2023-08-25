package com.company.gamestore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

//create table console (
//    console_id int primary key auto_increment,
//    model varchar(50) not null,
//    manufacturer varchar(50) not null,
//    memory_amount varchar(20),
//    processor varchar(20),
//    price decimal(5, 2) not null,
//    quantity int not null
//);
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Console")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "console_id")
    private int id;

    private String model;

    private String manufacturer;

    private String memoryAmount;

    private String processor;

    private BigDecimal price;

    private int quantity;


    public int getId() {
        return id;
    }

    public Console(){}

    public Console(String model, String manufacturer, String memoryAmount, String processor, BigDecimal price, int quantity) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.memoryAmount = memoryAmount;
        this.processor = processor;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Console)) return false;
        Console console = (Console) o;
        return getId() == console.getId() && getQuantity() == console.getQuantity() && Objects.equals(getModel(), console.getModel()) && Objects.equals(getManufacturer(), console.getManufacturer()) && Objects.equals(getMemoryAmount(), console.getMemoryAmount()) && Objects.equals(getProcessor(), console.getProcessor()) && Objects.equals(getPrice(), console.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "Console{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryAmount='" + memoryAmount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
