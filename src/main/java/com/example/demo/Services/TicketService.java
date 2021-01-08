package com.example.demo.Services;
import com.example.demo.Models.TicketEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface TicketService {

    List<TicketEnity> getAllEntity();
    TicketEnity getEntityById(long id);
    TicketEnity addTicket(TicketEnity entity);
    TicketEnity updateTicket(long id ,TicketEnity newEntity);
    String deleteTicket(long id );
}
