package com.example.demo.Reposetories;

import com.example.demo.Models.Met.DessertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertRepository extends JpaRepository<DessertEntity,Long> {
}
