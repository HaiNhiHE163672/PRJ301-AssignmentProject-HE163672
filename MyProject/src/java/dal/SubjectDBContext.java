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
    
    public ArrayList<Subject> filter(int stdid, int subid){
        ArrayList <Subject> subjects = new ArrayList<>();
         try {
        String sql = "select su.subid, su.subname\n"
                     + "      ,g.gid,g.gname,g.sem,g.year\n"
                     + "	  ,std.stdid,std.stdname\n"
                     + "	  ,l.lid,l.lname\n"
                     + "	  ,ses.sesid, ses.[date], ses.attanded\n"
                     + "	  ,t.tid, t.[description]\n"
                     + "	  ,r.rid, r.rname\n"
                     + "	  ,ISNULL(att.present,0) present, ISNULL(att.[description],'') [description]\n"
                     + "       from Subject su\n"
                     + "	                inner join [Group] g on su.subid = g.subid\n"
                     + "			inner join Student_Group sg on sg.gid = g.gid\n"
                     + "			inner join Lecturer l on l.lid = g.lid\n"
                     + "			inner join Student std on std.stdid = sg.stdid\n"
                     + "			inner join session ses on ses.gid = g.gid\n"
                     + "			inner join TimeSlot t on t.tid = ses.tid\n"
                     + "			inner join Room r on r.rid = ses.rid\n"
                     + "			left join Attandance att on att.sesid = ses.sesid\n"
                     + "      where std.stdid = ?\n"
                     + "	    and su.subid = ?";
        
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stdid);
            stm.setInt(2, subid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Subject sub = new Subject();
                Session ses = new Session();
                Lecturer l = new Lecturer();
                Student std = new Student();
                Room r = new Room();
                Group g = new Group();
                TimeSlot t = new TimeSlot();
                Attandance a = new Attandance();
                
                
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                
                std.setId(rs.getInt("stdid"));
                std.setName(rs.getString("stdname"));
                g.getStudents().add(std);
                
                
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                g.setSem(rs.getString("sem"));
                g.setYear(rs.getInt("year"));
                sub.getGroups().add(g);
                
                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));
                g.setLecturer(l);
                
                ses.setId(rs.getInt("sesid"));
                ses.setDate(rs.getDate("date"));
                ses.setAttanded(rs.getBoolean("attanded"));
                g.getSessions().add(ses);
                
                t.setId(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                ses.setSlot(t);
                
                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("rname"));
                ses.setRoom(r);
                
                a.setStudent(std);
                a.setSession(ses);
                a.setPresent(rs.getBoolean("present"));
                a.setDescription(rs.getString("description"));
                ses.getAtts().add(a);
                subjects.add(sub);
                
                
                

                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
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

    @Override
    public Subject get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Subject> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
