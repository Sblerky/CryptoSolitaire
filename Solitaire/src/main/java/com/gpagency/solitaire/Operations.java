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
    private ArrayList <Couple> flux=new ArrayList<Couple>();
    private ArrayList <Couple> base=new ArrayList<Couple>();
    private ArrayList <Couple> code=new ArrayList<Couple>();
    private ArrayList <Couple> decode=new ArrayList<Couple>();
    private ArrayList <Character> texte=new ArrayList<Character>();
    private int length;
    private String message;
    private String message_trans;
    private Paquet p;
    
    
    public Operations(String s, Paquet p){
        message=s;
        this.p=new Paquet(p.getListe());
        s=s.replaceAll("\\s", "ppp");
        
        for (char c : s.toCharArray()) {
            texte.add(c);
          }
        
        length=texte.size();
        
    }
    
    public void code(){
        this.fillFlux(p);
        this.fillBase();
        this.fillCode();
        message_trans=this.getCode();
        message_trans=message_trans.replaceAll("ppp", "\\s");
    }
    
    public void decode(){
        this.fillFlux(p);
        this.fillBase();
        this.fillDecode();
        message_trans=this.getDecode();
        message_trans=message_trans.replaceAll("ppp", " ");
    }

    public String getMessage() {
        return message;
    }

    public String getMessage_trans() {
        return message_trans;
    }
    
    public String getCode(){
        String s="";
        int i=0;
        for(i=0; i<code.size(); i++){
            s+=code.get(i).getLettre();
        }
        return s;
    }
    
    public String getBase(){
        String s="";
        int i=0;
        for(i=0; i<base.size(); i++){
            s+=base.get(i).getLettre();
        }
        return s;
    }
    
    public String getFlux(){
        String s="";
        int i=0;
        for(i=0; i<flux.size(); i++){
            s+=flux.get(i).getLettre();
        }
        return s;
    }
    
    public String getDecode(){
        String s="";
        int i=0;
        for(i=0; i<decode.size(); i++){
            s+=decode.get(i).getLettre();
        }
        return s;
    }
    
    public String fluxToString(){
        String s="";
        int i=0;
        for(i=0; i<flux.size(); i++){
            s+=flux.get(i).toString();
            s+="\n";
        }
        return s;
    }
    
    public String baseToString(){
        String s="";
        int i=0;
        for(i=0; i<base.size(); i++){
            s+=base.get(i).toString();
            s+="\n";
        }
        return s;
    }
    
    public String codeToString(){
        String s="";
        int i=0;
        for(i=0; i<code.size(); i++){
            s+=code.get(i).toString();
            s+="\n";
        }
        return s;
    }
    
    public String decodeToString(){
        String s="";
        int i=0;
        for(i=0; i<decode.size(); i++){
            s+=decode.get(i).toString();
            s+="\n";
        }
        return s;
    }
    
    //rempli la liste avec le message codé
    public void fillCode(){
        int l = base.size();
        int i=0;
        int m=0;
        char c='!';
        
        for(i=0; i<l; i++){
            m=base.get(i).getCode() + flux.get(i).getCode();
            if(m>26){
                m=m-26;
            }
            
            c=this.charFromInt(m);
            Couple cp = new Couple(m,c);
            code.add(cp);
            
        }
    }
    
    //rempli la liste avec le message décodé
    public void fillDecode(){
        int l = base.size();
        int i=0;
        int m=0;
        char c='!';
        
        for(i=0; i<l; i++){
            m=base.get(i).getCode() - flux.get(i).getCode();
            if(m<0){
                m=m+26;
            }
            
            c=this.charFromInt(m);
            Couple cp = new Couple(m,c);
            decode.add(cp);
            
        }
    }
    
    //rempli la liste avec le texte de base
    public void fillBase(){
        int l = texte.size();
        int i=0;
        int m=0;
        char c='!';
        for(i=0; i<l; i++){
            c=texte.get(i);
            m=this.intFromChar(c);
            Couple cp = new Couple(m,c);
            base.add(cp);
        }
    }
    
    //rempli la liste avec le flux
    public void fillFlux(Paquet p){
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
    
    public int  intFromChar(char c){
        int i=-1;
        
        switch(c){
            case 'a':
                i=1;
                break;
            
            case 'b':
                i=2;
                break;
            
            case 'c':
                i=3;
                break;
            
            case 'd':
                i=4;
                break;
                
            case 'e':
                i=5;
                break;
            
            case 'f':
                i=6;
                break;
            
            case 'g':
                i=7;
                break;
            
            case 'h':
                i=8;
                break;
                
            case 'i':
                i=9;
                break;
            
            case 'j':
                i=10;
                break;
            
            case 'k':
                i=11;
                break;
            
            case 'l':
                i=12;
                break;
                
            case 'm':
                i=13;
                break;
            
            case 'n':
                i=14;
                break;
            
            case 'o':
                i=15;
                break;
            
            case 'p':
                i=16;
                break;
                
            case 'q':
                i=17;
                break;
            
            case 'r':
                i=18;
                break;
            
            case 's':
                i=19;
                break;
            
            case 't':
                i=20;
                break;
                
            case 'u':
                i=21;
                break;
            
            case 'v':
                i=22;
                break;
            
            case 'w':
                i=23;
                break;
            
            case 'x':
                i=24;
                break;
                
            case 'y':
                i=25;
                break;
            
            case 'z':
                i=26;
                break;
            
            default:
                i=-1;
                break;
        }
        return i;
    }
    
}
