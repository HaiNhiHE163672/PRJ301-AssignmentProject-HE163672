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
import model.assignment.Group;
import model.assignment.Subject;

/**
 *
 * @author User
 */
public class GroupDBContext extends DBContext<Group>{

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Group get(int id) {
        String sql = " select g.gid, g.gname,g.sem, g.year\n"
                + "        from [Group] g\n"            
                + "		where g.gid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Group g = new Group(); 
                        
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                g.setSem(rs.getString("sem"));
                g.setYear(rs.getInt("year"));
                
                return g;
                        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }

    

    public ArrayList<Group> list(int gid) {
        ArrayList<Group> groups = new ArrayList<>();
        String sql = " select g.gid, g.gname,g.sem, g.year\n"
                + "       ,s.subid, s.subname\n"
                + "        from [Group] g\n"
                + "		inner join [Subject] s on s.subid = g.subid\n"
                + "		where g.gid = ?";
            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Group g = new Group(); 
                
                Subject s = new Subject();
                s.setId(rs.getInt("subid"));
                s.setName(rs.getString("subname"));
                g.setSubject(s);
     
                
                
                        
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                g.setSem(rs.getString("sem"));
                g.setYear(rs.getInt("year"));
                groups.add(g);
                
                        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return groups;
    }

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
