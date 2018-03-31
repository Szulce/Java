import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BazaTest {

    @Test
    public void DodanieUseraText()
    {
        Baza B = new Baza();
        B.dodaj("Magdalena","Szulc","505-178-055","Kościuszki Toruń","szulcat@wp.pl");
        assertThat(B.wyszukaj("Magdalena","Szulc")).isNotNull();


    }
    //nie używając bibiloteki
//assert yvty != null;
    @Test
    public void UsuniecieUseraTest(){
        Baza B = new Baza();
        B.dodaj("Magdalena","Szulc","505-178-055","Kościuszki Toruń","szulcat@wp.pl");
        B.usun("Magdalena","Szulc");
        assertThat(B.wyszukaj("Magdalena","Szulc")).isNull();
    }

    @Test
    public void ZmianaDanychTest()
    {
        Baza B = new Baza();
        B.dodaj("Magdalena","Szulc","505-178-055","Kościuszki Toruń","szulcat@wp.pl");
        Kontakt k = B.wyszukaj("Magdalena","Szulc");
        B.zmienTelAdrEmail(k,"000-000-000","Bydgoszcz","szulcmagdalena241d@gmail.com");
        assertThat(B.wyszukaj("Magdalena","Szulc").getTelefon()).isEqualTo("000-000-000");
        assertThat(B.wyszukaj("Magdalena","Szulc").getAdres()).isEqualTo("Bydgoszcz");
        assertThat(B.wyszukaj("Magdalena","Szulc").getEmail()).isEqualTo("szulcmagdalena241d@gmail.com");


    }


}
