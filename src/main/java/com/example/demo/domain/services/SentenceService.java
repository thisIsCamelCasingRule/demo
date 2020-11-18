package com.example.demo.domain.services;

import com.example.demo.domain.classes.Kingdom;
import com.example.demo.domain.classes.Peasant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {

    private final PeasantService pservice;
    private final KingdomService kservice;

    @Autowired
    SentenceService(PeasantService pservice, KingdomService kservice)
    {
        this.pservice = pservice;
        this.kservice = kservice;
    }

    public boolean execute(String peasantName, String kingdomName) {
        Peasant p = pservice.getPeasantByName(peasantName);
        Kingdom k = kservice.getKingdomByName(kingdomName);

        if(p.getStatus()) {
            System.out.println("For the word of King citizen " + p.getName() + " was executed! Rest in piace.");

            p.setStatus(false);
            k.setPopulation(k.getPopulation() - 1);

            pservice.updatePeasant(p.getName(), p.getPosition(), p.getKingdom(), p.getStatus());
            kservice.updateKingdom(k.getName(), k.getSqare(), k.getPopulation(), k.getAmountOfBuildings());

            return true;
        }
        else {
            System.out.println(p.getName() + " is already dead! You can't kill the deadman.");

            return true;
        }
    }

    public boolean pardon(String peasantName) {
        System.out.println("For the word of King citizen " + peasantName + " was pardoned! Congratulations!!!");

        return true;
    }


}
