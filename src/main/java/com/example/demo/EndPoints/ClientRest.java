package com.example.demo.EndPoints;
import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.DTO.Client.ClietnRequest;
import com.example.demo.Models.ClientEntity;
import com.example.demo.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/client")
public class ClientRest {
    private ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientReponse> getAll(){
        return clientService.getAllEntity();
    }

    @GetMapping("/{id}")
    public ClientReponse getById(@PathVariable("id") long id){
        return clientService.getEntityById(id);
    }

    @PostMapping
    public ClientReponse addClient(@RequestBody ClietnRequest client){
        return clientService.addClient(client);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return clientService.deleteClient( id);
    }
    @PostMapping("/{id}")
    public ClientReponse updateClient(@PathVariable("id") long id, @RequestBody ClietnRequest newClient) {
        return clientService.updateClient(id, newClient);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

