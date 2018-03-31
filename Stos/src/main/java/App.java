import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Stack<Integer> ST = new Stack<Integer>();
        Scanner scan = new Scanner(System.in);
        String dane = scan.nextLine();
        if (dane.length() > 3) {
            String[] SplitText = dane.split("\\s+");
            if (SplitText.length > 1) {
                for (int i = 0; i < SplitText.length; i++) {


                    if (SplitText[i].matches("-?\\d+(\\.\\d+)?")) {
                        try {
                             ST.push(Integer.parseInt(SplitText[i]));
                        } catch (NumberFormatException ex)
                        {
                            System.err.println("Ilegal input");
                        }
                    } else {
                        switch (SplitText[i]) {
                            case "+": {
                                int c, b;
                                c = ST.pop();
                                b = ST.pop();
                                ST.push(b + c);

                            }
                            break;
                            case "-": {
                                int c, b;
                                c = ST.pop();
                                b = ST.pop();
                                ST.push(b - c);
                            }
                            break;
                            case "*": {
                                int c, b;
                                c = ST.pop();
                                b = ST.pop();
                                ST.push(b * c);
                            }
                            break;
                            case "/": {
                                int c, b;
                                c = ST.pop();
                                b = ST.pop();
                                ST.push(b / c);
                                                         }
                            break;
                        }
                    }
                }

                if (!ST.isEmpty()) {
                    System.out.println("Wynik to :" + ST.pop());
                }
            }
        }
    }
}
