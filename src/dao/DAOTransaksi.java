/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DataBase;
import java.util.List;
import model.ModelTransaksi;
import model.ModelLogin;
import model.ModelPelanggan;
import model.ModelTransaksi;
import service.ServiceTransaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fuadm
 */
/**
 *
 * @author fuadm
 */
public class DAOTransaksi implements ServiceTransaksi {

    private static Connection conn;

    public DAOTransaksi() {
        conn = DataBase.getConn();

    }

    @Override
    public void addData(ModelTransaksi motran) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void UpdateData(ModelTransaksi motran) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DeleteData(ModelTransaksi motran) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelTransaksi getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelTransaksi> getData() {
        List<ModelTransaksi> transaksis = new ArrayList<>();

        String sql = """
        SELECT id, id_kasir, id_pelanggan, tanggal, total_harga, bayar, kembalian
        FROM transaksi
        """;

        try (
                PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                ModelTransaksi transaksi = new ModelTransaksi();
                ModelLogin user = new ModelLogin();
                ModelPelanggan pelanggan = new ModelPelanggan();

                transaksi.setId(rs.getString("id"));
                user.setId(rs.getString("id_kasir"));
                pelanggan.setId(rs.getString("id_pelanggan"));
                transaksi.setTanggal(rs.getString("tanggal"));
                transaksi.setTotalHarga(rs.getLong("total_harga"));
                transaksi.setBayar(rs.getLong("bayar"));
                transaksi.setKembalian(rs.getLong("kembalian"));
                
                transaksi.setIdKasir(user);
                transaksi.setIdPelanggan(pelanggan);

                transaksis.add(transaksi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaksis;
    }

    @Override
    public List<ModelTransaksi> getData2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelTransaksi> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
