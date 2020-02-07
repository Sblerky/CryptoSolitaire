/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.solitaire;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jules
 */
public class Paquet {
    private ArrayList <Integer> jeu;
    
    //Initialisation du paquet selon l'ordre du Bridge
    public Paquet(){
        jeu=new ArrayList<Integer>();
        int i=0;
        for(i=0; i<54; i++){
            jeu.add(i+1);
        }
    }
    
    public int get(int i){
        return jeu.get(i);
    }
    
    public void shuffle(){
        Collections.shuffle(jeu); 
    }
    
    @Override
    public String toString(){
        String s="";
        int i=0;
        for(i=0; i<54; i++){
            s+=jeu.get(i);
            s+=" ";
        }
        return s;
    }
    
}
