package maquette;
//Donne un nom(String) à certaines classes
public abstract class ObjectNomme implements Copiable{
    protected String nom;

    protected ObjectNomme(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return nom;
    }

}
