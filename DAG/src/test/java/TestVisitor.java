import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TestVisitor {

    private static Node A,B,C,D,E,F;

    @BeforeClass
    public static void TestVisitor()
    {
        A = new Node("a");
        B = new Node("b");
        C = new Node("c");
        D = new Node("d");
        E = new Node("e");
        F = new Node("f");

        A.addNeighbour(B);
        A.addNeighbour(C);
        C.addNeighbour(D);
        C.addNeighbour(E);
        E.addNeighbour(F);

    }


        @Test
        public void walktrouhTest()
        {
            NameCollector collector = new NameCollector();
            A.walkTrought(collector);
            assertThat(collector.names).hasSameElementsAs(Arrays.asList("a","b","c","d","e","f"));

        }

    public static class NameCollector implements Visitor
    {
        private List<String> names = new ArrayList<>();
        public void visit(Node N)
        {
            names.add(N.getName());
        }

    }

}


