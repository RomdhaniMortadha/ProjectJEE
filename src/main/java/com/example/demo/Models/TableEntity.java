package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tablee")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private int numero ;
    private int nbCouverrt;
    private String type;
    private float supplement;

    @OneToMany(mappedBy = "table",cascade = CascadeType.REMOVE)
    private List<TicketEntity> tickets;
}
