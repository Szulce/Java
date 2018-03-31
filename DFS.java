import java.util.List;
import java.util.Stack;

public class DFS {

private Stack<Vertex> stack;
public int najmniej;

    public DFS()
    {
        this.stack = new Stack<>();
        najmniej = 0;
    }

    public int dfs(List<Vertex> vertexList)
    {
        for(Vertex v : vertexList)
        {
            //if(!v.isVisited())
            if(v.getName().equals("0"))
            {
                v.setVisited(true);
             //  System.out.print(v+" ");
                dfsWithStack(v);
                break;
            }
        }
        return najmniej;
    }

    private void dfsWithStack(Vertex rootvertex) {

        this.stack.add(rootvertex);
        rootvertex.setVisited(true);

        while(!stack.isEmpty())
        {
            Vertex actualVertex = this.stack.pop();

         //   System.out.print("\nwypisuje aktualnie sprawdzany wertex "+actualVertex+" ");


            for(Vertex v :actualVertex.getNeighbourList())
            {
               // System.out.print("\nwypisuje jego sasiadów "+v+" ");

                if(!v.isVisited())
                {
                    if(Integer.parseInt(v.getName())<this.najmniej)
                    {
                        System.out.printf("\nwypisuje kandydata%d \n",Integer.parseInt(v.getName()));
                        this.najmniej = Integer.parseInt(v.getName());
                    }

                    v.setVisited(true);
                    this.stack.push(v);
                   // System.out.print("pushuje"+v.getName());
                }
            }
        }
    }
}
