package com.example.demo.Services;
import com.example.demo.DTO.Ticket.TicketReponse;
import com.example.demo.DTO.Ticket.TicketRequest;
import com.example.demo.Models.TicketEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface TicketService {

    List<TicketReponse> getAllEntity();
    TicketReponse getEntityById(long id);
    TicketReponse addTicket(TicketRequest entity);
    TicketReponse updateTicket(long id ,TicketRequest newEntity);
    String deleteTicket(long id );
}
