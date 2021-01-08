package com.example.demo.Reposetories;

import com.example.demo.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Long> {
}
