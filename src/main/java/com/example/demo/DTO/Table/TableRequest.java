package com.example.demo.DTO.Table;

import com.example.demo.Models.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TableRequest {

    private long id ;
    private int numero ;
    private int nbCouverrt;
    private String type;
    private float supplement;

   // private String tickets;
}


