
import java.util.Scanner;

public class Cinema {
    static Scanner scan = new Scanner(System.in);
    private int numRows;
    private int numSeats;
    private final SeatManagement sm = new SeatManagement();

    public Cinema() {

    }


    public Cinema(int numRows, int numSeats) {
        this.numRows = numRows;
        this.numSeats = numSeats;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public void askData() {
            System.out.println("How many rows does this cinema have");
            this.numRows = scan.nextInt();
            System.out.println("How many seat in on row does this cinema has");
            this.numSeats = scan.nextInt();
    }

    /**
     * Menu with different option that leads us to another methods. Sometimes they throw exceptions
     * @throws ExceptionSeatOccupied
     * @throws ExceptionArrayOutOfBounds
     */
    public int startMenu() throws ExceptionSeatOccupied, ExceptionArrayOutOfBounds, ExceptionIncorrectPersonalName, ExceptionIncorrectRow, ExceptionIncorrectSeat, ExceptionEmptySeat {
        int option = 0;
        do {
                System.out.println("Choose an option:\n"
                        + "1.Show all the booked seats.\n"
                        + "2.Show all the booked seats per person\n"
                        + "3.Book a seat\n"
                        + "4.Cancel the booking\n"
                        + "5.Cancel all the bookings per person\n"
                        + "0.Exit");

                option = scan.nextInt();
                switch (option) {
                    case 1:
                            showSeats();
                        break;
                    case 2:
                            showSeatsPerson();
                        break;
                    case 3:
                            bookSeat();
                        break;
                    case 4:
                            cancelBooking();
                        break;
                    case 5:

                            cancelAllBooking();
                        break;
                }
        }while (option != 0);
        return option;
    }

    /**
     * Show all the booked seats, but if there isn't any, throws the exception
     * @throws ExceptionArrayOutOfBounds
     */
    public void showSeats() throws ExceptionArrayOutOfBounds {
            if(sm.smList.isEmpty()){
                throw new ExceptionArrayOutOfBounds();
            }else {
                    for (Seat s : sm.smList
                    ) {
                        System.out.println(s);
                    }
                }
    }

    /**
     * Shows all the booked seats per one person.
     * If there is not any introduced name > "Name not found"
     * If the list is empty, it throws an exception
     */
    public void showSeatsPerson() throws ExceptionArrayOutOfBounds, ExceptionIncorrectPersonalName {
            if(sm.smList.isEmpty()){
                throw new ExceptionArrayOutOfBounds();
            }else {
                String searchName = "";
                boolean nameFound = false;
                searchName = enterName();
                for (int i = 0; i < sm.smList.size(); i++) {
                    Seat seatName = sm.smList.get(i);
                    if (searchName.equalsIgnoreCase(seatName.getName())) {
                        System.out.println(sm.smList.get(i).toString());
                        nameFound = true;
                    }
                }
                if(!nameFound){
                    System.out.println("There is no booking for this name");
                }
            }

    }

    /**
     * method asks the number of row, seat and the name
     * and if everything is correct adds the object to the ArrayList
     * In case the seat with the same parameters is found, it throws an exception
     * @throws ExceptionSeatOccupied
     */
    public void bookSeat() throws ExceptionSeatOccupied, ExceptionIncorrectRow, ExceptionIncorrectSeat {
        Seat seatBook = new Seat();
        seatBook.setRow(enterNumRow());
        seatBook.setNumber(enterNumSeat());
        try{
            if(sm.addSeat(seatBook)){
                seatBook.setName(enterName());
                System.out.println("This seat is booked successfully");
            }else{
                throw new ExceptionSeatOccupied();
            }
        }catch(ExceptionSeatOccupied e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * The method asks the number of the row.
     * It has to be 0 and the number of the row of the Cinema that we've introduced at the beginning.
     * If the number of the row is incorrect, the method throws exception.
     * @return number of the row
     */
    public int enterNumRow() throws ExceptionIncorrectRow {
        int myRow = 0;
        while(true){
            try {
                System.out.println("Enter the number of the row");
                myRow = scan.nextInt();
                if (myRow <= this.numRows && myRow > 0) {
                    //correct seat Row
                } else {
                    throw new ExceptionIncorrectRow();
                }
                break;
            } catch (ExceptionIncorrectRow e) {
                System.out.println(e.getMessage());
            }
        }
        return myRow;
    }

    /**
     * The method asks the number of the seat
     * It has to be within 0 and the number of the seats that we've introduced at the beginning
     * If the num of the seat is incorrect, the method throws exception
     * @return number of the Seat
     */
    public int enterNumSeat(){
        int mySeat = 0;
        while (true) {
            try {
                System.out.println("Enter the number of the seat");
                mySeat = scan.nextInt();
                if (mySeat <= this.numSeats && mySeat > 0) {
                    //correct seat number
                } else {
                    throw new ExceptionIncorrectSeat();
                }
                break;
            } catch (ExceptionIncorrectSeat e) {
                System.out.println(e.getMessage());
            }
        }
        return mySeat;
    }

    /**
     * Asks the name. It shouldn't contain any number
     * If the name is incorrect, the method throws an exception
     * @return name
     */
    public String enterName(){
        String myName = "";
        while(true) {
            try{
                System.out.println("Enter the name");
                scan.nextLine();
                myName = scan.nextLine();
                if (myName.matches(".*[0-9].*")) {
                    throw new ExceptionIncorrectPersonalName();
                }
                break;
            } catch (ExceptionIncorrectPersonalName e) {
                System.out.println(e.getMessage());
            }
        }
        return myName;
    }

    /**
     * method which cancels the booking calling for enterNumRow() and enterNumSeat(). After creating a new object
     * we call sm.searchSeat (in SeatManagement) that removes the object with that parameters.
     * @throws ExceptionSeatOccupied
     * @throws ExceptionArrayOutOfBounds
     */
    public void cancelBooking() throws  ExceptionArrayOutOfBounds, ExceptionEmptySeat {
            if(sm.smList.isEmpty()){
                throw new ExceptionArrayOutOfBounds();
            }else {
                try {
                    Seat cancelSeat = new Seat();
                    cancelSeat.setRow(enterNumRow());
                    cancelSeat.setNumber(enterNumSeat());
                    if (sm.deleteSeat(cancelSeat)) {
                        System.out.println("This booking was deleted successfully");
                    } else {
                        throw new ExceptionEmptySeat();
                    }
                }catch(ExceptionEmptySeat e){
                    System.out.println(e.getMessage());
                } catch (ExceptionIncorrectRow e) {
                    throw new RuntimeException(e);
                }
            }

    }

    /**
     * If the list is emply, it throws an exception
     * Otherwise it call enterName(), searches for it in the list and cancels the bookings for this name
     * @throws ExceptionArrayOutOfBounds
     * @throws ExceptionIncorrectPersonalName
     */

    public void cancelAllBooking() throws ExceptionArrayOutOfBounds, ExceptionIncorrectPersonalName {
            if (sm.smList.isEmpty()) {
                throw new ExceptionArrayOutOfBounds();
            }
                int count = 0;
            String cancelName = enterName();
                boolean deletedBook = false;
                for (int i = 0; i < sm.smList.size(); i++) {
                    Seat delSeat = sm.smList.get(i);
                    if (cancelName.equalsIgnoreCase(delSeat.getName())) {
                        sm.smList.remove(i);
                        count += 1;
                        i--;
                        deletedBook = true;
                    }
                }

                if(deletedBook){
                    System.out.println(+ count + " booking for the name " + cancelName + " was/were canceled in total");
                }else{
                    System.out.println("There is no booking for this name");
                }


    }
}

