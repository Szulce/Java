import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

public class Repository {

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    //public Connection createConnection() throws SQLException {
    Repository() throws SQLException{

        this.conn = null;
        conn = DriverManager.getConnection("jdbc:h2:mem:");


        System.out.println("Connected to database");


    }

    public void initDb() throws SQLException{
        conn.createStatement().executeUpdate("CREATE TABLE PREMIE"+
                "(IMIE VARCHAR(30),NAZWISKO VARCHAR(30),PREMIA INTEGER)");
    }


    public void wstaw(String imie, String nazwisko, int premia) throws SQLException{

        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO PREMIE VALUES(?,?,?)")) {
            ps.setString(1,imie);
            ps.setString(2,nazwisko);
            ps.setInt(3,premia);
            ps.executeUpdate();
        }

    }

    public int suma() throws SQLException {

        ResultSet rs = conn.createStatement().executeQuery("SELECT SUM(PREMIA) FROM PREMIE");
        if (rs.next()) {
            return rs.getInt(1);//bo w bazie danych numerujemy od 1 a tu definiujemy od czgo zacząć
        } else {
            throw new RuntimeException("Nie udało się zsumować!");
        }


    }

    public void usun(String imie, String nazwisko) throws SQLException {


        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM PREMIE WHERE "+
                "IMIE=? AND NAZWISKO=?")) {
            ps.setString(1,imie);
            ps.setString(2,nazwisko);
            ps.executeUpdate();
        }
        System.out.println("jesli istniało to usunięto");
    }


}


