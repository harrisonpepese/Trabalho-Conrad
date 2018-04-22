/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class modelo {
    String modelo;
    String tipo;
    int cilindrada;
    double V_custo;
    double V_venda;
    String S_chassi;
    
    public static List GetAll() throws SQLException{
        List <modelo> array = new ArrayList<modelo>();
        String query="SELECT `modelo`, `tipo`, `cilindrada`, `v_custo`, `v_venda`, `s_chassi` FROM `modelo`";
        Connection conn=Conect.GetConection();
        Statement stt= conn.createStatement();
        ResultSet rts=stt.executeQuery(query);
        while(rts.next()){
            modelo iten =new modelo();
            iten.modelo=rts.getString(1);
            iten.tipo=rts.getString(2);
            iten.cilindrada=rts.getInt(3);
            iten.V_custo=rts.getDouble(4);
            iten.V_venda=rts.getDouble(5);
            iten.S_chassi=rts.getString(6);
            array.add(iten);
        }
        rts.close();
        stt.close();
        conn.close();
        return array;
    }
    public static List Getmodel() throws SQLException{
        List <String> array = new ArrayList<String>();
        String query="SELECT `modelo` FROM `modelo`";
        Connection conn=Conect.GetConection();
        Statement stt= conn.createStatement();
        ResultSet rts=stt.executeQuery(query);
        while(rts.next()){
            String iten =rts.getString(1);
            array.add(iten);
        }
        rts.close();
        stt.close();
        conn.close();
        return array;
    }
    public void Insert() throws SQLException{
        String query="INSERT INTO `modelo`(`modelo`, `tipo`, `cilindrada`, `v_custo`, `v_venda`, `s_chassi`) VALUES (?,?,?,?,?,?)";
        try{
        Connection conn=Conect.GetConection();
        PreparedStatement stt= conn.prepareStatement(query);
        stt.setString(1, modelo);
        stt.setString(2, tipo);
        stt.setInt(3, cilindrada);
        stt.setDouble(4,V_custo);
        stt.setDouble(5,V_venda);
        stt.setString(6,S_chassi);
        stt.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null,"INSERIDO COM SUCESSO");
        stt.close();
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex);
            javax.swing.JOptionPane.showMessageDialog(null,"Erro");
        }
    }   
    
}
