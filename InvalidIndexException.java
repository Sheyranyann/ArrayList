public class InvalidIndexException extends IndexOutOfBoundsException{
    public InvalidIndexException(){}
    public InvalidIndexException(String message) {
        super(message);
    }
}
