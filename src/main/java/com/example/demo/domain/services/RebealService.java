package com.example.demo.domain.services;

import com.example.demo.domain.classes.King;
import com.example.demo.domain.classes.Kingdom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebealService {

    private final PeasantService pservice;
    private final KingdomService kservice;
    private final KingService kngservice;

    @Autowired
    RebealService(PeasantService pservice, KingdomService kservice, KingService kngservice)
    {
        this.pservice = pservice;
        this.kservice = kservice;
        this.kngservice = kngservice;
    }

    public boolean rebeal(String kingName, String newKingName) {
        King kn = kngservice.getKingByName(kingName);
        King newKing = kngservice.getKingByName(newKingName);

        System.out.print("For the cruel things the king " + kn.getName() + " was slaved!\n");




        if (kngservice.getKingByName(newKingName) != null){
            Kingdom oldKingdom = kservice.getKingdomByName(kn.getKingdom());
            Kingdom newKingdom = kservice.getKingdomByName(newKing.getKingdom());

            kservice.updateKingdom( newKingdom.getName(), newKingdom.getSqare() + oldKingdom.getSqare(), newKingdom.getPopulation()+oldKingdom.getPopulation(), newKingdom.getAmountOfBuildings()+oldKingdom.getAmountOfBuildings());

            kservice.deleteKingdomByName(oldKingdom.getName());
            kngservice.deleteKingByName(kn.getName());

            System.out.print("Welcome new king - " + newKingName + "\n");

            return true;
        }
        else{
            kngservice.addKing(newKingName, kn.getKingdom());

            kngservice.deleteKingByName(kingName);

            System.out.print("Welcome new king - " + newKingName + "\n");

            return true;
        }


    }

}
