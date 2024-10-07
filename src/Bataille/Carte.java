package Bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Carte {
    private static String[] couleur = {"trefle","pique","coeur","carreau"};
    private static int[] valeur = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private String color;
    private int value;

    public Carte(String color, int value){
        this.color = color;
        this.value = value;
    }

    public Carte(){}

    public String getColor() {
        return this.color;
    }

    public int getValue() {
        return this.value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int comparer( Carte carteJ1, Carte carteJ2 ){
        if(carteJ1.value > carteJ2.value){
            return 1;
        }else if (carteJ1.value < carteJ2.value){
            return 2;
        }
        return 0;
    }

    public void melanger(ArrayList<Carte> lesCartes){
        Collections.shuffle(lesCartes);
    }

    public void creatPaquets(ArrayList<Carte> lesCartes){
        for(String color : couleur ){
            for(int value : valeur){
                Carte carte = new Carte(color,value);
                lesCartes.add(carte);
            }
        }
    }

    public void distribution(Joueur J1, Joueur J2, ArrayList<Carte> lesCartes){
        melanger(lesCartes);
        for(int i = 0; i<lesCartes.size();i++) {
            Carte laCarte = lesCartes.get(i);
            J1.ajoutCarte((laCarte));
            i++;
            J2.ajoutCarte((laCarte));
        }
    }

    public String verification(Carte c) {
        switch (c.getValue()) {
            case 11:
                return "Valet";
            case 12:
                return "Dame";
            case 13:
                return "Roi";
            case 14:
                return "As";
            default:
                return String.valueOf(c.getValue());
        }
    }
}
