package com.example.demo.Reposetories;

import com.example.demo.Models.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository <TableEntity,Long > {
}
