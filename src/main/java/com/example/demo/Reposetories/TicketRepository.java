package com.example.demo.Reposetories;

import com.example.demo.Models.TicketEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEnity,Long> {
}
