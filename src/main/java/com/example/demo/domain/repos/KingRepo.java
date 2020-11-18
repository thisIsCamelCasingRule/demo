package com.example.demo.domain.repos;

import com.example.demo.domain.classes.King;
import org.springframework.data.repository.CrudRepository;

public interface KingRepo extends CrudRepository<King, Integer> {
    King getKingByName(String name);
}
