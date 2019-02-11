/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_semaphore;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asegrest
 */
public class Consommateur extends Thread{
    Stack<String> produits;
    Random rd;
    Semaphore s1;
    Semaphore s2;
    public Consommateur(Stack<String> produits, Semaphore s1,Semaphore s2) {
        this.produits = produits;
        rd = new Random();
        this.s1 = s1;
        this.s2 = s2;
    }
    @Override
    public void run(){
        while (true) {
            
                try{
                    s2.acquire();
                    
                }   catch (InterruptedException ex) {}
                    
                        int last= produits.size() -1;
                        System.out.println(getName()+ " tente de lire le produit : "+ last);
                        String produit = produits.get(last);
                        System.out.println(getName() + " a lu le produit : "+produit);
                        System.out.println(getName()+ " tente d'enlever le produit : "+ produit);
                        synchronized(produits){
                            produits.pop();
                        }
                        System.out.println(getName()+ " a enlevé le produit : " + produit);
                        try { sleep(rd.nextInt(500));} catch (InterruptedException e) {};
                    
                s1.release();
                }
        
        }
    }

