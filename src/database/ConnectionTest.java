package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    Connection con;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/learnjava?serverTimezone=UTC","rakun","mknj2233");
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConnectionTest ct = new ConnectionTest();
        ct.connect();
    }
}
