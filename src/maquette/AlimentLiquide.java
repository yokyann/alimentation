package maquette;

public class AlimentLiquide extends Aliment{
    private final int glucides100ml;
    private final int proteines100ml;
    private final int lipides100ml;

    public AlimentLiquide(String nom, int kCalParUnite, int glucides100ml, int proteines100ml, int lipides100ml){
        super(nom, kCalParUnite);

        this.glucides100ml=glucides100ml;
        this.proteines100ml=proteines100ml;
        this.lipides100ml=lipides100ml;
    }

    public int getGlucides100ml() {
        return glucides100ml;
    }

    public int getProteines100ml() {
        return proteines100ml;
    }

    public int getLipides100ml() {
        return lipides100ml;
    }

    public String toString() {
        return nom+" ("+kCalParUnite+"kcal)";
    }

    @Override
    public Object copy(Object o) {
        if (o instanceof AlimentLiquide) {
            AlimentLiquide copy = (AlimentLiquide) o;
            return new AlimentLiquide(copy.nom, copy.kCalParUnite, copy.glucides100ml, copy.proteines100ml, copy.lipides100ml);
    }
    return null;
    }


}
