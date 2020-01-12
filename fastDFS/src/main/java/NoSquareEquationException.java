public class NoSquareEquationException extends Throwable {
    String message;

    NoSquareEquationException(String s) {
        message=s;
    }
    public String getMessage(){
        return message;
    }
}

