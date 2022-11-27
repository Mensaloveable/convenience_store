package convenience_store.exceptions;

public class NotEnoughQuantityException extends RuntimeException{
    public NotEnoughQuantityException(String message) {
        super(message);
    }
}
