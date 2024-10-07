package Bataille;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private int point;
    private ArrayList<Carte> mesCartes;

    public Joueur(String nom,int point, ArrayList<Carte> mesCartes){
        this.nom = nom;
        this.point = point;
        this.mesCartes = mesCartes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Carte> getMesCartes() {
        return mesCartes;
    }

    public void setMesCartes(ArrayList<Carte> mesCartes) {
        this.mesCartes = mesCartes;
    }

    public void compteurWin(){
        point +=1;
    }

    public void ajoutCarte(Carte carte){
        this.mesCartes.add(carte);
    }

    public void supprCarte(Carte carte){
        this.mesCartes.remove(carte);
    }

    public boolean vide(){
        return this.mesCartes.isEmpty();
    }

}
