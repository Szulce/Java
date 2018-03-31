
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws SQLException {

        Repository R = new Repository();
        //Connection connection = R.createConnection();
        R.initDb();

        Scanner scanner = new Scanner(System.in);
        System.out.println( "wyjscie/wstaw imie nazwisko pensja/suma/usun");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");

            switch (command[0]) {
                case "wyjscie":
                    System.exit(0);
                case "wstaw":
                    int l=0;
                    try{l =Integer.parseInt(command[3]);}
                    catch(NumberFormatException nfe){ System.out.println("NOT A NUMBER");}
                    R.wstaw(command[1],command[2],l);
                    System.out.println("wstawiono");
                    break;
                case "suma":
                    System.out.println(R.suma());
                    break;
                case "usun":
                    R.usun(command[1],command[2]);
            }
        }
    }
}
