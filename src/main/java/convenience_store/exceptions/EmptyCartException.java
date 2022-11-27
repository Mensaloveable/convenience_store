package convenience_store.exceptions;

public class EmptyCartException extends IllegalArgumentException{
    public EmptyCartException(String message){
        super(message);
    }
}
