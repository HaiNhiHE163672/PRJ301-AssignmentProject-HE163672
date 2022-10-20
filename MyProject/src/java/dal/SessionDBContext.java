/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.assignment.Group;
import model.assignment.Room;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Subject;
import model.assignment.TimeSlot;

/**
 *
 * @author User
 */
public class SessionDBContext extends DBContext<Session>{
    
    public ArrayList<Session> filter(int stdid, Date from, Date to) {
        ArrayList <Session> sessions = new ArrayList<>();
        try {
        String sql = "SELECT ses.sesid,ses.[date],ses.[index]\n"
                + "                      ,ses.attanded,std.stdid\n"
                + "                      ,std.stdname,g.gid,g.gname\n"
                + "                      ,sub.subid,sub.subname\n"
                + "                      ,r.rid,r.rname\n"
                + "                    	 ,t.tid,t.[description],t.tname\n"
                + "                    FROM [Session] ses \n"
                + "                    		INNER JOIN [Group] g ON g.gid = ses.gid\n"
                + "			        INNER JOIN Student_Group sg ON  g.gid = sg.gid\n"
                + "				INNER JOIN Student std ON std.stdid = sg.stdid\n"
                + "                    		INNER JOIN [Subject] sub ON sub.subid = g.subid\n"
                + "                    		INNER JOIN Room r ON r.rid = ses.rid\n"
                + "                    		INNER JOIN TimeSlot t ON t.tid = ses.tid\n"
                + "                    WHERE\n"
                + "                    std.stdid = ?\n"
                + "                    AND ses.[date] >= ?\n"
                + "                    AND ses.[date] <= ?";
        
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stdid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Session session = new Session();
                Student std = new Student();
                Room r = new Room();
                Group g = new Group();
                TimeSlot t = new TimeSlot();
                Subject sub = new Subject();
                
                session.setId(rs.getInt("sesid"));
                session.setDate(rs.getDate("date"));
                session.setIndex(rs.getInt("index"));
                session.setAttanded(rs.getBoolean("attanded"));
                
                
                std.setId(rs.getInt("stdid"));
                std.setName(rs.getString("stdname"));
                
                
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                session.setGroup(g);
                
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                g.setSubject(sub);
                
                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("rname"));
                session.setRoom(r);
                
                t.setId(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                t.setName(rs.getString("tname"));
                session.setSlot(t);
                sessions.add(session);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sessions;
        
    }

    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
