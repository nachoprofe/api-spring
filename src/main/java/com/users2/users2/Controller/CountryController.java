package com.users2.users2.Controller;

import com.users2.users2.Entity.CountryEntity;
import com.users2.users2.Entity.UserEntity;
import com.users2.users2.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/addCountry")
    public ResponseEntity<CountryEntity> addCountry(@RequestBody CountryEntity country){
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));
    }

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getCountries(){
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryEntity> getCountry(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getById(id));
    }
}
