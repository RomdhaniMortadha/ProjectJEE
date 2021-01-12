package com.example.demo.Models.Met;
import com.example.demo.Models.TicketEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom;
    private float prix;

    @ManyToMany(mappedBy = "mets")
    @JsonIgnore
    private List<TicketEntity> tickets;
}
