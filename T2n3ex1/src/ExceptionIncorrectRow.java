public class ExceptionIncorrectRow extends Exception {
    private static final String MESSAGE = "The number of the row that you entered is incorrect";

    public ExceptionIncorrectRow(){
        super(MESSAGE);
    }
}
