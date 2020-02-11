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
public class Operations {
    ArrayList <Couple> flux=new ArrayList<Couple>();
    
    public Operations(){
        
    }
    
    @Override
    public String toString(){
        String s="";
        int i=0;
        for(i=0; i<flux.size(); i++){
            s+=flux.get(i).toString();
            s+="\n";
        }
        return s;
    }
    
    public void fillFlux(Paquet p, int length){
        int n=0;
        int m=0;
        int i=0;
        char c='!';
        
        for(i=0; i<length; i++){
            
            p.etape1();
            p.etape2();
            p.etape3();
            p.etape4();

            n=p.getAtIndex(0);
            m=p.getAtIndex(n-1);

            while(m==53 || m==54){
                p.etape1();
                p.etape2();
                p.etape3();
                p.etape4();
                n=p.getAtIndex(0);
                m=p.getAtIndex(n-1);
            }

            if(m>26){
                m=m-26;
            }

            c=charFromInt(m);
            
            Couple cp = new Couple(m,c);
            flux.add(cp);
        }
        
        
    }
    
    public char charFromInt(int i){
        char c='!';
        
        switch(i){
            case 1:
                c='a';
                break;
            
            case 2:
                c='b';
                break;
            
            case 3:
                c='c';
                break;
                
            case 4:
                c='d';
                break;
                
            case 5:
                c='e';
                break;
            
            case 6:
                c='f';
                break;
            
            case 7:
                c='g';
                break;
                
            case 8:
                c='h';
                break;
                
            case 9:
                c='i';
                break;
            
            case 10:
                c='j';
                break;
            
            case 11:
                c='k';
                break;
                
            case 12:
                c='l';
                break;
                
            case 13:
                c='m';
                break;
            
            case 14:
                c='n';
                break;
            
            case 15:
                c='o';
                break;
                
            case 16:
                c='p';
                break;
                
            case 17:
                c='q';
                break;
            
            case 18:
                c='r';
                break;
            
            case 19:
                c='s';
                break;
                
            case 20:
                c='t';
                break;
                
            case 21:
                c='u';
                break;
            
            case 22:
                c='v';
                break;
            
            case 23:
                c='w';
                break;
                
            case 24:
                c='x';
                break;
                
            case 25:
                c='y';
                break;
                
            case 26:
                c='z';
                break;
            
            default:
                c='!';
                break;
        }
        return c;
    }
    
}
