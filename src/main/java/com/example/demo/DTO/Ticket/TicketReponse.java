package com.example.demo.DTO.Ticket;
import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Table.TableReponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReponse {

    private long id ;
    private int numero;
    private LocalDateTime date ;
    private int nbCouvert ;
    private float addition ;


    private TableReponse table;

    private ClientReponse client;

    private List<MetReponse> mets;

}
