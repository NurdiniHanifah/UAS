/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelTeman;
import util.Koneksi;

/**
 *
 * @author DELL
 */
public class ControllerTeman {
    Koneksi koneksi=new Koneksi();
     public void simpanData(ModelTeman mt){
         koneksi.koneksiDatabase();
         String query = "insert into tbl_teman(nama,nope,email) values ('"+mt.getNama()+"','"+mt.getNope()+"','"+mt.getEmail()+"')";
         try {
             koneksi.state.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
             System.err.println(""+e);
         }
     }
     public void hapusData(ModelTeman mt){
         try {
             koneksi.koneksiDatabase();
             String query = "delete from tbl_peminjaman where id=('"+mt.getId()+"')";
             koneksi.state.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
         } catch (SQLException e) {
             System.err.println("Error : "+e);
             JOptionPane.showMessageDialog(null, "Data tidak terhapus");
         }
        
         }
     public void ubahData(ModelTeman mt){
         try {
            int id = mt.getId();
            String nama = mt.getNama();
            String nope = mt.getNope();
            String email = mt.getEmail();

            String query = "update tbl_teman "
                    + "set namaTeman=('" + nama + "'),"
                    + "nope=('"+ nope +"')"
                    + "email=('"+email+"')"
                    + "where id=('" + id + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data tidak terubah");
     }
     }
}
