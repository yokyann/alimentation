package maquette;

import exception.DonneeIncoherenteException;

public class AlimentSolide extends Aliment {
    private final int glucides100g;
    private final int proteines100g;
    private final int lipides100g;

    public AlimentSolide(String nom, int kCalParUnite, int glucides100g, int proteines100g, int lipides100g) throws DonneeIncoherenteException{
        super(nom, kCalParUnite);
        this.glucides100g=glucides100g;
        this.proteines100g=proteines100g;
        this.lipides100g=lipides100g;
    }

    public int getGlucides100g() {
        return glucides100g;
    }
    public int getLipides100g() {
        return lipides100g;
    }
    public int getProteines100g() {
        return proteines100g;
    }
    public String toString() {
        return nom+"("+kCalParUnite+"kcal)";
    }

    @Override
    public Object copy(Object o) {
        if (o instanceof AlimentSolide) {
            AlimentSolide copy = (AlimentSolide) o;
            return new AlimentLiquide(copy.nom, copy.kCalParUnite, copy.glucides100g, copy.proteines100g, copy.lipides100g);
    }
    return null;
    }


}
