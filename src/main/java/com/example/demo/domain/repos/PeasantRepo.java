package com.example.demo.domain.repos;

import com.example.demo.domain.classes.Peasant;
import org.springframework.data.repository.CrudRepository;

public interface PeasantRepo extends CrudRepository<Peasant, Integer> {
    Peasant getPeasantByName(String name);
}
