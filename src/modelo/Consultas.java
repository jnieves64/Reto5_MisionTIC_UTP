package modelo;
import java.sql.DriverManager;
import java.sql.Connection;

public class Consultas {
        public static Connection connection = null;
        
        public static Connection conn(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectosconstruccion", "root", "");
                return conn;
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
    }
}
