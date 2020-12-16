package com.example.demo.Reposetories;

import com.example.demo.Models.Met.MetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetRepository extends JpaRepository<MetEntity,Long> {
}
