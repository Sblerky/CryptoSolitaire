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

    public ArrayList<Integer> getJeu() {
        return jeu;
    }
    
    //Initialisation du paquet selon l'ordre du Bridge
    //Joker Noir = 53
    //Joker rouge = 54
    public Paquet(){
        jeu=new ArrayList<Integer>();
        int i=0;
        for(i=0; i<54; i++){
            jeu.add(i+1);
        }
    }
    
    public Paquet(ArrayList <Integer> pjeu){
        jeu=new ArrayList<Integer>();
        int i=0;
        for(i=0; i<54; i++){
            jeu.add(pjeu.get(i));
        }
        
    }
    
    public void setListe(ArrayList l){
        this.jeu=l;
    }
    
    public ArrayList <Integer> getListe(){
        return this.jeu;
    }
    
    public int getAtIndex(int i){
        return jeu.get(i);
    }
    
    public int getIndexOf(int i){
        return jeu.indexOf(i);
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
            if(i==18|| i==36){
               s+="\n"; 
            }
        }
        return s;
    }
    
    public boolean isEqual(Paquet p){
        boolean equal=true;
        ArrayList <Integer> p_liste = p.getJeu();
        int i=0;
        for(i=0; i<54; i++){
            if(this.jeu.get(i) != p_liste.get(i))
                equal=false;
        }
        return equal;
    }
    
    //recule joker noir
    public void etape1(){
        int posJoker = this.getIndexOf(53);
        int stock=0;
        int poscarte = 0;
        
        if(posJoker!=53){
            poscarte = posJoker+1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 53);
            jeu.set(posJoker, stock);

        }
        else{
            //permutation avec la première
            poscarte=0;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 53);
            jeu.set(posJoker, stock);
            //permutation avec la deuxième
            posJoker=0;
            poscarte=1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 53);
            jeu.set(posJoker, stock);
            
        }
    }
    
    //recule joker rouge
    public void etape2(){
        int posJoker = this.getIndexOf(54);
        int stock=0;
        int poscarte = 0;
        
        if(posJoker<52){
            poscarte = posJoker+1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
            
            posJoker = this.getIndexOf(54);
            poscarte = posJoker+1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);

        }
        else if(posJoker == 52){
            //permutation normale
            poscarte = posJoker+1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
            //permutation avec la première
            posJoker = this.getIndexOf(54);
            poscarte=0;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
            //permutation avec la deuxième
            posJoker = this.getIndexOf(54);
            posJoker=0;
            poscarte=1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
            
        }
        else{
            //permutation avec la première
            poscarte=0;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
            //permutation avec la deuxième
            posJoker=0;
            poscarte=1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
            //permutation avec la 3ème
            posJoker = this.getIndexOf(54);
            poscarte = posJoker+1;
            stock=this.getAtIndex(poscarte);
            jeu.set(poscarte, 54);
            jeu.set(posJoker, stock);
        }
    }
    
    //permutation jokers
    public void etape3(){
        int pos1=0;
        int pos2=0;
        int i=0;
        ArrayList <Integer> permute=new ArrayList<Integer>();
        
        if(this.getIndexOf(53)<this.getIndexOf(54)){
            pos1=this.getIndexOf(53);
            pos2=this.getIndexOf(54);
                    
        }
        else{
            pos1=this.getIndexOf(54);
            pos2=this.getIndexOf(53);
        }
        
        if(pos2<53){
            for(i=pos2+1; i<=53; i++){
                permute.add(jeu.get(i));
            }
        }
        
        for(i=pos1; i<=pos2;i++){
            permute.add(jeu.get(i));
        }
        
        if(pos1>0){
            for(i=0; i<pos1; i++){
                permute.add(jeu.get(i));
            }
        }
        
        this.setListe(permute);
        
        
    }
    
    //coupe
    public void etape4(){
        int val = this.getAtIndex(53);
        int i=0;
        ArrayList <Integer> permute=new ArrayList<Integer>();
        
        //si un joker est en dernier, ça sert à rien 
        if(val==54 || val==53){
            return;
        }
        
        for(i=val; i<53; i++){
            permute.add(jeu.get(i));
        }
        for(i=0; i<val; i++){
            permute.add(jeu.get(i));
        }
        
        permute.add(val);
        this.setListe(permute);
        
    }
            
    
}
