import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class APP {

    public static void main(String[] args) throws FileNotFoundException
    {
        File plik = new File("/tmp/tresczadania.txt");
       // Scanner odczyt = new Scanner(new File("nazwa_pliku.txt"));
        PrintWriter zapis = new PrintWriter("/tmp/tresczadania.txt");
        zapis.println("Napisz program który utworzy plik /tmp/tresczadania.txt i" +
                "zapisze do niego treść tego zadania.");
        zapis.close();

    }
}
