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
public class Redacteur extends Thread{
    
    Semaphore s;
    
    public Redacteur(Semaphore s){
        this.s=s;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                s.acquire();
            }catch (InterruptedException ex) {
                    Logger.getLogger(Lecteur.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(getName() + "Redacteur " + getName() + " entre en écriture");
            System.out.println(getName() + "Redacteur " + getName() + " sort de écriture");
            s.release();
        }
    }
    
}
