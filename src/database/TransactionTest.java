package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
    Connection con;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void disconnect(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/learnjava?serverTimezone=UTC","rakun","mknj2233");
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insert(){
        connect();
        Statement stmt = null;
        boolean isOrderSuccess = false;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO pay VALUES('aaa','001','1000')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO orderList VALUES('001')";
            stmt.executeUpdate(sql);
            isOrderSuccess=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(isOrderSuccess){
                try {
                    con.commit();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                try {
                    con.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            disconnect();
        }
    }

    public static void main(String[] args) {
        TransactionTest tt = new TransactionTest();
        tt.insert();
    }
}
