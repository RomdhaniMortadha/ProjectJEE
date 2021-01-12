package com.example.demo.DTO.Ticket;
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
public class TicketRequest {

        private long id ;
        private int numero;
        private LocalDate date ;
        private int nbCouvert ;
        private float addition ;


        private TableEntity table;

        private ClientEntity client;

        private List<MetEntity> mets;

    }
