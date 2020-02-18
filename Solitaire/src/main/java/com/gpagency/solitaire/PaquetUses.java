/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.solitaire;

import java.util.ArrayList;

/**
 *
 * @author Jules
 */
public class PaquetUses {
    private ArrayList <Paquet> liste;
    
    public PaquetUses(Paquet p){
        liste = new ArrayList <Paquet>();
        liste.add(new Paquet(p.getJeu()));
    }
    
    public boolean isUsed(Paquet p){
        int i = 0;
        boolean used=false;
        for(i=0; i< liste.size(); i++){
            used = used || liste.get(i).isEqual(p);
        }
        return used;
    }
    
    public void add(Paquet p){
        liste.add(p);
    }
    
}
