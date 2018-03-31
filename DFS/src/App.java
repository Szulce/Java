import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        List<Vertex> list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("wpisz nr:");
        String linia;
        int wierzcholki=0;


        while (scan.hasNextLine())
        {

            linia = scan.nextLine();
            String[] splitText = linia.split("\\s+");
            boolean jest =false;
            //spawdzam czy nie istanieje
            Vertex vd =new Vertex(splitText[0],wierzcholki) ;
            if(!list.isEmpty()) {
                for (Vertex v : list) {
                    if (v.getValue()==wierzcholki) {
                        vd=null;
                        vd =v;
                        vd.setName(splitText[0]);
                        jest =true;

                    }
                }

            }
            if(!jest)list.add(vd);
            wierzcholki++;



            for (int h = 1; h < splitText.length; h++)
            {Vertex vdn = new Vertex(Integer.parseInt(splitText[h]));
            jest = false;
                for (Vertex v : list ) {
                    if (v.getValue()==Integer.parseInt(splitText[h])) {
                        vdn = null;
                        vdn = v;
                        jest=true;
                        }

                }
                if(!jest){list.add(vdn);}
                vd.addNeighbour(vdn);


            }
            //wypisuje wierzchołlki
           System.out.println("wypisuje wierzchołlki");
            for(Vertex v :list)
            {
                System.out.print(v.getValue()+" ");
            }


        }


        DFS dfs = new DFS();

        int liczba = dfs.dfs(list);
        System.out.printf("\n wynik:%d \n",liczba);
        scan.close();
    }
}