package com.example.demo.Models.Met;
import lombok.Data;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@Data
@DiscriminatorValue("Entree")
public class EntreeEntity extends MetEntity {

}
