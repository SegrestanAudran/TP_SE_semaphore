/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_semaphore;
import java.util.concurrent.Semaphore;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asegrest
 */
public class Producteur extends Thread{
    Stack<String> produits;
    Random rd;
    Semaphore s1;
    Semaphore s2;
    public Producteur(Stack<String> produits, Semaphore s1, Semaphore s2){
        this.produits=produits;
        rd = new Random();
        this.s1 = s1 ;
        this.s2 = s2;
    }
    @Override
    public void run(){
        while (true){
            
            try {
                s1.acquire();
                
            } catch (InterruptedException ex) {}
               
                    int nouveau= produits.size();
                    System.out.println(getName()+ " tente d'ajouter le produit : "+ nouveau);
                    String produit = "numero " + nouveau;
                    produits.push("numero " + nouveau );
                    System.out.println(getName()+ " a ajouté le produit : " + produit);
                    try { sleep(rd.nextInt(500));} catch (InterruptedException e) {};
                
                s2.release();
            }
            
        }
        
    }

