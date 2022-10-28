/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.assignment.Attandance;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.TimeSlot;

/**
 *
 * @author User
 */
public class AttandanceDBContext extends DBContext<Attandance>{

    @Override
    public void insert(Attandance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attandance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attandance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attandance get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Attandance> list() {
        ArrayList<Attandance> atts = new ArrayList<>();
        
        try {
            String sql = "select sesid, stdid, present, description, record_time from Attandance";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Attandance att = new Attandance();
                Session ses = new Session();
                ses.setId(rs.getInt("sesid"));
                att.setSession(ses);
                
                Student s = new Student();
                s.setId(rs.getInt("stdid"));
                att.setStudent(s);
                
                att.setDescription(rs.getString("description"));
                att.setPresent(rs.getBoolean("present"));
                Timestamp timestamp = rs.getTimestamp("record_time");
                java.util.Date record_time = new java.util.Date(timestamp.getTime());
                att.setRecord_time(record_time);
                atts.add(att);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AttandanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;

    }
    
}
