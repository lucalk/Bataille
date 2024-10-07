package Bataille;

import java.util.ArrayList;

public class BatailleMain {
    public static void main(String[] args) {

        ArrayList<Carte> lesCartes = new ArrayList<>();
        Carte carte = new Carte();
        carte.creatPaquets(lesCartes);

        Joueur J1 = new Joueur("le1",0,new ArrayList<Carte>());
        Joueur J2 = new Joueur("le2",0, new ArrayList<Carte>());

        carte.distribution(J1,J2,lesCartes);
        carte.melanger(J1.getMesCartes());
        carte.melanger(J2.getMesCartes());

        int manche = 0;
        int e = 0;
        while(!J1.vide() && !J2.vide()){
            Carte carteJ1 = J1.getMesCartes().get(0);
            Carte carteJ2 = J2.getMesCartes().get(0);

            String vJ1 = carte.verification(carteJ1);
            String vJ2 = carte.verification(carteJ2);

            System.out.println(J1.getNom() + " pose la carte " + vJ1 + " de " + carteJ1.getColor());
            System.out.println(J2.getNom() + " pose la carte " + vJ2 + " de " + carteJ2.getColor());

            int resultat = carte.comparer(carteJ1,carteJ2);
            if(resultat == 1){
                J1.ajoutCarte(carteJ2);
                J2.supprCarte(carteJ2);
                J1.compteurWin();
                System.out.println(J1.getNom()+" gagne cette manche !");
                System.out.println("----------------------------------------------------------------");
            }else if(resultat == 2){
                J2.ajoutCarte(carteJ1);
                J1.supprCarte(carteJ1);
                J2.compteurWin();
                System.out.println(J2.getNom()+" gagne cette manche !");
                System.out.println("----------------------------------------------------------------");
            }else{
                System.out.println("Egalité");
                System.out.println("----------------------------------------------------------------");
                e+=1;
            }
            J1.supprCarte(carteJ1);
            J2.supprCarte(carteJ2);
            manche+=1;
        }

        if(J1.getPoint() > J2.getPoint()){
            System.out.println(J1.getNom()+" gagne la Bataille !");
            System.out.println("Avec "+ J1.getPoint()+ " points contre "+ J2.getPoint()+ " points");
        }else{
            System.out.println(J2.getNom()+" gagne la Bataille !");
            System.out.println("Avec "+ J2.getPoint()+ " points contre "+ J1.getPoint()+" points");
        }
        System.out.println(manche+ " manches au total avec "+e+" égalités !");
    }
}
