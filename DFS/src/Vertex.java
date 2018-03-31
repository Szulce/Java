import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private int value;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(String name,int  c)
    {
        this.name=name;
        this.value=c;
        this.neighbourList = new ArrayList<>();

    }



    public String toString()
    {
        return this.name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public void addNeighbour(Vertex vertex)
    {
        this.neighbourList.add(vertex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }
}
