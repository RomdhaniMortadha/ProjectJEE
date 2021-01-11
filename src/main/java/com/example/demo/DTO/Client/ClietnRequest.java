package com.example.demo.DTO.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClietnRequest {
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String courriel;
    private String telephone;

 //   private String tickets;
}
