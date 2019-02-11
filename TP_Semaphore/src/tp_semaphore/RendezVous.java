/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author asegrest
 */
public class RendezVous extends Thread{
    
    int n;
    Semaphore s;
    static int compteur =0;
    public RendezVous(int n,Semaphore s){
        this.n= n;
        this.s= s;
    }
    
    @Override
    public void run() {
        System.out.println(getName()+ "débute sa première partie");
        try{
            compteur+=1;
            if(compteur<n){
                s.acquire();
            }
            
            s.release();
            compteur -=1;
        }catch(Exception e){
            
        }
        
        System.out.println(getName()+ "débute sa seconde partie");
    }
    
}
