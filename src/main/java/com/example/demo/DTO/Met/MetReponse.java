package com.example.demo.DTO.Met;

import com.example.demo.Models.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetReponse {

    private long id ;
    private String nom;
    private float prix;

   // private List<TicketEntity> tickets;
}

