package maquette;

import java.util.ArrayList;

public class Repas extends ObjectNomme{
    private ArrayList<Portion> portions;

    public Repas(String nom, ArrayList<Portion> portions){
        super(nom);
        this.portions=portions;
    }

    public int getRepasKcal(){
        int kcal = 0;
        for(Portion portion : portions){
            kcal += portion.getKCalParPortion();
        }
        return kcal;
    }

    public int getRepasGlucides(){
        int glucides=0;
        for (Portion portion : portions) {
            glucides+= portion.getGlucidesPortion();
        }
        return glucides;
    }

    public int getRepasProteines(){
        int proteines=0;
        for (Portion portion : portions) {
            proteines+= portion.getProteinesPortion();
        }
        return proteines;
    }

    public int getRepasLipides(){
        int lipides=0;
        for (Portion portion : portions) {
            lipides+= portion.getLipidesPortion();
        }
        return lipides;
    }

    @Override
    public String toString() {
        String s = "Le repas " + getNom()+ " est compose de ";
        for (int i=0; i<portions.size() ; i++) {
            s+=portions.get(i).getAliment().getNom();
            if(i!=(portions.size()-1)){
                s+=", ";
            }
        }
        s+= " et contient : " + getRepasKcal() + " calories, " + getRepasGlucides() + " g de glucides, " + getRepasLipides() + " g de lipides et " + getRepasProteines() + " g de protéines.";
        return s;
    }

    @Override
    public Object copy(Object o) {
        if (o instanceof Repas) {
            Repas copy = (Repas) o;
            return new Repas(copy.nom, copy.portions);
    }
    return null;
    }
}
