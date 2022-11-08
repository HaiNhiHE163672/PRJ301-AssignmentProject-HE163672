/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.assignment.Account;
import model.assignment.Lecturer;
import model.assignment.Student;

/**
 *
 * @author User
 */
public class AccountDBContext extends DBContext<Account> {
    
    public Account get(String username, String password) {
        try {
            String sql = "select a.userid,a.pass, a.displayname \n"
                    + "                           ,ISNULL(s.stdid,'') stdid,ISNULL(s.stdname,'') stdname\n"
                    + "                    	   ,ISNULL(l.lid,'') lid,ISNULL(l.lname,'') lname\n"
                    + "                           from Account a\n"
                    + "                           left join Student s on s.displayname = a.displayname\n"
                    + "                    	  left join Lecturer l on l.displayname = a.displayname\n"
                    + " WHERE [userid] = ? AND pass = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Account account = new Account();
                account.setUsername(rs.getString("userid"));
                account.setPassword(rs.getString("pass"));
                account.setDisplayname(rs.getString("displayname"));
                
                Student s = new Student();
               s.setId(rs.getInt("stdid"));
               s.setName(rs.getString("stdname"));
               account.setStudent(s);
               
               Lecturer l = new Lecturer();
               l.setId(rs.getInt("lid"));
               l.setName(rs.getString("lname"));
               account.setLecturer(l);
               
               return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Account get() {
          try {
            String sql = "select a.userid,a.pass, a.displayname\n"
                    + "       ,ISNULL(s.stdid,'') stdid,ISNULL(s.stdname,'') stdname\n"
                    + "	   ,ISNULL(l.lid,'') lid,ISNULL(l.lname,'') lname\n"
                    + "       from Account a\n"
                    + "       left join Student s on s.displayname = a.displayname\n"
                    + "	   left join Lecturer l on l.displayname = a.displayname";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Account account = new Account();
                account.setUsername(rs.getString("userid"));
                account.setPassword(rs.getString("pass"));
                account.setDisplayname(rs.getString("displayname"));
                
               Student s = new Student();
               s.setId(rs.getInt("stdid"));
               s.setName(rs.getString("stdname"));
               account.setStudent(s);
               
               Lecturer l = new Lecturer();
               l.setId(rs.getInt("lid"));
               l.setName(rs.getString("lname"));
               account.setLecturer(l);
               
               return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Account> list() {
        ArrayList<Account> accounts = new ArrayList<>();
        String sql = "select a.userid,a.pass, a.displayname \n"
                + "                           ,ISNULL(s.stdid,'') stdid,ISNULL(s.stdname,'') stdname\n"
                + "                    	   ,ISNULL(l.lid,'') lid,ISNULL(l.lname,'') lname\n"
                + "                           from Account a\n"
                + "                           left join Student s on s.displayname = a.displayname\n"
                + "                    	   left join Lecturer l on l.displayname = a.displayname";
            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Account a = new Account(); 
                a.setUsername(rs.getString("userid"));
                a.setPassword(rs.getString("pass"));
                a.setDisplayname(rs.getString("displayname"));
                
               Student s = new Student();
               s.setId(rs.getInt("stdid"));
               s.setName(rs.getString("stdname"));
               a.setStudent(s);
               
               Lecturer l = new Lecturer();
               l.setId(rs.getInt("lid"));
               l.setName(rs.getString("lname"));
               a.setLecturer(l);
                
                accounts.add(a);
       
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return accounts;


    }

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
