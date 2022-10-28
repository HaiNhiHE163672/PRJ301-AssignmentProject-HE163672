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
import model.assignment.Attandance;
import model.assignment.Group;
import model.assignment.Session;
import model.assignment.Student;

/**
 *
 * @author User
 */
public class StudentDBContext extends DBContext<Student>{

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public Student get(int stdid) {
       
         try {
        String sql = "select s.stdid, s.stdname\n"
                + "      ,ses.sesid,ses.[date],ses.[index],ses.[date] ,ses.attanded\n"
                + "      ,ISNULL(a.present,0) present, ISNULL(a.[description],'') [description]\n"
                + "	  ,g.gid,g.gname	  \n"
                + "        from Student s\n"
                + "			 inner join Student_Group sg on sg.stdid = s.stdid\n"
                + "			 inner join [Group] g on g.gid = sg.gid\n"
                + "			 left join [Session]  ses on ses.gid = g.gid\n"
                + "			 LEFT JOIN Attandance a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                + "	     where s.stdid = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stdid);
            
            ResultSet rs = stm.executeQuery();
            
        while (rs.next()){
            
                
            Student std = new Student();
            std.setId(rs.getInt("stdid"));
            std.setName(rs.getString("stdname"));
            

            Group g = new Group();
            g.setId(rs.getInt("gid"));
            g.setName(rs.getString("gname"));
            std.getGroups().add(g);
            
            Session ses = new Session();
            ses.setId(rs.getInt("sesid"));
            ses.setDate(rs.getDate("date"));
            ses.setIndex(rs.getInt("index"));
            ses.setAttanded(rs.getBoolean("attanded"));

                Attandance a = new Attandance();
                a.setSession(ses);
                a.setStudent(std);
                a.setPresent(rs.getBoolean("present"));
                a.setDescription(rs.getString("description"));
                std.getAtts().add(a);
                
               
                return std;
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return null;
        
    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
