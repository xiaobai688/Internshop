public class NoRealRootException extends Throwable {
        String message;

        NoRealRootException(String s) {
            message=s;
        }
        public String getMessage(){
            return message;
        }
}
