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


    // Create
    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }

    //Read by ID
    @GetMapping("/tshirts/{id}")
    public Tshirt getTshirtById(@PathVariable int id){
        Optional<Tshirt> returnVal = tshirtRepository.findById(id);
        if (returnVal.isPresent()){
            return returnVal.get();
        } else {
            return null;
        }
    }

    //Read All
    @GetMapping("/tshirts")
    public List<Tshirt> getAllTshirts(){
        return tshirtRepository.findAll();
    }

    //Update
    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tshirt updateTshirt(@RequestBody Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }

    //Delete
    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id){
        tshirtRepository.deleteById(id);
    }

    //Get By Color
    @GetMapping("/tshirts/color/{color}")
    public List<Tshirt> getTshirtByColor(@PathVariable String color){
        List<Tshirt> returnedColor = tshirtRepository.findByColor(color);
        return returnedColor;
    }

    //Get By Size
    @GetMapping("/tshirts/size/{size}")
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        List<Tshirt> returnedSize = tshirtRepository.findBySize(size);
        return returnedSize;
    }
}