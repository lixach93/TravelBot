package com.bot.controller;

import com.bot.dto.CityDTO;
import com.bot.dto.CityOutput;
import com.bot.model.City;
import com.bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityRestController {

    @Autowired
    private CityService cityService;



    @GetMapping("/")
    public ResponseEntity<List<CityOutput>> getAll() {
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cityService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody @Valid CityDTO cityDTO) {
        cityService.create(cityDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
