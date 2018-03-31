import java.awt.peer.SystemTrayPeer;
import java.util.*;

public class App {

    public static void main(String[] args) {

         Scanner scan =new Scanner(System.in);
         String Linia = scan.nextLine();
         String[] SplitText = Linia.split("\\s+");
         List<Double> Li = new ArrayList<Double>();
        Double nr;
        for (String s : SplitText) {
            nr = Double.parseDouble(s);
            Li.add(nr);
        }
        Przedzial Przed = new Przedzial(Li);
        while (!Linia.equals("quit")) {

            Linia = scan.nextLine();
            int pocz,kon;
            SplitText = Linia.split("\\s+");
            pocz = Integer.parseInt(SplitText[0]);
            kon = Integer.parseInt(SplitText[1]);
            System.out.println(Przed.SubSum(pocz,kon));
        }
    }
}
