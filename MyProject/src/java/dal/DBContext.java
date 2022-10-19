/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public abstract class DBContext<T> {
    protected Connection connection;
    public DBContext() {
        try {
            String user = "nhinth";
            String pass = "123456789";
            String url = "jdbc:sqlserver://DESKTOP-GM3477H:1433;databaseName=PRJ301_FALL2022_Assignment";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract void insert(T model); 
    public abstract void update(T model); 
    public abstract void delete(T model); 
    public abstract T get(int id); 
    public abstract ArrayList<T> list();
}
