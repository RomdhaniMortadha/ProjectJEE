package com.example.demo.DTO.Met;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetRequest {

        private long id ;
        private String nom;
        private float prix;

    }
