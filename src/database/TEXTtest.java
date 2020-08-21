package database;

import java.sql.*;

public class TEXTtest {
    Connection con;
    StringBuffer sb = null;
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
        }
    }


    public void insert(){
        String sql = "INSERT INTO texttest (num,content) VALUES (1,?)";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connect();
            sb = new StringBuffer();
            for(int i=0; i<1000; i++){
                sb.append("text");
            }

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,sb.toString());
            if(preparedStatement.executeUpdate() > 0){
                System.out.println("insert success");
            }else{
                System.out.println("insert fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void select(){
        String sql = "SELECT * FROM texttest";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connect();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("번호:"+rs.getString(1)+",내용:"+rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
         TEXTtest texTtest = new TEXTtest();
         texTtest.insert();
         texTtest.select();
    }
}
