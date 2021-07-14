/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DBConnection {
    private static Connection con;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    public static Connection getConnection() {
        con = null;
        try {
            URL = "jdbc:mysql://localhost:3306/";
            USER = "root";
            PASSWORD = "123456";
            // driver register
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (con);
    }
 
    public static void freeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        if (c == null) {
            System.out.println("Something wrong");
        } 
        freeConnection();
    }
}
