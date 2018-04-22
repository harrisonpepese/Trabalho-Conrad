/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author harrisonpepese
 */
public class Conect {
    
    public static java.sql.Connection GetConection() throws SQLException{
        Connection conn;
        try{
             Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println("Error: "+ e.getMessage());
        }
        String url = "localhost";
        String user = "root";
        String password = "password";
        String database = "motos";
        String query = "jdbc:mysql://"+url+"/"+database;
        try{
        conn=DriverManager.getConnection(query,user,password);
        return conn;
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
            return null;
        }
    }
    
}
