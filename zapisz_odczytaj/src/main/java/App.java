import javax.xml.crypto.Data;
import java.awt.*;
import java.io.*;

import java.nio.Buffer;
import java.util.Date;

public class App {

    public static void main(String[] args) throws Exception
    {
        Container container = new Container();
        File plik = new File("/tmp/container.bin");
        String dowolny_tekst ="a";

        if(plik.isFile())
        {
            //1
            FileInputStream fis = new FileInputStream(plik);
            ObjectInputStream ois = new ObjectInputStream(fis);
           container = (Container) ois.readObject();
           System.out.println("CONTAINER :"+container.getContent()+" data:"+container.getDate());
            //2
            dowolny_tekst=new StringBuilder(dowolny_tekst).append("a").toString();
           container.setContent(dowolny_tekst);
           Date data = new Date();
           container.setDate(data);
           FileOutputStream fos = new FileOutputStream(plik);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(container);

        }
        else
        {
            try {
                BufferedWriter zapis = new BufferedWriter(new FileWriter(plik));
                dowolny_tekst= new StringBuilder(dowolny_tekst).append("a").toString();
                container.setContent(dowolny_tekst);
                Date data = new Date();
                container.setDate(data);
                FileOutputStream fos = new FileOutputStream(plik);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(container);


            }catch (IOException e)
            {
                e.printStackTrace();
            }

        }


    }
}
