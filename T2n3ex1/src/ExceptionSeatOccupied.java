public class ExceptionSeatOccupied extends Exception{
    private static final String MESSAGE = "This seat is already booked";

    public ExceptionSeatOccupied(){
        super(MESSAGE);
    }
}
