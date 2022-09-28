import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);
    public static byte readByte(){
        byte res = 0;
        while(true){
            try{
                System.out.println("Enter byte");
                res=scan.nextByte();
                break;
            } catch (InputMismatchException e) {
            System.out.println("Format error");
                scan = new Scanner(System.in);
        }

        }
     return res;
    }

    public static int readInteger(){
        int res = 0;
        while(true){
            try{
                System.out.println("Enter integer");
                res=scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Format error");
                scan = new Scanner(System.in);
            }

        }
        return res;
    }

    public static float readFloat(){
        float res = 0;
        while(true){
            try{
                System.out.println("Enter float (using coma)");
                res=scan.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Format error");
                scan = new Scanner(System.in);
            }
        }
        return res;
    }
    public static double readDouble(){
        double res = 0;
        while(true){
            try{
                System.out.println("Enter double");
                res=scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Format error");

                scan = new Scanner(System.in);
            }

        }
        return res;
    }

    public static char readChar(){
        char res = ' ';
        while(true){
            try{
                System.out.println("Enter char");
                String resStr=scan.next();
                scan.nextLine();
                if(resStr.length()>1){
                    throw new Exception("Format error");
                }
                res = resStr.charAt(0);
                break;
            } catch (Exception e) {
                System.out.println("Format error");

                scan = new Scanner(System.in);
            }

        }
        return res;
    }

    public static String readString(){
        String res = "";
        while(true){
            try{
                System.out.println("Enter String");
                res=scan.nextLine();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Format error");

                scan = new Scanner(System.in);
            }

        }
        return res;
    }
    public static boolean readYesNo(){
        boolean res = false;
        String option = "";
        while(true){
            try{
                System.out.println("Enter y if true OR n if false");
                option = scan.next();
                if(option.equalsIgnoreCase("y")){
                    res = true;
                }else if(option.equalsIgnoreCase("n")){
                    res = false;
                }else{
                    throw new IOException();
                }
                break;
            } catch (IOException e) {
                System.out.println("Format error");

                scan = new Scanner(System.in);
            }

        }
        return res;
    }
}
