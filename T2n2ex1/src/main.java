import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Create an Input class to control exceptions when you enter different data types.
all the methods receive a String message (for example, "Enter the byte")
and return the appropriate data that the user has entered
 InputMismatchException: byte, int, float, double
 */



public class main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int option = 0;
        String ans = "";
        do {
            System.out.println("Choose one option:\n"
                    + "1.Read Byte\n"
                    + "2.Read Integer\n"
                    + "3.Read Float\n"
                    + "4.Read Double\n"
                    + "5.Read Char\n"
                    + "6.Read String\n"
                    + "7.Read Yes/No\n"
                    + "0.Exit");

            option = input.nextInt();
            switch (option) {
                case 1:
                    ans = "You entered correct data type " + Input.readByte();
                    break;
                case 2:
                    ans = "You entered correct data type " + Input.readInteger();
                    break;
                case 3:
                    ans = "You entered correct data type " + Input.readFloat();
                    break;
                case 4:
                    ans = "You entered correct data type " + Input.readDouble();
                    break;
                case 5:
                    ans = "You entered correct data type " + Input.readChar();
                    break;
                case 6:
                    ans = "You entered correct data type " + Input.readString();
                    break;
                case 7:
                    ans = "You entered correct data type " + Input.readYesNo();
                    break;
            }
            System.out.println(ans);
        }while(option!=0);


    }

}

