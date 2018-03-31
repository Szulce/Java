import java.util.ArrayList;
import java.util.List;

public class Baza {

    private List<Kontakt> BaZa = new ArrayList<Kontakt>();

    public void dodaj(String a,String b,String c,String d,String e)
    {
        Kontakt A = new Kontakt();
        A.setImie(a);
        A.setNazwisko(b);
        A.setTelefon(c);
        A.setAdres(d);
        A.setEmail(e);

        BaZa.add(A);

    }


    public void zmienTelAdrEmail(Kontakt A,String c,String d, String e)
    {
        A.setTelefon(c);
        A.setAdres(d);
        A.setEmail(e);

    }

    public void usun(String a, String b)
    {
        BaZa.removeIf(k ->k.getImie().equals(a) && k.getNazwisko().equals(b));

    }

    public void wyszukajPoImieniu(String a)
    {

        for(Kontakt k:BaZa)
        {
            if(k.getImie().equals(a))
            {
               System.out.println(k.getImie()+" "+k.getNazwisko());
               System.out.println(k.getAdres()+" tel.:"+k.getTelefon()+" "+k.getEmail());
            }System.out.println("");
        }
    }

    public void wyszukajPoNazwisku(String b)
    {

        for(Kontakt k:BaZa)
        {
            if(k.getImie().equals(b))
            {
                System.out.println(k.getImie()+" "+k.getNazwisko());
                System.out.println(k.getAdres()+" tel.:"+k.getTelefon()+" "+k.getEmail());
            }System.out.println("");
        }
    }

    public int wyszukajPoNazwie(String a,String b)
    {
        int i=0;
        for(Kontakt k:BaZa)
        {
            if(k.getImie().equals(a) && k.getNazwisko().equals(b))
            {   i++;
                System.out.println(k.getImie()+" "+k.getNazwisko());
                System.out.println(k.getAdres()+" tel.:"+k.getTelefon()+" "+k.getEmail());
            }System.out.println("");

        }
        return i;
    }

    public Kontakt wyszukaj(String a,String b)
    {
        for(Kontakt k:BaZa)
        {
            if(k.getImie().equals(a) && k.getNazwisko().equals(b))
            {
                return k;
            }

        }
        return null;
    }

    public void showAll()
    {
        for (Kontakt k:BaZa) {

            k.showK();
            System.out.println("");
        }
    }



}
