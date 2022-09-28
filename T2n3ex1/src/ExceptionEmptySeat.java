public class ExceptionEmptySeat extends Exception{
    private static final String MESSAGE = "This seat is empty";

    public ExceptionEmptySeat(){
        super(MESSAGE);
    }

}
