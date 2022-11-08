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
import model.assignment.Attandance;
import model.assignment.Group;
import model.assignment.Session;
import model.assignment.Student;

/**
 *
 * @author User
 */
public class StudentDBContext extends DBContext<Student> {

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
                    + "                      ,ses.sesid,ses.[date],ses.[index],ses.[date] ,ses.attanded\n"
                    + "                      ,ISNULL(a.present,0) present, ISNULL(a.[description],'') [description]\n"
                    + "                	     ,g.gid,g.gname\n"
                    + "			     ,ac.displayname\n"
                    + "                        from Student s\n"
                    + "                			 inner join Student_Group sg on sg.stdid = s.stdid\n"
                    + "                			 inner join [Group] g on g.gid = sg.gid\n"
                    + "                			 left join [Session]  ses on ses.gid = g.gid\n"
                    + "                			 LEFT JOIN Attandance a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                    + "				         inner join Account ac on ac.displayname = s.displayname"
                    + "	     where s.stdid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stdid);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

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
                
                Account ac = new Account();
                ac.setDisplayname(rs.getString("displayname"));
                std.setAccount(ac);

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
    public ArrayList<Student> Show(int gid, int subid) {
        ArrayList<Student> stus = new ArrayList<>();
         String sql = "select s.stdid, s.stdname, g.gid, g.gname\n"
                + "     from Student s\n"
                + "    inner join Student_Group sg on sg.stdid = s.stdid\n"
                + "	inner join [Group] g on g.gid = sg.gid\n"
                + "	inner join [Subject] su on su.subid = g.subid \n"
                + "	where g.gid = ? and su.subid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            stm.setInt(2, subid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("stdid"));
                s.setName(rs.getString("stdname"));
                
                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                s.getGroups().add(g);
                
                stus.add(s);            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return stus;
         

    }
    

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> stus = new ArrayList<>();
         String sql = "select stdid, stdname from Student";
         try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("stdid"));
                s.setName(rs.getString("stdname"));
                stus.add(s);            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return stus;
         

    }

}
