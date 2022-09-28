public class ExceptionIncorrectSeat extends Exception {
    private static final String MESSAGE = "The number of the seats that you entered is incorrect";

    public ExceptionIncorrectSeat(){
        super(MESSAGE);
    }
}
