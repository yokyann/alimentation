package singleton;

import exception.AlimentNonTrouveException;
import maquette.Aliment;

import java.util.ArrayList;

public class BaseDeDonneeAliment {
    private ArrayList<Aliment> aliments;

    private static BaseDeDonneeAliment instance;

    private BaseDeDonneeAliment(ArrayList<Aliment> aliments){
        this.aliments=aliments;
    }

    public static BaseDeDonneeAliment getInstance(ArrayList<Aliment> aliments){
        if(instance == null){
            instance = new BaseDeDonneeAliment(aliments);
        }
        return instance;
    }

    public Aliment getAlimentdeNom(String nom) throws AlimentNonTrouveException{
        for(Aliment aliment : aliments) {
            if(aliment.getNom().equals(nom)){
                return aliment;
            }
        }    
                
        throw new AlimentNonTrouveException("L'aliment "+nom+" que vous cherchez n'est pas dans la base de données.");
                
    }
    public String toString(){
        String s="[";
        for(int i=0; i<instance.aliments.size(); i++){
            s+=instance.aliments.get(i);
            if(i!=instance.aliments.size()-1){
                s+=" ;\n";
            }
        }
        s+="]";
        return s;
    }
    
}

