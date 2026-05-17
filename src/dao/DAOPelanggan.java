/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DataBase;
import java.util.List;
import model.ModelPelanggan;
import service.ServicePelanggan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fuadm
 */
public class DAOPelanggan implements ServicePelanggan {

    private static Connection conn;

    public DAOPelanggan() {
        conn = DataBase.getConn();
    }

    @Override
    public void addData(ModelPelanggan mopel) {
        String sql = """
        INSERT INTO pelanggan (nama,no_hp)
        VALUES (?,?)
        """;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, mopel.getNama());
            st.setString(2, mopel.getNoHp());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateData(ModelPelanggan mopel) {
        String sql = "UPDATE pelanggan SET nama=?, no_hp=?  WHERE id='" + mopel.getId() + "'";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, mopel.getNama());
            st.setString(2, mopel.getNoHp());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteData(ModelPelanggan mopel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelPelanggan getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelPelanggan> getData() {

        List<ModelPelanggan> pelanggans = new ArrayList<>();

        String sql = """
        SELECT id, nama, no_hp
        FROM pelanggan
        ORDER BY nama ASC
        """;

        try (
                PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                ModelPelanggan pelanggan = new ModelPelanggan();

                pelanggan.setId(rs.getString("id"));
                pelanggan.setNama(rs.getString("nama"));
                pelanggan.setNoHp(rs.getString("no_hp"));

                pelanggans.add(pelanggan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelanggans;
    }

    @Override
    public List<ModelPelanggan> getData2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelPelanggan> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
