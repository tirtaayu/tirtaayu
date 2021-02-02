/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLDataException;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */

public class koneksi {
   
    public static Connection getConnection(){
    
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stok_barang";
        String user = "root";
        String password = "";
        if(connection ==null){
            try{
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                
            }catch (ClassNotFoundException | SQLException error){
                System.exit(0);
            }
        }
        return connection;
    }

}