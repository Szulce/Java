import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WyrażenieTest {


    @Test
    public void wyniczekpusty()
    {
        Wyrazenie wyrazenie = new Wyrazenie();
        assertThat(wyrazenie.getWyniczek()).isEqualTo(0.);
        assertThat(wyrazenie.polynomialValue(1.)).isEqualTo(0.);
    }
    @Test
    public void wyniczek1()
    {
        Wyrazenie wyrazenie = new Wyrazenie();
        assertThat(wyrazenie.polynomialValue(1.,1.)).isEqualTo(1);
        assertThat(wyrazenie.getWyniczek()).isEqualTo(1);
    }

    @Test
    public void wyniczek2()
    {
        Wyrazenie wyrazenie = new Wyrazenie();
        assertThat(wyrazenie.polynomialValue(1., 3., 4., 4., 2.)).isEqualTo(13);
    }

    @Test
    public void wyniczek3()
    {
        Wyrazenie wyrazenie = new Wyrazenie();
        assertThat(wyrazenie.polynomialValue(1., 1., 1., 1., 1., 1., 1., 1. )).isEqualTo(7.);
    }

    @Test
    public void wyniczek4()
    {
        Wyrazenie wyrazenie = new Wyrazenie();
        assertThat(wyrazenie.polynomialValue(58., 2., 13., 89., 111.)).isEqualTo(21957584.);
        assertThat(wyrazenie.getWyniczek()).isEqualTo(21957584.);
    }



}
