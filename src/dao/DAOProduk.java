/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DataBase;
import java.util.List;
import model.ModelProduk;
import model.ModelKategory;
import service.ServiceProduk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fuadm
 */
public class DAOProduk implements ServiceProduk {

    private static Connection conn;

    public DAOProduk() {
        conn = DataBase.getConn();
    }

    @Override
    public void addData(ModelProduk mopa) {
        String sql = """
        INSERT INTO menu_produk (id_kategori,nama_Menu,harga,stok,status)
        VALUES (?,?,?,?,?)
        """;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, mopa.getIdKategori().getId());
            st.setString(2, mopa.getNamaMenu());
            st.setLong(3, mopa.getHarga());
            st.setInt(4, mopa.getStok());
            st.setString(5, mopa.getStatus());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateData(ModelProduk mopa) {
        String sql = "UPDATE mene_produk SET id_kategori=?, nama_menu=?, harga=?, stok=?, status=?  WHERE id='" + mopa.getId() + "'";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, mopa.getIdKategori().getId());
            st.setString(2, mopa.getNamaMenu());
            st.setLong(3, mopa.getHarga());
            st.setInt(4, mopa.getStok());
            st.setString(5, mopa.getStatus());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteData(ModelProduk mopa) {
        String sql = "DELETE FROM menu_produk WHERE id =?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, mopa.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelProduk getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelProduk> getData() {
        List<ModelProduk> produks = new ArrayList<>();

        String sql = """
        SELECT mp.id, mk.id, mk.nama_kategori, mp.nama_menu, mp.harga, mp.stok, mp.status
        FROM menu_produk mp
        INNER JOIN kategori_menu mk 
        ON mp.id_kategori = mk.id
        ORDER BY mp.nama_menu ASC
        """;

        try (
                PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                ModelProduk produk = new ModelProduk();
                ModelKategory kategori = new ModelKategory();

                produk.setId(rs.getString("id"));
                kategori.setId(rs.getString("id_kategori"));
                kategori.setNamakategori(rs.getString("nama_kategori"));
                produk.setNamaMenu(rs.getString("nama_menu"));
                produk.setHarga(rs.getLong("harga"));
                produk.setStok(rs.getInt("stok"));

                produk.setIdKategori(kategori);

                produks.add(produk);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produks;
    }

    @Override
    public List<ModelProduk> getData2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelProduk> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
