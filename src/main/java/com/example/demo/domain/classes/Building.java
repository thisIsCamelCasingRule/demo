package com.example.demo.domain.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name = "Warehouse";
    private String mission = "Store resorces";

    public Building(Integer id, String name, String mission) {
        this.id = id;
        this.name = name;
        this.mission = mission;
    }

    public Building() {
    }

    public String getName() {
        return name;
    }

    public String getMission() {
        return mission;
    }
}
