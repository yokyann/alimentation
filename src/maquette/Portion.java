package maquette;

import exception.DonneeIncoherenteException;
import exception.AlimentNonTrouveException;
import singleton.BaseDeDonneeAliment;

public class Portion {
    private int grammes;
    private int millilitres;
    private Aliment aliment;

    public Portion(int grammes, int millilitres, String nomAliment) throws DonneeIncoherenteException, AlimentNonTrouveException{
        if(grammes!=0 && millilitres!=0){
            throw new DonneeIncoherenteException("Donnees incoherentes : On ne peut pas ajouter à la fois des grammes et des millilitres.");
        }
        if(grammes<0 || millilitres<0){
            throw new DonneeIncoherenteException("Donnees incoherentes : On ne peut pas ajouter des quantités négatives");
        }
        if(nomAliment==null){
            throw new DonneeIncoherenteException("Donnees incoherentes : l'aliment a besoin d'un nom");
        }

        BaseDeDonneeAliment baseDeDonnee = BaseDeDonneeAliment.getInstance(null);
        this.aliment=baseDeDonnee.getAlimentdeNom(nomAliment);
        

        if(aliment.getClass().equals(AlimentSolide.class) && millilitres>0){
            throw new DonneeIncoherenteException("Donnee incoherente : les aliments solides sont caracterise par des grammes et non pas des millilitres");
        }

        if(aliment.getClass().equals(AlimentLiquide.class) && grammes>0){
            throw new DonneeIncoherenteException("Donnee incoherente : les aliments liquides sont caracterise par des millilitres et non pas des grammes");
        }
        this.grammes=grammes;
        this.millilitres=millilitres;
    }

    public int getKCalParPortion(){
        if(grammes<0){
            return (grammes*aliment.getKCalParUnite()) / 100;
        }
        else if(millilitres>0){
            return (millilitres * aliment.getKCalParUnite()) / 100;
        }
        else{
            return 0;
        }
    }

    public int getProteinesPortion(){
        if(grammes >0 && aliment.getClass().equals(AlimentSolide.class)){
            AlimentSolide alimentSolide = (AlimentSolide) aliment;
            return grammes*alimentSolide.getProteines100g() / 100;
        }
        else if (millilitres >0 && aliment.getClass().equals(AlimentLiquide.class)){
            AlimentLiquide alimentLiquide = (AlimentLiquide) aliment;
            return grammes*alimentLiquide.getProteines100ml() / 100;
        }
        else{
            return 0;
        }
    }

    public int getGlucidesPortion(){
        if(grammes >0 && aliment.getClass().equals(AlimentSolide.class)){
            AlimentSolide alimentSolide = (AlimentSolide) aliment;
            return grammes*alimentSolide.getGlucides100g() / 100;
        }
        else if (millilitres >0 && aliment.getClass().equals(AlimentLiquide.class)){
            AlimentLiquide alimentLiquide = (AlimentLiquide) aliment;
            return grammes*alimentLiquide.getGlucides100ml() / 100;
        }
        else{
            return 0;
        }
    }

    public int getLipidesPortion(){
        if(grammes >0 && aliment.getClass().equals(AlimentSolide.class)){
            AlimentSolide alimentSolide = (AlimentSolide) aliment;
            return grammes*alimentSolide.getLipides100g() / 100;
        }
        else if (millilitres >0 && aliment.getClass().equals(AlimentLiquide.class)){
            AlimentLiquide alimentLiquide = (AlimentLiquide) aliment;
            return grammes*alimentLiquide.getLipides100ml() / 100;
        }
        else{
            return 0;
        }
    }

    public Aliment getAliment() {
        return aliment;
    }
    public int getGrammes() {
        return grammes;
    }
    public int getMillilitres() {
        return millilitres;
    }
}

