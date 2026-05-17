/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelDetailTransaksi;
import model.ModelTransaksi;
import model.ModelProduk;
import service.ServiceDetailTransaksi;

/**
 *
 * @author fuadm
 */
public class DAODetailTransaksi implements ServiceDetailTransaksi {

    private static Connection conn;

    public DAODetailTransaksi() {
        conn = DataBase.getConn();

    }

    @Override
    public void sumTotal(ModelDetailTransaksi motdet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addData(ModelDetailTransaksi motdet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void UpdateData(ModelDetailTransaksi motdet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DeleteData(ModelDetailTransaksi motdet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelDetailTransaksi getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelDetailTransaksi> getData(String id) {
        List<ModelDetailTransaksi> detailTransaksis = new ArrayList<>();

        String sql = 
        "SELECT dt.id, dt.id_transaksi, dt.id_menu, mp.nama_menu, mp.harga, dt.jumlah, dt.subtotal "
        + "FROM detail_transaksi dt "
        + "INNER JOIN menu_produk mp "
        + "ON dt.id_menu = mp.id "
        + "INNER JOIN transaksi t "
        + "ON dt.id_transaksi = t.id "
        + "WHERE dt.id_transaksi ='"+id+"' ORDER BY dt.id_transaksi ASC";
        ;

        try (
                PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                ModelDetailTransaksi detailTransaksi = new ModelDetailTransaksi();
                ModelProduk produk = new ModelProduk();
                ModelTransaksi transaksi = new ModelTransaksi();

                detailTransaksi.setId(rs.getString("id"));
                transaksi.setId(rs.getString("id_transaksi"));
                produk.setId(rs.getString("id_menu"));
                produk.setNamaMenu(rs.getString("mp.nama_menu"));
                produk.setHarga(rs.getLong("mp.harga"));
                detailTransaksi.setJumlah(rs.getInt("jumlah"));
                detailTransaksi.setSubtotal(rs.getLong("subtotal"));
                
                detailTransaksi.setIdTransaksi(transaksi);
                detailTransaksi.setIdProduk(produk);

                detailTransaksis.add(detailTransaksi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailTransaksis;
    }

    @Override
    public List<ModelDetailTransaksi> getData2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelDetailTransaksi> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
