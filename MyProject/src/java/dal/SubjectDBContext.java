/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author User
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.assignment.Attandance;
import model.assignment.Group;
import model.assignment.Lecturer;
import model.assignment.Room;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Subject;
import model.assignment.TimeSlot;

/**
 *
 * @author User
 */
public class SubjectDBContext  extends DBContext<Subject>{
    

    
    @Override
    public void insert(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subject model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public Subject get() {
         try {
        String sql = "select subid, subname from [Subject]";
        
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
               Subject sub = new Subject();

                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));

                return sub;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

         
        return null;        
     }

    @Override
    public Subject get(int id) {
        try {
        String sql = "select su.subid, su.subname\n"
                     + "       from [Subject] su\n"
                     + "      where su.subid = ?";
        
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,id); 
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
               Subject sub = new Subject();

                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));

                return sub;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;


    }

    public ArrayList<Subject> listByStdid(int stdid) {
         ArrayList<Subject> subjects = new ArrayList<>();
         
         String sql = "SELECT s.subid, s.subname\n"
                + "                    FROM [Subject] s\n"
                + "                	inner join [Group] g on s.subid = g.subid\n"
                + "			inner join Student_Group sg on sg.gid = g.gid\n"
                + "			inner join Student st on st.stdid = sg.stdid\n"
                + "                    WHERE st.stdid = ?\n"
                + "	GROUP BY s.subid, s.subname";
            
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stdid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Subject sub = new Subject();
                Group g = new Group();
                
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                sub.getGroups().add(g);
                subjects.add(sub);            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return subjects;
    }

    @Override
    public ArrayList<Subject> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    }
