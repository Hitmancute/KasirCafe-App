package dao;

import config.DataBase;
import model.ModelLogin;
import service.ServiceLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import main.MenuUtama;
import view.FormLogin;

public class DAOLogin implements ServiceLogin {

    private static Connection conn;

    public DAOLogin() {
        conn = DataBase.getConn();
    }

    @Override
    public void prossLogin(ModelLogin molo) {

        PreparedStatement st = null;
        ResultSet rs = null;

        String id;
        String nama;
        String role;

        String query = "SELECT * FROM kasir WHERE username=? AND password=?";

        try {

            st = conn.prepareStatement(query);

            st.setString(1, molo.getUsername());
            st.setString(2, Encrypt.getMd5Java(molo.getPassword()));

            rs = st.executeQuery();

            if (rs.next()) {

                id = rs.getString("id");
                nama = rs.getString("nama");
                role = rs.getString("role");

                JOptionPane.showMessageDialog(null, "Login berhasil");

                MenuUtama menu = new MenuUtama(id, nama, role);

                menu.setVisible(true);
                menu.revalidate();

                FormLogin lg = new FormLogin();
                lg.tutup = true;

            } else {
                JOptionPane.showMessageDialog(null, "Username dan Password salah", "Login Gagal",JOptionPane.ERROR_MESSAGE);
                FormLogin lg = new FormLogin();
                lg.tutup = false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
        }
    }
}
