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
import service.ServiceTransaksi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import model.ModelDetailTransaksi;

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
    public void addData(ModelTransaksi motran, ModelDetailTransaksi modetran) {

        String sqlTransaksi = "INSERT INTO transaksi "
                + "(id_kasir,id_pelanggan,total_harga,bayar,kembalian) "
                + "VALUES (?,?,?,?,?)";

        String sqlDetail = "INSERT INTO detail_transaksi "
                + "(id_transaksi,id_menu,jumlah,subtotal) "
                + "VALUES (?,?,?,?)";

        try {

            conn.setAutoCommit(false);

            PreparedStatement stTransaksi = conn.prepareStatement(sqlTransaksi, Statement.RETURN_GENERATED_KEYS);

            stTransaksi.setString(1, motran.getIdKasir().getId());
            stTransaksi.setString(2, motran.getIdPelanggan().getId());
            stTransaksi.setLong(3, motran.getTotalHarga());
            stTransaksi.setLong(4, motran.getBayar());
            stTransaksi.setLong(5, motran.getKembalian());

            int result = stTransaksi.executeUpdate();

            if (result == 0) {
                throw new SQLException("Gagal insert transaksi!");
            }

            ResultSet rs = stTransaksi.getGeneratedKeys();

            int transaksiId;

            if (rs.next()) {
                transaksiId = rs.getInt(1);
            } else {
                throw new SQLException("ID transaksi gagal dibuat!");
            }

            PreparedStatement stDetail = conn.prepareStatement(sqlDetail);

            stDetail.setInt(1, transaksiId);
            stDetail.setString(2, modetran.getIdProduk().getId());
            stDetail.setInt(3, modetran.getJumlah());
            stDetail.setLong(4, modetran.getSubtotal());

            stDetail.executeUpdate();

            conn.commit();

            System.out.println("Transaksi berhasil disimpan");
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateData(ModelTransaksi motran, ModelDetailTransaksi modetran) {
        String sqlTransaksi = "UPDATE transaksi SET "
                + "id_kasir=?, "
                + "id_pelanggan=?, "
                + "total_harga=?, "
                + "bayar=?, "
                + "kembalian=? "
                + "WHERE id=?";

        String sqlDeleteDetail
                = "DELETE FROM detail_transaksi "
                + "WHERE id_transaksi=?";

        String sqlInsertDetail
                = "INSERT INTO detail_transaksi "
                + "(id_transaksi,id_menu,jumlah,subtotal) "
                + "VALUES (?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement stTransaksi = conn.prepareStatement(sqlTransaksi);

            stTransaksi.setString(1, motran.getIdKasir().getId());

            if (motran.getIdPelanggan() == null) {
                stTransaksi.setNull(2, Types.INTEGER);
            } else {
                stTransaksi.setString(2, motran.getIdPelanggan().getId());
            }
            stTransaksi.setLong(3, motran.getTotalHarga());
            stTransaksi.setLong(4, motran.getBayar());
            stTransaksi.setLong(5, motran.getKembalian());
            stTransaksi.setString(6, motran.getId());

            stTransaksi.executeUpdate();

            PreparedStatement stDelete = conn.prepareStatement(sqlDeleteDetail);

            stDelete.setString(1, motran.getId());

            stDelete.executeUpdate();

            PreparedStatement stInsert = conn.prepareStatement(sqlInsertDetail);

            stInsert.setString(1, motran.getId());
            stInsert.setString(2, modetran.getIdProduk().getId());
            stInsert.setInt(3, modetran.getJumlah());
            stInsert.setLong(4, modetran.getSubtotal());

            stInsert.executeUpdate();

            conn.commit();

            System.out.println("Transaksi berhasil diupdate");

        } catch (Exception e) {

            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }
    }

    @Override
    public void DeleteData(ModelTransaksi motran, ModelDetailTransaksi modetran) {
        String sql = "DELETE FROM transaksi WHERE id =?";
        String sql1 = "DELETE FROM detail_transaksi WHERE id =?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, motran.getId());
            st.executeUpdate();

            PreparedStatement st1 = conn.prepareStatement(sql1);
            st1.setString(1, modetran.getId());
            st1.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelTransaksi getById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ModelTransaksi> getData() {

        List<ModelTransaksi> transaksis = new ArrayList<>();

        String sql = """
        SELECT transaksi.id, id_kasir, id_pelanggan,kasir.nama, pelanggan.nama ,tanggal, total_harga, bayar, kembalian
        FROM transaksi
        INNER JOIN kasir ON transaksi.id_kasir = kasir.id
        INNER JOIN pelanggan ON transaksi.id_pelanggan = pelanggan.id
        """;

        try (
                PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                ModelTransaksi transaksi = new ModelTransaksi();
                ModelLogin user = new ModelLogin();
                ModelPelanggan pelanggan = new ModelPelanggan();

                transaksi.setId(rs.getString("transaksi.id"));

                user.setId(rs.getString("id_kasir"));

                pelanggan.setId(rs.getString("id_pelanggan"));

                user.setNama(rs.getString("kasir.nama"));
                pelanggan.setNama(rs.getString("pelanggan.nama"));

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ModelTransaksi> search(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
