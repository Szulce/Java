
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws SQLException {


        ConnectionToBase connection = new ConnectionToBase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("wyjscie/wstaw imie nazwisko pensja/suma/usun");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");

            switch (command[0]) {

                case "wyjscie":

                    connection.close();
                    System.exit(0);

                case "wstaw":

                    if (command.length > 3) {

                        int l = 0;

                        try {

                            l = Integer.parseInt(command[3]);

                        } catch (NumberFormatException nfe) {

                            System.out.println("NOT A NUMBER");
                            break;
                        }
                         connection.wstaw(command[1],command[2],l);

                        System.out.println("wstawiono");

                    }

                    else System.out.println("za mało danych");
                    break;

                case "suma":
                    connection.suma();
                   // System.out.println(//R.suma());
                    break;
                case "usun":
                   if(command.length<2)System.out.println("Za mało danych");
                     connection.usun(command[1],command[2]);
                     break;
                default:
                    System.out.println("Polecenie wpisano niepoprawnie");
                    break;
            }
        }
    }
}
