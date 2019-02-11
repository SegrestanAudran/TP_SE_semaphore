/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_semaphore;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asegrest
 */
public class Lecteur extends Thread{
    Semaphore s;
    static int compteur = 0;
    
    public Lecteur(Semaphore s){
        this.s=s;
    }
    
    @Override
    public void run(){
        while(true) {
            compteur+=1;
            if(compteur==1){
                try{
                    s.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lecteur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(getName() + "Lexteur " + getName() + " entre en lecture");
            compteur-=1;
            if(compteur ==0){
                s.release();
            }
            System.out.println(getName()+ "Lecteur " + getName() + " sort de lecture");
        }
    }
    
}
