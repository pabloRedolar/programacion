package Excepciones;

public class ApareamientoImposibleException extends Exception{
    public ApareamientoImposibleException(String message) {
        super("Apareamiento imposible, los dos son "+message);
    }
}
