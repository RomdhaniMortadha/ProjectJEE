package com.example.demo.Models;

import com.example.demo.Models.Met.MetEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private int numero;
    private LocalDateTime date ;
    private int nbCouvert ;
    private float addition ;

    @ManyToOne
    private TableEntity table;

    @ManyToOne
    private ClientEntity client;

    @ManyToMany
    @JoinTable(name = "compose")
    private List<MetEntity> mets;


}
