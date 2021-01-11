package com.example.demo.DTO.Met;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetRequest {

        private long id ;
        private String nom;
        private float prix;

      //  private String tickets;
    }
