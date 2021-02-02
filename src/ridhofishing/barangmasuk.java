/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridhofishing;
import controller.koneksi;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;


/**
 *
 * @author User
 */
public class barangmasuk extends javax.swing.JFrame {

 public static int statussearching =0;
     private void kosongkan_form(){
        txtidbarang.setEditable(true);
        tglmasuk.setDateFormatString(null);
        txtnamabarang.setText(null);
        txtqty.setText(null);
        txthargagrosir.setText(null);
        txthargaeceran.setText(null);
        txtstatus.setSelectedItem(null);
    }
    
    private void tampilkan_data(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Id Barang");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Nama Barang");
        model.addColumn("QTY");
        model.addColumn("Harga Grosir");
        model.addColumn("Harga Eceran");
        model.addColumn("Satuan");
        try{
            int no = 1;
            String sql = "SELECT * FROM barangmasuk";
             java.sql.Connection conn=(Connection)koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getDate(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tbstok.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }

           
    public barangmasuk() {
        initComponents();
        tampilkan_data();
        kosongkan_form();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbstok = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        searching = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        search3 = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txthargaeceran = new javax.swing.JTextField();
        txthargagrosir = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tglmasuk = new com.toedter.calendar.JDateChooser();
        txtnamabarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cetak_laporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        jLabel2.setText("BARANG MASUK");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 480, 80));

        tbstok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbstok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbstokMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbstok);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 226, 622, 330));

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Plus_15px.png"))); // NOI18N
        tambah.setText("Tambah Data");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel2.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Save Close_16px.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel2.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, -1, -1));

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Edit_15px_1.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Erase_15px_1.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel2.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, -1, -1));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Delete_15px_1.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        jPanel2.add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, -1, -1));

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Exit_15px.png"))); // NOI18N
        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel2.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, -1, -1));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Undo_15px.png"))); // NOI18N
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        jPanel2.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, -1, -1));

        searching.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cari");

        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });

        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Search_15px.png"))); // NOI18N
        cari.setText("Search");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchingLayout = new javax.swing.GroupLayout(searching);
        searching.setLayout(searchingLayout);
        searchingLayout.setHorizontalGroup(
            searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cari)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        searchingLayout.setVerticalGroup(
            searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(search3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(searching, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Satuan");

        txtstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Item", "KG", "PCS", "BAL", "KARTON", "DUS ", "LUSIN" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("ID Barang");

        txtidbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidbarangKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nama Barang");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("QTY");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Harga Grosir");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Harga Eceran");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Tanggal Masuk");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthargagrosir, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthargaeceran, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtidbarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthargagrosir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txthargaeceran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 226, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Save as_100px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 120));

        cetak_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ridhofishing/icon/Print_15px.png"))); // NOI18N
        cetak_laporan.setText("Print");
        cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak_laporanActionPerformed(evt);
            }
        });
        jPanel2.add(cetak_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbstokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbstokMouseClicked
        // TODO add your handling code here:
        int baris = tbstok.rowAtPoint(evt.getPoint());
        String nik = tbstok.getValueAt(baris, 1).toString();
        txtidbarang.setText(nik);
        
        String tgl = tbstok.getValueAt(baris, 2).toString();
        tglmasuk.setDate(null);

        String nb = tbstok.getValueAt(baris, 3).toString();
        txtnamabarang.setText(nb);

        String jml = tbstok.getValueAt(baris, 4).toString();
        txtqty.setText(jml);

        String hg = tbstok.getValueAt(baris, 5).toString();
        txthargagrosir.setText(hg);

        String he = tbstok.getValueAt(baris, 6).toString();
        txthargaeceran.setText(he);

        String sts = tbstok.getValueAt(baris, 7).toString();
        txtstatus.setSelectedItem(sts);
    }//GEN-LAST:event_tbstokMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_tambahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tglmasuk.getDate()));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql:"+"///stok_barang","root","");
            Statement smt = null;
            
            String sql = "INSERT INTO barangmasuk VALUES ('"+txtidbarang.getText()+
                    "','"+tanggal+
                    "','"+txtnamabarang.getText()+
                    "','"+txtqty.getText()+
                    "','"+txthargagrosir.getText()+
                    "','"+txthargaeceran.getText()+
                    "','"+txtstatus.getSelectedItem()+"')";
            smt = cn.createStatement();
            int simpan = smt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "proses simpan data berhasil..");
            
            txtidbarang.setText("");
            tglmasuk.setDateFormatString("");
            txtnamabarang.setText("");
            txtqty.setText("");
            txthargagrosir.setText("");
            txthargaeceran.setText("");
            txtstatus.setSelectedItem("");
            txtidbarang.requestFocus();
            
            
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
         String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgl = String.valueOf(fm.format(tglmasuk.getDate()));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql:"+"///stok_barang","root","");
            Statement smt = null;
            
          String sql =  "UPDATE barangmasuk SET idbarang ='"+txtidbarang.getText()+"',tanggalmasuk='"+tgl+"',namabarang='"+txtnamabarang.getText()+
                    "',qty='"+txtqty.getText()+
                    "',hargagrosir='"+txthargagrosir.getText()+
                    "',hargaeceran='"+txthargaeceran.getText()+
                    "',satuan='"+txtstatus.getSelectedItem()+"' WHERE idbarang='"+txtidbarang.getText()+"'";
            smt = cn.createStatement();
            int edit = smt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "proses edit data berhasil..");
            
            txtidbarang.setText("");
            tglmasuk.setDateFormatString("");
            txtnamabarang.setText("");
            txtqty.setText("");
            txthargagrosir.setText("");
            txthargaeceran.setText("");
            txtstatus.setSelectedItem("");
            txtidbarang.requestFocus();
            
            
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql:"+"///stok_barang","root","");
            Statement smt = null;
            String sql = "DELETE FROM barangmasuk WHERE idbarang='"+txtidbarang.getText()+"'";
            smt = cn.createStatement();
            int hapus = smt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "proses hapus    data berhasil..");
            
            txtidbarang.setText("");
            tglmasuk.setDateFormatString("");
            txtnamabarang.setText("");
            txtqty.setText("");
            txthargagrosir.setText("");
            txthargaeceran.setText("");
            txtstatus.setSelectedItem("");
            txtidbarang.requestFocus();
            
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_batalActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        statussearching=1;
        if(search3.getText().isEmpty())
        {statussearching= 0;}
        else if (statussearching==1){
            DefaultTableModel tabelmsk = new DefaultTableModel();
            tabelmsk.addColumn("ID Barang");
            tabelmsk.addColumn("Tanggal Masuk");
            tabelmsk.addColumn("Nama Barang");
            tabelmsk.addColumn("QTY");
            tabelmsk.addColumn("Harga Grosir");
            tabelmsk.addColumn("Harga Eceran");
            tabelmsk.addColumn("Status");
            String cari = search3.getText();

            try{
                 String sql = "SELECT * FROM barangmasuk WHERE idbarang LIKE '"+cari+"'"
                    +" OR tanggalmasuk LIKE '"+cari+ "' OR namabarang LIKE '"+cari+"' OR qty LIKE '"+cari+"'"
                    +"OR hargagrosir LIKE '"+cari+"' OR hargaeceran LIKE '"+cari+"'"
                    +"OR satuan LIKE '"+cari+"' ORDER BY idbarang"; 
                java.sql.Connection conn=(Connection)koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                while(res.next()){
                    tabelmsk.addRow(new Object[]{
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6),
                        res.getString(7)
                    });
                }
                tbstok.setModel(tabelmsk);
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "maaf data yang dicari tidak ada");

            }

        }
    }//GEN-LAST:event_cariActionPerformed

    private void txtidbarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidbarangKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() ==KeyEvent.VK_ENTER){
      try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn = DriverManager.getConnection("jdbc:mysql:"+"///stok_barang","root","");
        Statement smt = cn.createStatement();
       ResultSet rs = smt.executeQuery("SELECT * FROM barangmasuk WHERE idbarang="+"'"+txtidbarang.getText()+"'");
       if(rs.next()){
           tglmasuk.setDate(rs.getDate("tanggalmasuk"));
            txtnamabarang.setText(rs.getString("namabarang"));
            txtqty.setText(rs.getString("qty"));
            txthargagrosir.setText(rs.getString("hargagrosir"));
            txthargaeceran.setText(rs.getString("hargaeceran"));
            txtstatus.setSelectedItem(rs.getString("satuan"));
            
       }
      }     catch (SQLException ex) {      
                Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
    }//GEN-LAST:event_txtidbarangKeyPressed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
         menu xx;
        xx = new menu();
        xx.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search3ActionPerformed

    private void cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetak_laporanActionPerformed
        // TODO add your handling code here:
     try {
            HashMap data = new HashMap();
            java.util.Locale locale = new Locale ("id", "ID");
            data.put(JRParameter.REPORT_LOCALE, locale);
            String buatlaporan=("C:\\Users\\User\\Documents\\tirtaayu\\tirtaayu\\src\\laporan\\reportbarangmasuk.jasper");
            JasperPrint jp = JasperFillManager.fillReport(buatlaporan, data, koneksi.getConnection());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("laporan barang");
            jv.setVisible(true);
     }catch (Exception e){
         javax.swing.JOptionPane.showMessageDialog(rootPane, "gagal menampilkan laporan");
     }
    }//GEN-LAST:event_cetak_laporanActionPerformed

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
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangmasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JButton cari;
    private javax.swing.JButton cetak_laporan;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField search3;
    private javax.swing.JPanel searching;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tbstok;
    private com.toedter.calendar.JDateChooser tglmasuk;
    private javax.swing.JTextField txthargaeceran;
    private javax.swing.JTextField txthargagrosir;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtqty;
    private javax.swing.JComboBox txtstatus;
    // End of variables declaration//GEN-END:variables
}
