import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<Node> nodes = new ArrayList<>();

    public Node(String a)
    {
        this.name=a;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNeighbour(Node neighbour)
    {
       nodes.add(neighbour);
    }

    public void walkTrought(Visitor visitor)
    {
        visitor.visit(this);

        nodes.forEach(N->N.walkTrought(visitor));

    }
}
