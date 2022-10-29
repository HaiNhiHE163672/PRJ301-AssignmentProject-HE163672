/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.student;

import dal.AttandanceDBContext;
import dal.GroupDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import dal.SubjectDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.assignment.Attandance;
import model.assignment.Group;
import model.assignment.Session;
import model.assignment.Student;




/**
 *
 * @author User
 */
public class AttListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int stdid = Integer.parseInt(request.getParameter("stdid"));
        int gid = Integer.parseInt(request.getParameter("gid"));
        int subid = Integer.parseInt(request.getParameter("subid"));
                
        StudentDBContext stuDB = new StudentDBContext();
        Student student = stuDB.get(stdid);
        request.setAttribute("student", student);
    
        GroupDBContext groupDB = new GroupDBContext();
        ArrayList<Group> groups = groupDB.list(gid);
        request.setAttribute("groups", groups);


        SessionDBContext sesDB = new SessionDBContext();       
        ArrayList<Session> sessions = sesDB.showlist(stdid, gid,subid); 
        request.setAttribute("sessions", sessions);
        
        
        
        AttandanceDBContext atDB = new AttandanceDBContext();
        ArrayList<Attandance> atts = atDB.list(stdid);
        request.setAttribute("atts", atts);
              
        request.getRequestDispatcher("../view/student/attlist.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
