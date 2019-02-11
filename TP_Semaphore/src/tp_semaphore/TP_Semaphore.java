/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_semaphore;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Semaphore;
/**
 *
 * @author asegrest
 */
public class TP_Semaphore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Semaphore s1 = new Semaphore(10);
        Semaphore s2 = new Semaphore(0);
        
        int prod = 11;
        int cons = 10;
        List<Producteur> prodl = new ArrayList();
        List<Consommateur> consl= new ArrayList();
        Stack<String> produits = new Stack();
        for(int i=0; i<prod;i++){
            prodl.add(new Producteur(produits,s1,s2));
        }
        for(int i=0; i<cons;i++){
            consl.add(new Consommateur(produits,s1,s2));
        }
        for(Producteur t:prodl){
            t.start();
        }
        for(Consommateur c:consl){
            c.start();
        }
        */
        /*
        Semaphore s3= new Semaphore(0);
        int n = 10;
        List<RendezVous> rdv = new ArrayList();
        for(int i=0; i<n;i++){
            rdv.add(new RendezVous(n,s3));
        }
        for(RendezVous r:rdv){
            r.start();
        }
        */
        Semaphore s4 = new Semaphore(1);
        int lecteur=10;
        int redacteur=10;
        List<Lecteur> lect = new ArrayList();
        List<Redacteur> reda= new ArrayList();
        for(int i=0; i<lecteur;i++){
            lect.add(new Lecteur(s4));
        }
        for(int i=0; i<redacteur;i++){
            reda.add(new Redacteur(s4));
        }
        for(Lecteur t:lect){
            t.start();
        }
        for(Redacteur c:reda){
            c.start();
        }
    }
    
}
