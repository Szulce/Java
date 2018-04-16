import java.util.Scanner;

public class App {

    public static void main(String args[])
    {
        System.out.println("wpisz liczbe");
        int n;
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        Silnia silnia = new Silnia();
        int wynik = 0;
        try {
            wynik = silnia.oblicz(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("silnia z tej liczby to "+wynik);
    }
}
