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
import model.assignment.Student;
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
    public Group show() {
        String sql = " select gid, gname,sem, year from [Group]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
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
    
    public Group getId(int gid) {

        String sql = "SELECT st.stdid, st.stdname,g.gid,g.gname,s.subid,s.subname\n"
                + "                              FROM [Group] g\n"
                + "                              inner join [Subject] s on s.subid = g.subid\n"
                + "                		inner join Student_Group sg on sg.gid = g.gid\n"
                + "                		inner join Student st on st.stdid = sg.stdid\n"
                + "                   where g.gid = ?";
            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Group g = new Group(); 
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                
                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                g.setSubject(sub);
                        
                Student s = new Student();
                s.setId(rs.getInt("stdid"));
                s.setName(rs.getString("stdname"));
                g.getStudents().add(s);
                
                return g;
                
                        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }
    
    
    public ArrayList<Group> listById(int gid) {
        ArrayList<Group> groups = new ArrayList<>();
        String sql = "SELECT st.stdid, st.stdname\n"
                + "              FROM [Group] g\n"
                + "              inner join [Subject] s on s.subid = g.subid\n"
                + "		inner join Student_Group sg on sg.gid = g.gid\n"
                + "		inner join Student st on st.stdid = sg.stdid\n"
                + "   where g.gid = ?";
            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Group g = new Group(); 
                        
                Student s = new Student();
                s.setId(rs.getInt("stdid"));
                s.setName(rs.getString("stdname"));
                g.getStudents().add(s);
                groups.add(g);
                
                        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return groups;
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
    
    public ArrayList<Group> listBySubid(int subid) {
        ArrayList<Group> groups = new ArrayList<>();
        String sql = "SELECT g.gid, g.gname\n"
                + "                FROM [Group] g\n"
                + "                inner join [Subject] s on s.subid = g.subid\n"
                + "		   inner join Student_Group sg on sg.gid = g.gid\n"
                + "		   inner join Student st on st.stdid = sg.stdid\n"
                + "                 where s.subid = ?        \n"
                + "   GROUP BY g.gid, g.gname";
            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, subid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Group g = new Group(); 
                        
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                groups.add(g);
                
                        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return groups;
    }
    

    public ArrayList<Group> listByGid(int gid) {
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
        ArrayList<Group> groups = new ArrayList<>();
         String sql = " select gid, gname,sem, year\n"
                + "        from [Group]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Group g = new Group();    
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

  
 
    
}
