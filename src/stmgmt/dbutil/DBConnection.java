/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class DBConnection {
private static Connection conn;
    static{

try{
    Class.forName("oracle.jdbc.OracleDriver");
    conn=DriverManager.getConnection("java:oracle:thin:@//LAPTOP-LSAF024L:1521/XE","system","ajay");
    JOptionPane.showMessageDialog(null, "Connected to DB","SUCCESSSSS",JOptionPane.INFORMATION_MESSAGE);
    
}
catch(ClassNotFoundException ex){
    JOptionPane.showMessageDialog(null, "Error in loading driver","ERROR",JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
}
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Error in SQL","ERROR",JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
}
}
    public static Connection getConnection(){
        return conn;
}
    public static void closeConnection() throws SQLException{
        conn.close();
    }
    
}
