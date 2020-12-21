package com.example.demo.EndPoints;
import com.example.demo.Models.Met.MetEntity;
import com.example.demo.Services.MetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/met")
public class MetRest {
    private MetService metService;
    @Autowired
    public MetRest(MetService metService) {
        super();
        this.metService = metService;
    }

    @GetMapping
    public List<MetEntity> getAll(){
        return metService.getAllEntity();
    }

    @GetMapping("/{id}")
    public MetEntity getById(@PathVariable("id") long id){
        return metService.getEntityById(id);
    }

    @PostMapping
    public MetEntity addMet(@RequestBody MetEntity client){
        return metService.addMet(client);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return metService.deleteMet( id);
    }
    @PostMapping("/{id}")
    public MetEntity updateMet(@PathVariable("id") long id, @RequestBody MetEntity newMet) {
        return metService.updateMet(id, newMet);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
