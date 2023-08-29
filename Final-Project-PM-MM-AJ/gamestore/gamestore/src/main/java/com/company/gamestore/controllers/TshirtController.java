package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TshirtController {

    @Autowired
    ServiceLayer serviceLayer;

    // A POST route that creates a tshirt
    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt){
        return serviceLayer.saveTshirt(tshirt);
    }

   // A GET route that returns a specific tshirt by id
    @GetMapping("/tshirts/{id}")
    public Tshirt getTshirtById(@PathVariable int id){
        return serviceLayer.findTshirtById(id);
    }

    // A GET route that gets all tshirts
    @GetMapping("/tshirts")
    public List<Tshirt> getAllTshirts(){
        return serviceLayer.findAllTshirts();
    }

    // A PUT route that updates tshirt
    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody Tshirt tshirt){
        serviceLayer.updateTshirt(tshirt);
    }

    // A DELETE route that delete by tshirt ID
    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirtById(@PathVariable int id) {
        serviceLayer.removeTshirt(id);
    }

    // A GET route that gets tshirts by color
    @GetMapping("/tshirts/color/{color}")
    public List<Tshirt> getTshirtByColor(@PathVariable String color){
        return serviceLayer.findTshirtByColor(color);
    }

    // A GET route that gets tshirts by size
    @GetMapping("/tshirts/size/{size}")
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        return serviceLayer.findTshirtBySize(size);
    }
}