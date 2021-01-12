package com.example.demo.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String courriel;
    private String telephone;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<TicketEntity> tickets;



}
