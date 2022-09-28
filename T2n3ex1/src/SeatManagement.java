
import java.util.ArrayList;

public class SeatManagement {
    ArrayList<Seat> smList = new ArrayList<>();
    public SeatManagement(){
    }

    /**
     * gets all the object of the list
     */
    public void getSeats(){
        for(int i = 0; i< smList.size();i++){
            System.out.println(smList.get(i));
        }
    }

    /**
     * Method which adds the seat after searchSeat() verifies if there is another object (Seat) with
     * the same parameters
     * @return boolean true if seat is added to the list / false if not
     */
    public boolean addSeat(Seat seatBook){
        Seat seatSearch = seatBook;
        boolean seatBooked = false;
        if(!smList.contains(seatBook)){
            smList.add(seatBook);
            seatBooked = true;
        }
        return seatBooked;
    }

    /**
     *This method also uses seachSeat to find an index
     * If index is -1, it means that the seat with this parameters wasn't found and the return is false.
     * Otherwise this object is removed from the list
     * @param cancelSeat is an object created in class Cinema method cancelBooking()
     * @return boolean seatDeleted
     */
    public boolean deleteSeat(Seat cancelSeat){
        boolean seatDeleted = false;
        Seat seatSearch = cancelSeat;
            int index = searchSeat(seatSearch);
            if(index != -1){
                smList.remove(index);
                seatDeleted = true;
            }
        return seatDeleted;
    }

    public int searchSeat(Seat seatSearch){
        int index = 0;
            boolean seatFound = false;
            if(!smList.isEmpty()) {
                for (int i = 0; i < smList.size() && seatFound == false; i++) {
                    Seat newSeat = smList.get(i);
                    if (newSeat.getRow() == seatSearch.getRow() && newSeat.getNumber() == seatSearch.getNumber()) {
                        seatFound = true;
                        index = i;
                    } else {
                        index = -1;
                    }
                }
            }else{
                index = -1;
            }
        return index;
    }
}

