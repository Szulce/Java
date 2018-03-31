import java.io.FileWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        try {
          int liczba = Integer.valueOf(input);
            System.out.println("TAK");

        }catch (NumberFormatException nfe)
        {
            System.out.println("NIE");

        }





    }

}
