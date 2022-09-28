public class ExceptionIncorrectPersonalName extends Exception {
    private static final String MESSAGE = "The name can not contain any numbers";

    public ExceptionIncorrectPersonalName(){
        super(MESSAGE);
    }
}