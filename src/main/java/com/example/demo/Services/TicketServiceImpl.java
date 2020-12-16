package com.example.demo.Services;
import com.example.demo.Models.TicketEnity;
import com.example.demo.Reposetories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        super();
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketEnity> getAllEntity() {
        return  ticketRepository.findAll();
    }

    @Override
    public TicketEnity getEntityById(long id) {
        Optional<TicketEnity> opt = ticketRepository.findById(id);
        TicketEnity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Ticket with this Id is not found");
        return entity;
    }

    @Override
    public TicketEnity addTicket(TicketEnity entity) {
        return ticketRepository.save(entity);
    }

    @Override
    public TicketEnity updateTicket(long id, TicketEnity newEntity) {
        TicketEnity ticket =this.getEntityById(id);
        if ( newEntity.getNumero() != 0)
            ticket.setNumero(newEntity.getNumero());

        if ( newEntity.getDate() != null)
            ticket.setDate(newEntity.getDate());

        if ( newEntity.getNbCouvert() != 0)
            ticket.setNbCouvert(newEntity.getNbCouvert());

        if ( newEntity.getAddition() != 0)
            ticket.setAddition(newEntity.getAddition());

        return ticket;    }

    @Override
    public String deleteTicket(long id) {
        TicketEnity ticket = this.getEntityById(id);
        ticketRepository.deleteById(id);
        return "ticket delted ! ";    }
}
