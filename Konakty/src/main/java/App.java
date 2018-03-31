import java.util.Scanner;

public class App {

    public static void main(String[] args)
    {
                Baza B = new Baza();
        Scanner scan = new Scanner(System.in);
        String polecenie ;
        boolean dziala =true;
        while (dziala)
        {
          System.out.println("Zdefiniuj akcje:");
          System.out.println("0 : zamknij");
          System.out.println("1 : dodaj");
          System.out.println("2 : usun");
          System.out.println("3 : wyszukaj");
          System.out.println("4 : zmien");
          System.out.println("5 : show all");

            polecenie = scan.nextLine();

            switch(polecenie)
            {
                case "0":
                {
                    System.out.println("koniec");
                    dziala = false;}
                    break;
                case "1": {
                    System.out.println("wpisz dane:");
                    String imie, nazwisko,telefon ,adres, email;
                    imie = scan.nextLine();
                    nazwisko = scan.nextLine();
                    telefon = scan.nextLine();
                    adres = scan.nextLine();
                    email = scan.nextLine();

                    B.dodaj(imie, nazwisko, telefon, adres, email);

                    System.out.println("dodawanie kontaktu zakończone sukcesem");
                }
                    break;
                case "2":
                {
                    System.out.println("wpisz imie i nazwisko:");
                    String nazwa;
                    nazwa = scan.nextLine();
                    String[] splitText = nazwa.split("\\s+");
                   int u=B.wyszukajPoNazwie(splitText[0],splitText[1]);
                    if(u==0){
                        System.out.println("nie znaleziono takiego kontaktu");
                    }
                    else if(u==1){
                        System.out.println("usunieto kontakt");
                        B.usun(splitText[0],splitText[1]);
                    }
                    else{
                        System.out.println("wyszukano wiecej niz jeden kontakt!!");
                        System.out.println("wpisz T jesli chcesz usunac je wszystkie");
                        nazwa = scan.nextLine();
                        if(nazwa.equals("T"))
                        {
                            B.usun(splitText[0],splitText[1]);
                        }
                    }


                }break;

                case "3":
                {
                    System.out.println("wpisz nazwe:");
                    String nazwa =scan.nextLine();
                    String[] spliText = nazwa.split("\\s+");
                    if(spliText.length==1)
                    {
                        B.wyszukajPoImieniu(nazwa);
                        B.wyszukajPoNazwisku(nazwa);
                    }
                    else
                    {
                        B.wyszukajPoNazwie(spliText[0],spliText[1]);
                        B.wyszukajPoNazwie(spliText[1],spliText[0]);
                    }



                }break;

                case "4": {
                    System.out.println("wpisz imie:");
                    String imie, nazwisko,telefon ,adres, email;
                    imie = scan.nextLine();
                    System.out.println("wpisz nazwisko:");
                    nazwisko = scan.nextLine();
                    System.out.println("wpisz telefon adres i email do zmiany:");
                    telefon = scan.nextLine();
                    adres = scan.nextLine();
                    email = scan.nextLine();
                   Kontakt k = B.wyszukaj(imie,nazwisko);
                    B.zmienTelAdrEmail(k,telefon,adres,email);

                    System.out.println("zmiana kontaktu zakończone sukcesem");
                }
                break;
                case "5":
                {
                    B.showAll();
                }
                break;




            }

        }

    }
}
