package javavsdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SingletonConnection {

    private static SingletonConnection instance = null;
    String URL = "jdbc:mysql://127.0.0.1/javavsdatabase?user=root&password=haslo";
    Connection conn;
    Statement st;

    private SingletonConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public void fillTab() {
        Random r = new Random();
        for (int i = 1000; i < 1500000; i++) {
            try {
                st.executeUpdate("INSERT INTO tab VALUES("+ i +", "+ r.nextLong() +")");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
