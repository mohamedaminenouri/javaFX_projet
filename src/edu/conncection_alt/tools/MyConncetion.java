package edu.conncection_alt.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConncetion {
    private String url="jdbc:mysql://localhost:3306/espritalt";
    private String login="root";
    private String pwd="";
    Connection cnx;
    public Connection getCnx(){
        return this.cnx;
    }
    public MyConncetion() {

     try {
         cnx=   DriverManager.getConnection(url,login,pwd);
         System.out.println("Conncection established");
     }catch (SQLException e){
         System.out.println(e.getMessage());
     }


    }
}
