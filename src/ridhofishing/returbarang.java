/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridhofishing;
import method.control;
import entity.entitas;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import controller.koneksi;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author User
 */
public class returbarang extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs;
    Connection cn;
    private double total;
    private int row;
    PreparedStatement ps;
    String sql;
    int old, dec, now;
    private String tanggal;
    private Object tableModel;
  
    
private void kosongkan_form(){
        tanggalretur.setDateFormatString(null);
        txtidbarang.setSelectedItem(null);
        txtnamabarang.setText(null);
        txtharga.setText(null);
        txtjmlretur.setText(null);
        txttotretur.setText(null);
        txttotal.setText(null);
        
        
    }
    
    private void tampilkan_data(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("NO Retur");
        model.addColumn("Tanggal Retur");
         model.addColumn("Id Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah Retur");
        model.addColumn("Total");
        
        
        try{
            int no = 1;
            String sql = "SELECT * FROM retur";
            java.sql.Connection conn=(java.sql.Connection)koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{no++,rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7)});
            }
            tbretur.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    
      private void otomatis() {
        try {
            DateFormat vblnth = new SimpleDateFormat("yyyyMMdd");
            String blnth = vblnth.format(Calendar.getInstance().getTime());
            
            DateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
            
            String a = hari.format(Calendar.getInstance().getTime());
            
            String sql = " SELECT MAX(right(noretur,6)) AS noretur  "
                    + "FROM retur WHERE tanggalretur LIKE '" +a+ "'";
        
         java.sql.Connection con=(java.sql.Connection)koneksi.getConnection();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                if (rs.first() == false) {
                   
                    txtnoretur.setText("OUT/" + blnth+ "/" +"000001");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 6 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    
                    txtnoretur.setText("OUT/"+blnth+"/" + no);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
    }
      }
    /**
     * Creates new form returbarang
     */
    public returbarang() {
        initComponents();
        aktif(false);
        setTombol(true);
        isi_combobrg();
        isi_combobrg();
        open_db();
        otomatis();
        kosongkan_form();
        tampilkan_data();
        
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnoretur = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tanggalretur = new com.toedter.calendar.JDateChooser();
        Total = new javax.swing.JLabel();
        txtshowtotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JComboBox();
        txtnamabarang = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjmlretur = new javax.swing.JTextField();
        txttotretur = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbretur = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        txttgl1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttgl2 = new javax.swing.JTextField();
        cetak = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("No Retur");

        txtnoretur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoreturActionPerformed(evt);
            }
        });
        txtnoretur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnoreturKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tanggal");

        tanggalretur.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalreturPropertyChange(evt);
            }
        });

        Total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Total.setText("Total");

        txtshowtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnoretur)
                            .addComponent(tanggalretur, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addGap(319, 319, 319))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Total)
                        .addGap(28, 28, 28)))
                .addComponent(txtshowtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtshowtotal)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnoretur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tanggalretur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        jLabel1.setText("RETUR BARANG");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Truck_100px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Barang");

        txtidbarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Item" }));
        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });

        txtjmlretur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlreturActionPerformed(evt);
            }
        });

        txttotretur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotreturActionPerformed(evt);
            }
        });
        txttotretur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotreturKeyReleased(evt);
            }
        });

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Plus_15px.png"))); // NOI18N
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Erase_15px_1.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("*Klik Enter");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("*Klik Enter");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("*Klik 2x");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Jumlah");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(txtjmlretur, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttotretur, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(tambah)
                                .addGap(31, 31, 31)
                                .addComponent(hapus))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(333, 333, 333)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel4)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel7)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel8)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjmlretur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotretur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambah)
                    .addComponent(hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        tbretur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbretur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbreturMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbretur);

        jPanel5.setBackground(new java.awt.Color(255, 153, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Total");

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Save Close_16px.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Undo_15px.png"))); // NOI18N
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("S/D");

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Print_15px.png"))); // NOI18N
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("*masukan Tgl (yyyy-mm-dd)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txttgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kembali)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(simpan)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txttgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cetak))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
         if(tambah.getText().equalsIgnoreCase("tambah")){
            tambah.setText("delete");
            tambah.setEnabled(true);
            
        } else{
            tambah.setText("Tambah");
           
        }
        aktif(true);
    setTombol(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_barang","root","");
            java.sql.Statement stm = null;
            String sql = "DELETE FROM retur WHERE noretur='"+txtnoretur.getText()+"'";
            stm = cn.createStatement();
            int hapus = stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "proses hapus    data berhasil..");
            
            txtnoretur.setText("");
            tanggalretur.setDateFormatString("");
            txtidbarang.setSelectedItem("");
            txtnamabarang.setText("");
            txtharga.setText("");
            txtjmlretur.setText("");
            txttotretur.setText("");
            txtnoretur.requestFocus();
            
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(returbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
         String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tanggalretur.getDate()));
         try{
           
            //String xkd = cmbkdbrg.getSelectedItem().toString();
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_barang","root","");
            Statement stm = null;

             String sql = "INSERT INTO retur VALUES ('"+txtnoretur.getText()+
                    "','"+tanggal+
                    "','"+txtidbarang.getSelectedItem()+
                    "','"+txtnamabarang.getText()+
                     "','"+txtharga.getText()+
                    "','"+txtjmlretur.getText()+
                    "','"+txttotretur.getText()+"')";
            stm = (Statement) cn.createStatement();
            int simpan = stm.executeUpdate(sql);
            int t = tbretur.getRowCount();
             JOptionPane.showMessageDialog(null, "proses simpan data berhasil..");
            
            txtnoretur.setText("");
            tanggalretur.setDateFormatString("");
            txtidbarang.setSelectedItem("");
            txtnamabarang.setText("");
            txtharga.setText("");
            txtjmlretur.setText("");
            txttotretur.setText("");
            
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(returbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        // TODO add your handling code here:
           data_barang();
    }//GEN-LAST:event_txtidbarangActionPerformed

    private void txtjmlreturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlreturActionPerformed
        // TODO add your handling code here:
        double xtot,xhrg,xjml;
        xhrg=Double.parseDouble(txtharga.getText());
        xjml=Double.parseDouble(txtjmlretur.getText());
        xtot=xjml*xhrg;
        String xsubtotal=Double.toString(xtot);
        txttotretur.setText(xsubtotal);
    }//GEN-LAST:event_txtjmlreturActionPerformed

    private void txttotreturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotreturActionPerformed
        // TODO add your handling code here:
           hitung_jual(); 
    }//GEN-LAST:event_txttotreturActionPerformed

    private void txtnoreturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoreturActionPerformed
        // TODO add your handling code here:
         int no,x,y;
    x=00000000;
    y=1;
    no=x+y;
    String nojual=Integer.toString(no);
    txtnoretur.setText(nojual);
    }//GEN-LAST:event_txtnoreturActionPerformed

    private void txttotreturKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotreturKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10){
            txttotretur.requestFocus();}
    }//GEN-LAST:event_txttotreturKeyReleased

    private void tbreturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbreturMouseClicked
        // TODO add your handling code here:
         if (evt.getClickCount() ==1){int baris = tbretur.rowAtPoint(evt.getPoint());
        String no = tbretur.getValueAt(baris, 1).toString();
        txtnoretur.setText(no);
        
        String tgl = tbretur.getValueAt(baris, 2).toString();
        tanggalretur.setDate(null);

        String cb = tbretur.getValueAt(baris, 3).toString();
        txtidbarang.setSelectedItem(cb);

        String nm = tbretur.getValueAt(baris, 4).toString();
        txtnamabarang.setText(nm);

        String hg = tbretur.getValueAt(baris, 5).toString();
        txtharga.setText(hg);

        String jml = tbretur.getValueAt(baris, 6).toString();
        txtjmlretur.setText(jml);
        
        String to = tbretur.getValueAt(baris, 7).toString();
        txttotretur.setText(to);
        }
    }//GEN-LAST:event_tbreturMouseClicked

    private void txtnoreturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoreturKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() ==KeyEvent.VK_ENTER){
      try{
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql:"+"///stok_barang","root","");
        java.sql.Statement smt = cn.createStatement();
       ResultSet rs = smt.executeQuery("SELECT * FROM retur WHERE noretur="+"'"+txtnoretur.getText()+"'");
       if(rs.next()){
           tanggalretur.setDate(rs.getDate("tanggalretur"));
            txtidbarang.setSelectedItem(rs.getString("idbarang"));
            txtnamabarang.setText(rs.getString("namabarang"));
            txtharga.setText(rs.getString("harga"));
            txtjmlretur.setText(rs.getString("jumlahretur"));
            txttotal.setText(rs.getString("total"));
        }
      }     catch (SQLException ex) {      
                Logger.getLogger(returbarang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(returbarang.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
    }//GEN-LAST:event_txtnoreturKeyPressed

    private void tanggalreturPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalreturPropertyChange
        // TODO add your handling code here:
        try{
            if(tanggalretur.getDate() != null){
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                String date = String.valueOf(format.format(tanggalretur.getDate()));
            }
        }catch (Exception e){
            }
    }//GEN-LAST:event_tanggalreturPropertyChange

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        menu xx;
        xx = new menu();
        xx.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
         java.sql.Connection con = null;
        try {
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);

            String url = "jdbc:mysql://localhost:3306/stok_barang";
            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            java.sql.Statement stm = con.createStatement();

            try {

                String report = ("C:\\Users\\User\\Documents\\tirtaayu\\tirtaayu\\src\\laporan\\reportretur.jrxml");
                 HashMap hash = new HashMap();
                  java.util.Locale locale = new Locale ("id", "ID");
            hash.put(JRParameter.REPORT_LOCALE, locale);
                //Mengambil parameter dari ireport
                hash.put("day1", txttgl1.getText());
                hash.put("day2", txttgl2.getText());
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, con);
                JasperViewer.viewReport(JPrint, false);
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cetakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(returbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    private com.toedter.calendar.JDateChooser tanggalretur;
    private javax.swing.JTable tbretur;
    private javax.swing.JTextField txtharga;
    private javax.swing.JComboBox txtidbarang;
    private javax.swing.JTextField txtjmlretur;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnoretur;
    private javax.swing.JTextField txtshowtotal;
    private javax.swing.JTextField txttgl1;
    private javax.swing.JTextField txttgl2;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotretur;
    // End of variables declaration//GEN-END:variables
 private void aktif(boolean x) {
      txtidbarang.setEnabled(x);
      txtnamabarang.setEnabled(x);
      txtjmlretur.setEditable(x);
      txtharga.setEnabled(x);      
      txttotal.setEnabled(x);
    }

    private void setTombol(boolean t) {
    tambah.setEnabled(t);
    simpan.setEnabled(t); 
    hapus.setEnabled(t);
    }

    private void open_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_barang","root","");
            stm = (Statement) cn.createStatement();

        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi gagal");
            System.out.println(e.getMessage());
        }
    }

    

    private void hitung_jual() {
        double xtot,xhrg;
        int xjml;
        xhrg=Double.valueOf(txtharga.getText());
        xjml=Integer.valueOf(txtjmlretur.getText());
        xtot=xhrg*xjml;
        String xtotal=Double.toString(xtot);
        txttotretur.setText(xtotal);
        total=total+xtot;
        txttotal.setText(Double.toString(total));
        txtshowtotal.setText(Double.toString(total));    
    }

   

    private void isi_combobrg() {
        try{
        open_db();
        String sql = "Select * from barangmasuk";
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next())
        {
        txtidbarang.addItem(rs.getString(1)); 
        }
        } catch (Exception e){}
    }

    private void total_harga() {
       double tothrg = 0;
int jumrec = tbretur.getRowCount();
for (int i=0;i<jumrec;i++)
{
    TableModel tableModel = null;
tothrg = tothrg + Double.parseDouble(tableModel.getValueAt(i,4).toString()); }
txttotal.setText(String.valueOf(tothrg)); }
     
    private void data_barang() {
        try{
            stm =    (Statement) cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from barangmasuk where idbarang='"+ txtidbarang.getSelectedItem()+"'");
                rs.beforeFirst();
                while(rs.next())
            {
                txtnamabarang.setText(rs.getString(3).trim());
                txtharga.setText(Double.toString((Double)rs.getDouble(5)));
                txtjmlretur.requestFocus();
            }
                rs.close();
            }
        catch(SQLException e)
            {
                System.out.println("Error : "+e);
            }
    }
}
    
        

    
