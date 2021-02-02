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
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
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
public class kasir extends javax.swing.JFrame {
    
    Statement stm;
    ResultSet rs;
    Connection cn;
    private double total;
    private int row;
    PreparedStatement ps;
    String sql;
    private String tanggal;
    int x=0;
        private DefaultTableModel model;
        control bc=new control();
        entitas eb=new entitas();
        List <entitas> listBarang=new ArrayList<entitas>();
    

    DefaultTableModel tableModel = new DefaultTableModel(
    new Object [ ][ ] {},
    new String [ ] {
     "Kd Barang", "Nama Barang","Harga Barang","Jumlah","Total"
    });
 
    
    
  
   
    private void kosongkan_form(){
        format_tanggal();
        cmbkdbrg.setSelectedItem(null);
        txtcustomer.setText(null);
        txtnm_brg.setText(null);
        txtharga.setText(null);
        txtjumlah.setText(null);
        txttot.setText(null);
        txttotal.setText(null);
        txtbayar.setText(null);
        txtkembali.setText(null);
        
    }
    
private DefaultTableModel Model;
   
    public kasir() {
              initComponents();
        aktif(false);
        setTombol(true);
        isi_combobrg();
        isi_combobrg();
        open_db();
        otomatis();
        kosongkan_form();
    
        inisialisasi_tabel();
         setLocationRelativeTo(this);
        txttanggal.setEditor(new JSpinner.DateEditor(txttanggal,"yyyy/MM/dd"));
        
        Model=new DefaultTableModel();
        tbljual.setModel(Model);
        
        Model.addColumn("No.");
        Model.addColumn("Id Jual");
        Model.addColumn("No Transaksi");
        Model.addColumn("Kode Barang");
        Model.addColumn("Harga");
        Model.addColumn("Jumlah");
        
        AmbilDataBarang();
    }

    public void AmbilDataBarang() {
        //Menghapus Seluruh Data
        Model.getDataVector().removeAllElements();
        //Memberitahu bahwa data kosong
        Model.fireTableDataChanged();

        try{
            int no = 1;
            String sql = "SELECT * FROM djual";
            java.sql.Connection con;
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Model.addRow(new Object[]{no++,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            tbljual.setModel(Model);
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
            
            String sql = " SELECT MAX(right(no_jual,6)) AS no_jual  "
                    + "FROM jual WHERE tgl_jual LIKE '" +a+ "'";
        
         java.sql.Connection con;
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                if (rs.first() == false) {
                   
                    txtnojual.setText("RF/" + blnth+ "/" +"01");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 6 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    
                    txtnojual.setText("RF/"+blnth+"/" + no);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
    }
      }
      
  
    

    
      
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnojual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtshowharga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcustomer = new javax.swing.JTextField();
        bttambah = new javax.swing.JButton();
        txttanggal = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        Total = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembali = new javax.swing.JTextField();
        cetak = new javax.swing.JButton();
        txtcetak = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbljual = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltampil = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbkdbrg = new javax.swing.JComboBox();
        txtnm_brg = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txttot = new javax.swing.JTextField();
        bthapusitem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btsimpan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        jLabel1.setText("TRANSAKSI PENJUALAN");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Shopping Cart Loaded_100px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("No Jual");

        txtnojual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnojualActionPerformed(evt);
            }
        });
        txtnojual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnojualKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total");

        txtshowharga.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtshowharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtshowhargaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tanggal");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Customer");

        bttambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Plus_15px.png"))); // NOI18N
        bttambah.setText("Tambah Data");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        txttanggal.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtnojual, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttambah)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4))
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(txtshowharga, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtshowharga, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnojual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(txtcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttambah))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Total.setText("Total");
        jPanel4.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Bayar");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Kembalian");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, -1, -1));

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        txttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalKeyReleased(evt);
            }
        });
        jPanel4.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 182, -1));

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        txtbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbayarKeyReleased(evt);
            }
        });
        jPanel4.add(txtbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 180, -1));
        jPanel4.add(txtkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 180, -1));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Print_15px.png"))); // NOI18N
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        jPanel4.add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        jPanel4.add(txtcetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("*Masukan No Transaksi");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        tbljual.setModel(new javax.swing.table.DefaultTableModel(
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
        tbljual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbljualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbljual);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1300, 100));

        tbltampil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbltampil);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1300, 110));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Data Transaksi");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Gender Neutral User_40px.png"))); // NOI18N
        jButton3.setText("MENU LOGIN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 160, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Barang");

        cmbkdbrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Item" }));
        cmbkdbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkdbrgActionPerformed(evt);
            }
        });

        txtnm_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnm_brgActionPerformed(evt);
            }
        });

        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });

        txttot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotActionPerformed(evt);
            }
        });
        txttot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotKeyReleased(evt);
            }
        });

        bthapusitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Erase_15px_1.png"))); // NOI18N
        bthapusitem.setText("Hapus");
        bthapusitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusitemActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Jumlah");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("*tekan enter");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("*tekan enter");

        btsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Save Close_16px.png"))); // NOI18N
        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Plus_15px.png"))); // NOI18N
        jButton2.setText("Add To Table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Database Transaksi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cmbkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txttot, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton2)
                                .addGap(50, 50, 50)
                                .addComponent(btsimpan)
                                .addGap(49, 49, 49)
                                .addComponent(bthapusitem))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(369, 369, 369)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bthapusitem)
                            .addComponent(txttot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btsimpan)
                            .addComponent(jButton2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
        // TODO add your handling code here:
        if(bttambah.getText().equalsIgnoreCase("tambah")){
            bttambah.setText("delete");
            bttambah.setEnabled(true);
            
        } else{
            bttambah.setText("Tambah");
           
        }
        aktif(true);
    setTombol(true);
    }//GEN-LAST:event_bttambahActionPerformed

    private void cmbkdbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkdbrgActionPerformed
        // TODO add your handling code here:
        data_barang();
    }//GEN-LAST:event_cmbkdbrgActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        // TODO add your handling code here:
        
         try{
            open_db();
            int xidjual = 0;
            String xnojual=txtnojual.getText();
            format_tanggal();  
            String xtotal=txttot.getText();
            String xbayar=txtbayar.getText();
            String xkembalian=txtkembali.getText();
            //String xkd = cmbkdbrg.getSelectedItem().toString();

            String msql="insert into jual values('"+xidjual+"','"+xnojual+"','"+tanggal+"','"+xtotal+"','"+xbayar+"','"+xkembalian+"')";
            stm.executeUpdate(msql);

            int t = tbltampil.getRowCount();
            for(int i=0; i < t ; i++)
            {
                int xiddjual = 0;
                String xkd  = tbltampil.getValueAt(i,0).toString();
                String xhrg = tbltampil.getValueAt(i,2).toString();
                String xjml = tbltampil.getValueAt(i,3).toString();
              
                String zsql="insert into djual values('"+xiddjual+"','"+xnojual+"','"+xkd+"','"+xhrg+"','"+xjml+"')";
                stm.executeUpdate(zsql);
            }
            //Con.close();
            JOptionPane.showMessageDialog(null,"Transaksi tersimpan sukses");
            setTombol(false);
            txtnojual.setText("");
            txtnm_brg.setText("");
            txtharga.setText("0");
            txtjumlah.setText("0");
            txttot.setText("0");
            txttotal.setText("0");
            txtbayar.setText("0");
            txtkembali.setText("0");
            txtshowharga.setText("0");
            tbltampil.clearSelection();
            tableModel.removeRow(row);
        }
        catch(SQLException e)
        {
            System.out.println("Error : "+e);
            JOptionPane.showMessageDialog(null,"Transaksi gagal tersimpan");
            setTombol(false);
            txtnojual.setText("");
            txtnm_brg.setText("");
            txtharga.setText("0");
            txtjumlah.setText("0");
            txttot.setText("0");
            txttotal.setText("0");
            txtbayar.setText("0");
            txtkembali.setText("0");
            txtshowharga.setText("0");
            tbltampil.clearSelection();
            tableModel.removeRow(row);
        }
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bthapusitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusitemActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_barang","root","");
            java.sql.Statement stm = null;
            String sql = "DELETE FROM penjualan WHERE notransaksi='"+txtnojual.getText()+"'";
            stm = cn.createStatement();
            int hapus = stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "proses hapus    data berhasil..");
            
            txtnojual.setText("");
          format_tanggal();
            cmbkdbrg.setSelectedItem("");
            txtcustomer.setText("");
            txtnm_brg.setText("");
            txtharga.setText("");
            txtjumlah.setText("");
            txttot.setText("");
            txtnojual.requestFocus();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bthapusitemActionPerformed

    private void txtshowhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtshowhargaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtshowhargaActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
         double xtot,xhrg,xjml;
    xhrg=Double.valueOf(txttotal.getText());
    xjml=Double.valueOf(txtbayar.getText());
    xtot=xjml-xhrg;
    String xtotal=Double.toString(xtot);
    txtkembali.setText(xtotal);   
    }//GEN-LAST:event_txtbayarActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
         
    
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        // TODO add your handling code here:
        double xtot,xhrg,xjml;
        xhrg=Double.valueOf(txtharga.getText());
        xjml=Double.valueOf(txtjumlah.getText());
        xtot=xjml*xhrg;
        String xsubtotal=Double.toString(xtot);
        txttot.setText(xsubtotal);
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void txttotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotActionPerformed
        // TODO add your handling code here:
        hitung_jual(); 
    }//GEN-LAST:event_txttotActionPerformed

    private void txttotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10){
     txtbayar.requestFocus();}
    }//GEN-LAST:event_txttotalKeyReleased

    private void txtbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbayarKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10){
     txtkembali.requestFocus();}
    }//GEN-LAST:event_txtbayarKeyReleased

    private void txtnojualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnojualActionPerformed
        // TODO add your handling code here:
    int no,x,y;
    x=00000000;
    y=1;
    no=x+y;
    String nojual=Integer.toString(no);
    txtnojual.setText(nojual);
    }//GEN-LAST:event_txtnojualActionPerformed

    private void txttotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10){
            txttot.requestFocus();}
    }//GEN-LAST:event_txttotKeyReleased

    private void tbljualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbljualMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() ==1){int baris = tbljual.rowAtPoint(evt.getPoint());
        String no = tbljual.getValueAt(baris, 1).toString();
        txtnojual.setText(no);
        
        format_tanggal();

        String cb = tbljual.getValueAt(baris, 3).toString();
        cmbkdbrg.setSelectedItem(cb);

        String cs = tbljual.getValueAt(baris, 4).toString();
        txtcustomer.setText(cs);

        String nm = tbljual.getValueAt(baris, 5).toString();
        txtnm_brg.setText(nm);

        String hg = tbljual.getValueAt(baris, 6).toString();
        txtharga.setText(hg);

        String jml = tbljual.getValueAt(baris, 7).toString();
        txtjumlah.setText(jml);
        
        String to = tbljual.getValueAt(baris, 7).toString();
        txttot.setText(to);
        }
        
    }//GEN-LAST:event_tbljualMouseClicked

    private void txtnm_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnm_brgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnm_brgActionPerformed

    private void txtnojualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnojualKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() ==KeyEvent.VK_ENTER){
      try{
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql:"+"///stok_barang","root","");
        java.sql.Statement smt = cn.createStatement();
       ResultSet rs = smt.executeQuery("SELECT * FROM penjualan WHERE notransaksi="+"'"+txtnojual.getText()+"'");
       if(rs.next()){
           format_tanggal();
            cmbkdbrg.setSelectedItem(rs.getString("kdbarang"));
            txtcustomer.setText(rs.getString("customer"));
            txtnm_brg.setText(rs.getString("namabarang"));
            txtharga.setText(rs.getString("harga"));
            txtjumlah.setText(rs.getString("jumlahbeli"));
            txttotal.setText(rs.getString("total"));
            
       }
      }     catch (SQLException ex) {      
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
    }//GEN-LAST:event_txtnojualKeyPressed

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

                String report = ("C:\\Users\\User\\Documents\\tirtaayu\\tirtaayu\\src\\laporan\\penjualan.jrxml");
                 HashMap hash = new HashMap();
                  java.util.Locale locale = new Locale ("id", "ID");
            hash.put(JRParameter.REPORT_LOCALE, locale);
                //Mengambil parameter dari ireport
                hash.put("kode", txtcetak.getText());
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         simpan_ditabel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        login xx;
        xx = new login();
        xx.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JButton bthapusitem;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cetak;
    private javax.swing.JComboBox cmbkdbrg;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbljual;
    private javax.swing.JTable tbltampil;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtcetak;
    private javax.swing.JTextField txtcustomer;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtnm_brg;
    private javax.swing.JTextField txtnojual;
    private javax.swing.JTextField txtshowharga;
    private javax.swing.JSpinner txttanggal;
    private javax.swing.JTextField txttot;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

   

    private void aktif(boolean x) {
      cmbkdbrg.setEnabled(x);
      txtnm_brg.setEnabled(x);
      txtjumlah.setEditable(x);
      txtharga.setEnabled(x);      
      txttotal.setEnabled(x);
    }

    private void setTombol(boolean t) {
    bttambah.setEnabled(t);
     btsimpan.setEnabled(t); 
     bthapusitem.setEnabled(t);
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

    
   private void inisialisasi_tabel() {
        tbltampil.setModel(tableModel);
    }
    private void hitung_jual() {
        double xtot,xhrg;
        int xjml;
        xhrg=Double.parseDouble(txtharga.getText());
        xjml=Integer.parseInt(txtjumlah.getText());
        xtot=xhrg*xjml;
        String xtotal=Double.toString(xtot);
        txttot.setText(xtotal);
        total=total+xtot;
        txttotal.setText(Double.toString(total));
        txtshowharga.setText(Double.toString(total));    
    }

   private void simpan_ditabel() {
        try{
String tKode=cmbkdbrg.getSelectedItem().toString();
String tNama=txtnm_brg.getText();
double hrg=Double.parseDouble(txtharga.getText());
int jml=Integer.parseInt(txtjumlah.getText());
double tot=Double.parseDouble(txttot.getText());
tableModel.addRow(new Object[]{tKode,tNama,hrg,jml,tot});
inisialisasi_tabel();
}
   catch(Exception e)
{
System.out.println("Error : "+e);
}

        
    }
   

    private void isi_combobrg() {
        try{
        open_db();
        String sql = "Select * from barangmasuk";
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next())
        {
        cmbkdbrg.addItem(rs.getString(1)); 
        }
        } catch (Exception e){}
    }

    private void total_harga() {
       double tothrg = 0;
int jumrec = tbljual.getRowCount();
for (int i=0;i<jumrec;i++)
{
    TableModel tableModel = null;
tothrg = tothrg + Double.parseDouble(tableModel.getValueAt(i,4).toString()); }
txttotal.setText(String.valueOf(tothrg)); }
     
    private void data_barang() {
        try{
            stm =    (Statement) cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from barangmasuk where idbarang='"+ cmbkdbrg.getSelectedItem()+"'");
                rs.beforeFirst();
                while(rs.next())
            {
                txtnm_brg.setText(rs.getString(3).trim());
                txtharga.setText(Double.toString((Double)rs.getDouble(6)));
                txtjumlah.requestFocus();
            }
                rs.close();
            }
        catch(SQLException e)
            {
                System.out.println("Error : "+e);
            }
    }
     private void format_tanggal() {
       String DATE_FORMAT = "yyyy-MM-dd";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int year=c1.get(Calendar.YEAR);
        int month=c1.get(Calendar.MONTH)+1;
        int day=c1.get(Calendar.DAY_OF_MONTH);
        tanggal=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
    }
}
    
        

    

