package com.example.demo.DTO.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class TableRequest {

    private long id ;
    private int numero ;
    private int nbCouverrt;
    private String type;
    private float supplement;

}


