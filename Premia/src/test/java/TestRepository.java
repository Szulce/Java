import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class TestRepository {

    private Repository r;
    private Connection c;
    private String imie;
    private String nazwisko;
    private int premia;

    @Before
    public void setUp() throws Exception {

         r = new Repository();
        c = r.getConn();
        r.initDb();
        imie = "Kasia";
        nazwisko = "Sztosik";
        premia = 300;


    }
    @Test
    public void connectionTest() throws SQLException {
        assertThat(c).isNotNull();

    }
    @Test
    public void wstawPoprawneDaneTest() throws SQLException {


        r.wstaw(imie,nazwisko,premia);

        assertEquals(r.suma(),300);

    }
    @Test
    public void usunTest() throws SQLException{
        r.wstaw(imie,nazwisko,premia);
        r.usun(imie,nazwisko);
        assertEquals(r.suma(),0);
    }
    @Test
    public void sumaTest() throws SQLException{
        r.wstaw(imie,nazwisko,premia);
        premia = 200;
        r.wstaw(imie,nazwisko,premia);
        premia = 100;
        r.wstaw(imie,nazwisko,premia);
        assertEquals(r.suma(),600);
    }
}
