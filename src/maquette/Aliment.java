package maquette;

public abstract class Aliment extends ObjectNomme{
    
    protected int kCalParUnite;

    protected Aliment(String nom, int kCalParUnite){
        super(nom);
        this.kCalParUnite=kCalParUnite;
    }

    public int getKCalParUnite(){
        return kCalParUnite;
    }
    public String getNom() {
        return super.getNom();
    }
}
