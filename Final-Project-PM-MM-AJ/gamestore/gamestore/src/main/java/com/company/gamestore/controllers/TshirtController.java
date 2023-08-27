package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import com.company.gamestore.repositories.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TshirtController {

    @Autowired
    TshirtRepository tshirtRepository;

    // A POST route that creates a tshirt
    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }

   // A GET route that returns a specific tshirt by id
    @GetMapping("/tshirts/{id}")
    public Tshirt getTshirtById(@PathVariable int id){
        Optional<Tshirt> returnedTshirt = tshirtRepository.findById(id);
        return returnedTshirt.orElse(null);
    }

    // A GET route that gets all tshirts
    @GetMapping("/tshirts")
    public List<Tshirt> getAllTshirts(){
        return tshirtRepository.findAll();
    }

    // A PUT route that updates tshirt
    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tshirt updateTshirt(@RequestBody Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }

    // A DELETE route that delete by tshirt ID
    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirtById(@PathVariable int id) {
        tshirtRepository.deleteById(id);
    }

    // A GET route that gets tshirts by color
    @GetMapping("/tshirts/color/{color}")
    public List<Tshirt> getTshirtByColor(@PathVariable String color){
        List<Tshirt> returnedTshirts = tshirtRepository.findTshirtByColor(color);
        return returnedTshirts;
    }

    // A GET route that gets tshirts by size
    @GetMapping("/tshirts/size/{size}")
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        List<Tshirt> returnedTshirts = tshirtRepository.findTshirtBySize(size);
        return returnedTshirts;
    }
}