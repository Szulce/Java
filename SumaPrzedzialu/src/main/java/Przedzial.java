import java.util.ArrayList;
import java.util.List;

public class Przedzial {


    public List<Double> Pom = new ArrayList<Double>();//MALA

    public Przedzial(List<Double> L)
    {
        Pom.add(0,0.);
        Pom.add(1,L.get(0));
        for(int i=2;i<L.size()+1;i++)
        {
            Pom.add(i,Pom.get(i-1)+L.get(i-1));

        }

    }

    public Double SubSum(int from,int to)
    {
       // if(to==from)return Pom.get(0);
        return Pom.get(to)-Pom.get(from);
    }


}
