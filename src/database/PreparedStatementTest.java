package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {
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
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,"java");
            preparedStatement.setString(2,"java");
            preparedStatement.setString(3,"오정원");
            preparedStatement.setInt(4,22);
            preparedStatement.setString(5,"서울시");
            preparedStatement.setString(6,"java@java.com");

            int count = preparedStatement.executeUpdate();
            if(count > 0){
                System.out.println("insert success");
            }else{
                System.out.println("insert fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PreparedStatementTest preparedStatementTest = new PreparedStatementTest();
        preparedStatementTest.connect();
        preparedStatementTest.insert();
        preparedStatementTest.disconnect();
    }
}
