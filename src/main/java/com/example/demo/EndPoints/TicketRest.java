package com.example.demo.EndPoints;

import com.example.demo.Models.TicketEnity;
import com.example.demo.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/ticket")

public class TicketRest {
    private TicketService ticketService;

    @Autowired
    public TicketRest(TicketService ticketService) {
        super();
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<TicketEnity> getAll(){
        return ticketService.getAllEntity();
    }

    @GetMapping("/{id}")
    public TicketEnity getById(@PathVariable("id") long id){
        return ticketService.getEntityById(id);
    }

    @PostMapping
    public TicketEnity addTicket(@RequestBody TicketEnity ticket){
        return ticketService.addTicket(ticket);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return ticketService.deleteTicket( id);
    }
    @PostMapping("/{id}")
    public TicketEnity updateTicket(@PathVariable("id") long id, @RequestBody TicketEnity newTicket) {
        return ticketService.updateTicket(id, newTicket);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
