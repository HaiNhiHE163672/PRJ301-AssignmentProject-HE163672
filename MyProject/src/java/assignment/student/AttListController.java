/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.student;

import assignment.login.BaseAuthenticationController;
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
import model.assignment.Account;
import model.assignment.Attandance;
import model.assignment.Group;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Subject;




/**
 *
 * @author User
 */
public class AttListController extends BaseAuthenticationController {

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
            ArrayList<Group> groups = groupDB.listByGid(gid);
            Group group = groupDB.get(gid);
            request.setAttribute("groups", groups);
            request.setAttribute("group", group);
            
            
            SessionDBContext sesDB = new SessionDBContext();
            ArrayList<Session> sessions = sesDB.showlist(stdid,subid);
            request.setAttribute("sessions", sessions);
            
            
            SubjectDBContext subDB = new SubjectDBContext();
            ArrayList<Subject> subjects = subDB.listByStdid(stdid);
            Subject subject = subDB.get(subid);
            request.setAttribute("subjects", subjects);
            request.setAttribute("subject", subject);
            
            
            AttandanceDBContext atDB = new AttandanceDBContext();
            ArrayList<Attandance> atts = atDB.list(stdid);
            request.setAttribute("atts", atts);
        
     
        request.getRequestDispatcher("../view/student/attlist.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
         processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
         processRequest(req, resp);
    }

}
