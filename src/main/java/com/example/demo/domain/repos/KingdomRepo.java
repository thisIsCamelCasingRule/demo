package com.example.demo.domain.repos;

import com.example.demo.domain.classes.Kingdom;
import org.springframework.data.repository.CrudRepository;


public interface KingdomRepo extends CrudRepository<Kingdom, Integer> {
    Kingdom getKingdomByName(String name);
}
