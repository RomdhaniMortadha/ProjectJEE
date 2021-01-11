package com.example.demo.DTO.Ticket;
import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Table.TableReponse;
import com.example.demo.Models.ClientEntity;
import com.example.demo.Models.Met.MetEntity;
import com.example.demo.Models.TableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReponse {

    private long id ;
    private int numero;
    private LocalDate date ;
    private int nbCouvert ;
    private float addition ;


    private TableReponse table;

    private ClientReponse client;

    private List<MetReponse> mets;

}
