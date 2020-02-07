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
public class MainTest {
    
    public static void main(String[] args) 
    { 
        Paquet p = new Paquet();
        System.out.println(p.toString());
        p.shuffle();
        System.out.println(p.toString());
    } 
    
}
