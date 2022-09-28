import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ExceptionSeatOccupied,
            ExceptionEmptySeat, ExceptionIncorrectRow, ExceptionIncorrectSeat, ExceptionArrayOutOfBounds, ExceptionIncorrectPersonalName {

        System.out.println("Welcome");
        Cinema cinema1 = new Cinema();

        //askData() asks us the basic information about the cinema(number of rows and seats) that was created
        //before
            cinema1.askData();

        //startMenu() shows us the menu with different options
        int optionMenu = 0;

        do{
            optionMenu = cinema1.startMenu();
        }while(optionMenu!=0);

    }
}
