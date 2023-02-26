package coursework_2;

public class IncorrectArgumentException extends RuntimeException{

    public IncorrectArgumentException(String argument) {
        super(argument);
    }
}
