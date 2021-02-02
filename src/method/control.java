/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import entity.entitas;
import entity.entitas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class control {
 Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;

    public control(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_barang","root","");
            st=con.createStatement();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        }
    }

    public List tampil(){
        List logBarang = new ArrayList();       
        sql="select no_jual from jual order by id_jual asc";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                control bc=new control();
                entitas eb=new entitas();
                eb.setNoJual(rs.getString("no_jual"));               
                logBarang.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logBarang;
    }

}