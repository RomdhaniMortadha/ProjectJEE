package com.example.demo.EndPoints;
import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Table.TableReponse;
import com.example.demo.DTO.Ticket.TicketReponse;
import com.example.demo.DTO.Ticket.TicketRequest;
import com.example.demo.Models.ClientEntity;
import com.example.demo.Services.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/ticket")

public class TicketRest {
    private TicketServiceImpl ticketService;

    @Autowired
    public TicketRest(TicketServiceImpl ticketService) {
        super();
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<TicketReponse> getAll(){
        return ticketService.getAllEntity();
    }

    @GetMapping("/{id}")
    public TicketReponse getById(@PathVariable("id") long id){
        return ticketService.getEntityById(id);
    }

    @PostMapping
    public TicketReponse addTicket(@RequestBody TicketRequest ticket){
        return ticketService.addTicket(ticket);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return ticketService.deleteTicket( id);
    }
    @PostMapping("/{id}")
    public TicketReponse updateTicket(@PathVariable("id") long id, @RequestBody TicketRequest newTicket) {
        return ticketService.updateTicket(id, newTicket);
    }




    @GetMapping("/top/plat/{begin}/{end}")
    public MetReponse PlatPlusAchete(@PathVariable("begin") String begin, @PathVariable("end") String end){
        return ticketService.PlatPlusAchete(LocalDateTime.parse(begin),LocalDateTime.parse(end));
    }
    @GetMapping("/client/fidel")
    public ClientEntity ClientplusFidel(){
        return ticketService.ClientPlusFidel();
    }
    @GetMapping("/revenue/period/{begin}/{end}")
    public Double revenudansperiode(@PathVariable("begin") LocalDateTime begin, @PathVariable("end") LocalDateTime end){
        return ticketService.revenudansperiode(begin, end);
    }
    @GetMapping("/client/reservedday/{id}")
    public LocalDateTime JourPlusResrveduClient(@PathVariable("id")int id){
        return ticketService.JourPlusResrve(id);
    }

    @GetMapping("/plusreserved/table")
    public TableReponse TablePlusReserve(){
        return ticketService.TablePlusReserve();
    }

    @GetMapping("/revenue/day")
    public String RevenueDerniereDays(){
        return ticketService.RevenueDerniereDays();
    }

    @GetMapping("/revenue/semain")
    public String RevenueDerniereWeeks(){
        return ticketService.RevenueDerniereWeeks();
    }

    @GetMapping("/revenue/mois")
    public String RevenueDerniereMonths(){
        return ticketService.RevenueDerniereMonths();
    }






    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
