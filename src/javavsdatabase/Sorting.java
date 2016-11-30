package javavsdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sorting {

    SingletonConnection singletonConnection;
    long[][] data;

    long sqlSort() {
        singletonConnection = SingletonConnection.getInstance();
        long time = System.nanoTime();
        try {
            ResultSet rs = singletonConnection.st.executeQuery("select * from tab order by DATA");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return System.nanoTime() - time;
    }

    long javaSort() {
        long time = System.nanoTime();
        boolean swap = true;
        for (int i = 0; i < data.length && swap; i++) {
            swap = false;
            for (int k = 0; k < data.length - 1; k++) {
                if (data[k][1] > data[k + 1][1]) {
                    long x = data[k][0], y = data[k][1];
                    data[k][0] = data[k + 1][0];
                    data[k][1] = data[k + 1][1];
                    data[k + 1][0] = x;
                    data[k + 1][1] = y;
                    swap = true;
                }
            }
        }
        return System.nanoTime() - time;
    }

    void fillTable() {
        data = new long[1500000][2];
        int i = 0;
        try {
            ResultSet rs = singletonConnection.st.executeQuery("select * from tab");
            while (rs.next()) {
                data[i][0] = rs.getLong(1);
                data[i][1] = rs.getLong(2);
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void show() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "  " + data[i][1]);
        }
    }
}
