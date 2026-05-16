/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DataBase;
import java.util.List;
import model.ModelKategory;
import service.ServiceKategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fuadm
 */
public class DAOKategory implements ServiceKategory {

    private static Connection conn;

    public DAOKategory() {
        conn = DataBase.getConn();
    }

    @Override
    public void addData(ModelKategory moka) {
        String sql = """
        INSERT INTO kategori_menu (nama_kategori)
        VALUES (?)
        """;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, moka.getNamakategori());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateData(ModelKategory moka) {
        String sql = "UPDATE kategori_menu SET nama_kategori=? WHERE id='" + moka.getId() + "'";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, moka.getNamakategori());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteData(ModelKategory moka) {
        String sql = "DELETE FROM kategori_menu WHERE id =?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, moka.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelKategory getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelKategory> getData() {

        List<ModelKategory> categories = new ArrayList<>();

        String sql = """
        SELECT id, nama_kategori
        FROM kategori_menu
        ORDER BY nama_kategori ASC
        """;

        try (
                PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                ModelKategory category = new ModelKategory();

                category.setId(rs.getString("id"));
                category.setNamakategori(rs.getString("nama_kategori"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public List<ModelKategory> getData2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelKategory> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelKategory> search2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
