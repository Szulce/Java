import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

public class Repository {

    private Connection conn;

    //public Connection createConnection() throws SQLException {
    Repository() throws SQLException{

        this.conn = null;
           conn = DriverManager.getConnection("jdbc:h2:mem:");


        System.out.println("Connected to database");
        // return conn;

    }

    public void initDb() throws SQLException{
       conn.createStatement().executeUpdate("CREATE TABLE PREMIE"+
                "(IMIE VARCHAR(30),NAZWISKO VARCHAR(30),PREMIA INTEGER)");
    }


    public void wstaw(String imie, String nazwisko, int premia) throws SQLException{

        // String[]SplitText = linia.split("\\+s");
    /*moj sposob

        Statement stmt = null;
        String query = "INSERT INTO PREMIE VALUES ("+SplitText[0]+","
                +SplitText[1]+","+SplitText[2]+")";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }*/
        //na zajeciach ale to ma injection
      /*  conn.createStatement().executeUpdate("INSERT INTO PREMIE VALUES ("+SplitText[0]+
        ","+SplitText[1]+","+SplitText[2]+")");*/

        //na zajeciach odpone na injection
     /*  PreparedStatement ps = conn.prepareStatement( "INSERT INTO PREMIE VALUES(?,?,?)");
        ps.setString(SplitText[0]);
        ps.setString(SplitText[1]);
        ps.setInt(Integer.parseInt(SplitText[2]));
        ps.executeUpdate();
        ps.close();*/

        //najlepiej
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO PREMIE VALUES(?,?,?)")) {
            ps.setString(1,imie);
            ps.setString(2,nazwisko);
            ps.setInt(3,premia);
            ps.executeUpdate();
        }

    }

    public int suma() throws SQLException {
/*
            Statement stmt = null;
            String query = "SELECT SUM(PREMIA)FROM PREMIE;";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

            } catch (SQLException e) {
                JDBCTutorialUtilities.printSQLException(e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }*/
        ResultSet rs = conn.createStatement().executeQuery("SELECT SUM(PREMIA) FROM PREMIE");
        if (rs.next()) {
           return rs.getInt(1);//bo w bazie danych numerujemy od 1 a tu definiujemy od czgo zacząć
        } else {
            throw new RuntimeException("Nie udało się zsumować!");
        }


    }

    public void usun(String imie, String nazwisko) throws SQLException {
            /*moje
            Statement stmt = null;
            String query = "DELETE IMIE,NAZWISKO ,PREMIA FROM PREMIE WHERE IMIE="
                    +imie+" AND NAZWISKO="+nazwisko+";";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

            } catch (SQLException e) {
                JDBCTutorialUtilities.printSQLException(e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }

        }*/
    /*
        conn.createStatement().executeUpdate("DELETE FROM PREMIE" +
                " WHERE IMIE =" + imie + " AND NAZWISKO=" + nazwisko + ")");*/

        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM PREMIE WHERE "+
                "IMIE=? AND NAZWISKO=?")) {
            ps.setString(1,imie);
            ps.setString(2,nazwisko);
            ps.executeUpdate();
        }
        System.out.println("usunięto");
    }


}


