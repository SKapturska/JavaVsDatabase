package javavsdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Sorting {
    
    SingletonConnection singletonConnection;
    
    long sqlSort(){
        singletonConnection = SingletonConnection.getInstance();
        long time = System.nanoTime();
        try {
            ResultSet rs = singletonConnection.st.executeQuery("select * from tab order by DATA");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return System.nanoTime()- time;
    }
}
