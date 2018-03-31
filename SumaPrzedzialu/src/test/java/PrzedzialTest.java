
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrzedzialTest {


    @Test
    public void KonstruktorTest()
    {
        Przedzial Prz;
        List<Double> L;
        L = new ArrayList<Double>();
        L.add(6.);
        L.add(4.);
        L.add(3.);
        L.add(3.);
        L.add(5.);
        L.add(7.);
        L.add(4.);
        L.add(2.);
        Prz = new Przedzial(L);

        assertThat(Prz.Pom.size()).isEqualTo(L.size()+1);
        assertThat(Prz.Pom.contains(0.));
        assertThat(Prz.Pom.contains(6.));
        assertThat(Prz.Pom.contains(10.));
        assertThat(Prz.Pom.contains(13.));
        assertThat(Prz.Pom.contains(16.));
        assertThat(Prz.Pom.contains(21.));
        assertThat(Prz.Pom.contains(28.));
        assertThat(Prz.Pom.contains(32.));
        assertThat(Prz.Pom.contains(34.));
    }

    @Test
    public void PustyTest()
    {
        Przedzial Prz;
        List<Double> L;
        L = new ArrayList<Double>();
        L.add(6.);
        L.add(4.);
        L.add(3.);
        L.add(3.);
        L.add(5.);
        L.add(7.);
        L.add(4.);
        L.add(2.);
        Prz = new Przedzial(L);


        assertThat(Prz.SubSum(0,0)).isEqualTo(0);
        assertThat(Prz.SubSum(1,1)).isEqualTo(0);
        assertThat(Prz.SubSum(2,2)).isEqualTo(0);
        assertThat(Prz.SubSum(3,3)).isEqualTo(0);
        assertThat(Prz.SubSum(4,4)).isEqualTo(0);
        assertThat(Prz.SubSum(5,5)).isEqualTo(0);
        assertThat(Prz.SubSum(6,6)).isEqualTo(0);
        assertThat(Prz.SubSum(7,7)).isEqualTo(0);


    }

    @Test
    public void CalaTest()
    {
        Przedzial Prz;
        List<Double> L;
        L = new ArrayList<Double>();
        L.add(6.);
        L.add(4.);
        L.add(3.);
        L.add(3.);
        L.add(5.);
        L.add(7.);
        L.add(4.);
        L.add(2.);
        Prz = new Przedzial(L);

        assertThat(Prz.SubSum(0,Prz.Pom.size()-1)).isEqualTo(34.);
    }


    @Test(timeout = 500)
    public void WydajnoscTest()
    {
       // long Start = System.currentTimeMillis();
        Random r = new Random();
       // Random p = new Random();
        List<Double> Milion = new LinkedList<Double>();

        double b;
        for(int i=0;i<1000;i++)
        {

            b=r.nextDouble();
            Milion.add(b);

        }

        Przedzial Prze = new Przedzial(Milion);
      //  long Stop = System.currentTimeMillis();
      //  System.out.println("zaczynam odliczanie");
       // long StartTime = System.currentTimeMillis();

        for(int i=1;i<1000;i++)
        {
            Prze.SubSum(i,1000-i);
        }

       // long StopTime = System.currentTimeMillis();

       // System.out.println("czas:"+(StopTime-StartTime));
       // assertThat(StopTime-StartTime).isCloseTo(500);



    }

    @Test
    public void Czesc()
    {
        Przedzial Prz;
        List<Double> L;
        L = new ArrayList<Double>();
        L.add(6.);
        L.add(4.);
        L.add(3.);
        L.add(3.);
        L.add(5.);
        L.add(7.);
        L.add(4.);
        L.add(2.);
        Prz = new Przedzial(L);

        assertThat(Prz.SubSum(4,5)).isEqualTo(5);
        assertThat(Prz.SubSum(2,5)).isEqualTo(11);
    }
}
