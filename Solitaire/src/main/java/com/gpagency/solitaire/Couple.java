/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpagency.solitaire;

/**
 *
 * @author Jules
 */
public class Couple {
    private int code;
    private char lettre;

    public int getCode() {
        return code;
    }

    public char getLettre() {
        return lettre;
    }
    
    public Couple(int c, char ch){
        this.code=c;
        this.lettre=ch;
    }
    
    @Override
    public String toString(){
        String s="";
        s+="Code : "+this.code+"\n";
        s+="Lettre : "+this.lettre+"\n";
        return s;
    }
    
}
