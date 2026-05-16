/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fuadm
 */
public class DataBase {
    private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/kasircafedb";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConn(){
        if(conn == null){
            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Connection succes");
                
            } catch (SQLException e) {
                System.err.println("Connection no succes "+ e.getMessage());
            }
        } return conn;
    }
}
