import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnimalTest {

    @Test
    private void penguinTest()
    {
        Penguin P = new Penguin();
        P.setName("Pingwin");
        assertThat(P.getName()).isEqualTo("Pingwin");
        assertThat(P.moves()).isEqualTo(Animal.MovesReturn.flies);
        assertThat(P.eatsAsAChild()).isEqualTo(Animal.EatReturn.who_knows);
    }

    @Test
    protected void pigeonTest()
    {
        Pigeon P = new Pigeon();
        P.setName("Pigeon");
        assertThat(P.getName()).isEqualTo("Pigeon");
        assertThat(P.moves()).isEqualTo(Animal.MovesReturn.flies);
        assertThat(P.eatsAsAChild()).isEqualTo(Animal.EatReturn.who_knows);
    }

    @Test
    protected void sharkTest()
    {
        Shark P = new Shark();
        P.setName("Shark");
        assertThat(P.getName()).isEqualTo("Shark");
        assertThat(P.moves()).isEqualTo(Animal.MovesReturn.swims);
        assertThat(P.eatsAsAChild()).isEqualTo(Animal.EatReturn.who_knows);
    }

    @Test
    protected void whaleTest()
    {
        Whale P = new Whale();
        P.setName("Whale");
        assertThat(P.getName()).isEqualTo("Whale");
        assertThat(P.moves()).isEqualTo(Animal.MovesReturn.swims);
        assertThat(P.eatsAsAChild()).isEqualTo(Animal.EatReturn.who_knows);
    }

    @Test
    protected void bearTest()
    {
        Bear P = new Bear();
        P.setName("Bear");
        assertThat(P.getName()).isEqualTo("Bear");
        assertThat(P.moves()).isEqualTo(Animal.MovesReturn.walks);
        assertThat(P.eatsAsAChild()).isEqualTo(Animal.EatReturn.milk);
    }


}
