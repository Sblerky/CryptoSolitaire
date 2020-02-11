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
public class MainTest {
    
    public static void main(String[] args) 
    { 
        /*
        ArrayList <Integer> jeu=new ArrayList<Integer>();
        int i=0;
        for(i=0; i<54; i++){
            jeu.add(i+1);
        }
        
        jeu.set(52, 54);
        jeu.set(53, 53);
        Paquet p = new Paquet();
        p.setListe(jeu); */
        Paquet p = new Paquet();
        String clair="un test";
        p.shuffle();
        Operations o = new Operations(clair);
        o.fillFlux(p);
        o.fillBase();
        o.fillCode();
        System.out.println("Flux : "+o.getFlux());
        System.out.println("Base : "+o.getBase());
        System.out.println("Codé : "+o.getCode());
        o.fillDecode();
        System.out.println("Décodé : "+o.getDecode());

    } 
    
}
