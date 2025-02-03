import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Class.forName("org.postgresql.Driver");   - Apparently the posgresql driver is loaded by default
        //                                              when importing java.sql making this line obsolete.
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/";

        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "1234");
        Connection conn = DriverManager.getConnection(url, props);
        Statement st = conn.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS personnes ( nom VARCHAR(50), age SMALLINT)");
        st.executeUpdate("TRUNCATE TABLE personnes");
        // or
        // st.executeUpdate("DROP TABLE IF EXISTS personnes");
        // st.executeUpdate("CREATE TABLE personnes ( nom VARCHAR(50), age SMALLINT)");

        st.executeUpdate("INSERT INTO personnes VALUES ('Joe', 24)");
        st.executeUpdate("INSERT INTO personnes VALUES ('Valerie', 27)");
        st.executeUpdate("INSERT INTO personnes VALUES ('Carl', 26)");
        st.executeUpdate("INSERT INTO personnes VALUES ('Lettie', 26)");
        
        ResultSet rs = st.executeQuery( "SELECT * FROM personnes" );
        while (rs.next()) {
            String nom = rs.getString("nom");
            int age = rs.getInt("age");
            System.out.println( nom + " a " + age + " ans" );
        }
        rs.close();
        st.close();
        conn.close();
    }
}