package exception;
//Aliment non trouvé dans la base de donnée
public class AlimentNonTrouveException extends Exception{
    public AlimentNonTrouveException(String message){
        super(message);
    }
}
