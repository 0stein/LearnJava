package database;

import java.sql.*;

public class CRUDTest {
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

    public void insert(String sql){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            if(count > 0){
                System.out.println("insert success!");
            }else{
                System.out.println("insert fail");
            }
        } catch (SQLException throwables) {
            System.out.println("insert fail");
            throwables.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public void select(String sql){
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println("아이디 : "+rs.getString(1)+",비밀번호:"+rs.getString("password")+
                        ",이름:"+rs.getString("name")+",나이"+rs.getInt("age")+",주소:"+
                        rs.getString("addr")+",이메일:"+rs.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void update(String sql){
        Statement statement = null;
        try {
            statement = con.createStatement();
            int count = statement.executeUpdate(sql);
            if(count > 0){
                System.out.println("update success");
            }else {
                System.out.println("update fial");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void delete(String sql){
        Statement statement = null;
        try {
            statement = con.createStatement();
            int count = statement.executeUpdate(sql);
            if(count > 0){
                System.out.println("delete success!");
            }else{
                System.out.println("delete fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CRUDTest crudTest = new CRUDTest();
        String insertQ = "INSERT INTO member VALUES('aaa','111','유비','22','서울시','a@a.com'";
        String selectQ = "SELECT * FROM member";
        String updateQ = "UPDATE member SET addr='춘천시' WHERE id='aaa'";
        String deleteQ = "DELETE FROM member WHERE password='111'";
        crudTest.connect();

        crudTest.insert(insertQ);
        crudTest.update(updateQ);
        crudTest.select(selectQ);
        crudTest.delete(deleteQ);
        crudTest.select(selectQ);

        crudTest.disconnect();
    }
}
