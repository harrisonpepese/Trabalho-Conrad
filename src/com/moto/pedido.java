/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harrisonpepese
 */
public class pedido {
    String modelo;
    String cor;
    int quantidade;
    double custo;
    double lucro;
    String chassi0;
    String chassi1;   
    
public void Insert() throws SQLException{
        String query="INSERT INTO `pedido`(`modelo`, `cor`, `quantidade`, `custo_producao`, `lucro`, `chassi1`, `chassi2`) VALUES (?,?,?,?,?,?,?)";
        try{
        Connection conn=Conect.GetConection();
        PreparedStatement stt= conn.prepareStatement(query);
        stt.setString(1, modelo);
        stt.setString(2, cor);
        stt.setInt(3, quantidade);
        stt.setDouble(4,custo);
        stt.setDouble(5,lucro);
        stt.setString(6,chassi0);
        stt.setString(7,chassi1);
        stt.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null,"Sucesso");
        stt.close();
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex);
            javax.swing.JOptionPane.showMessageDialog(null,"Erro");
        }
    }  
} 