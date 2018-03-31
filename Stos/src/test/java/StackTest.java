import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StackTest {

    @Test
    public void EmptyCheck()
    {
        Stack<Integer> Stack = new Stack<Integer>();

        assertThat(Stack.getRozmiar()).isEqualTo(0);
        assertThat(Stack.pop()).isNull();

    }

    @Test
    public void PopCheck()
    {
        Stack<Integer> Stack = new Stack<Integer>();
        assertThat(Stack.pop()).isNull();
        Stack.push(1);
        assertThat(Stack.pop()).isEqualTo(1);
        assertThat(Stack.getRozmiar()).isEqualTo(0);

    }

    @Test
    public void PushCheck()
    {
        Stack<Integer> Stack = new Stack<Integer>();

        Stack.push(1);
        assertThat(Stack.getRozmiar()).isEqualTo(1);
        assertThat(Stack.pop()).isEqualTo(1);

    }


}
