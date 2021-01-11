package com.example.demo.EndPoints;
import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Met.MetRequest;
import com.example.demo.Services.MetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/met")
public class MetRest {
    private MetServiceImpl metService;
    @Autowired
    public MetRest(MetServiceImpl metService) {
        super();
        this.metService = metService;
    }

    @GetMapping
    public List<MetReponse> getAll(){
        return metService.getAllEntity();
    }

    @GetMapping("/{id}")
    public MetReponse getById(@PathVariable("id") long id){
        return metService.getEntityById(id);
    }

    @GetMapping("/plat")
    public List<MetReponse> getAllPlats(){
        return metService.getAllPlats();
    }

    @GetMapping("/dessert")
    public List<MetReponse> getAllDesserts(){
        return metService.getAllDesserts();
    }

    @GetMapping("/entree")
    public List<MetReponse> getAllEntrees(){
        return metService.getAllEntrees();
    }


    @PostMapping("/plat")
    public MetReponse addPlat(@RequestBody MetRequest met){

        return metService.addPlat(met);
    }

    @PostMapping("/dessert")
    public MetReponse addDessert(@RequestBody MetRequest met){
        return metService.addDessert(met);
    }

    @PostMapping("/entree")
    public MetReponse addEntree(@RequestBody MetRequest met){
        return metService.addEntree(met);
    }

   /* @PostMapping
    public MetReponse addMet(@RequestBody MetRequest client){
        return metService.addMet(client);
    }
    */

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return metService.deleteMet( id);
    }
    @PostMapping("/{id}")
    public MetReponse updateMet(@PathVariable("id") long id, @RequestBody MetRequest newMet) {
        return metService.updateMet(id, newMet);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
