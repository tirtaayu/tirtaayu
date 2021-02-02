/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author User
 */
public class entitas {
    public String no_jual, id, tgl_jual, total, bayar, kembalian;


   
    public String getNojual() {
        return no_jual;
    }

    public String getId() {
        return id;
        
        
    }public String getTglJual() {
        return tgl_jual;
    }
    
    public String getTotal() {
        return total;
    }
    public String getBayar() {
        return bayar;
    }
    public String getKembalian() {
        return kembalian;
    }
    
    public void setNoJual(String no_jual) {
        this.no_jual = no_jual;
    }

    public void setId(String id) {
        this.id = id;
    }
   
    public void setTglJual(String tgl_jual) {
        this.tgl_jual = tgl_jual;
    }
    
    public void setTotal(String total) {
        this.total = total;
    }
    
    public void setBayar(String bayar) {
        this.bayar = bayar;
    }
    
    public void setKembalian(String kembalian) {
        this.kembalian = kembalian;
    } 

    

   

}
