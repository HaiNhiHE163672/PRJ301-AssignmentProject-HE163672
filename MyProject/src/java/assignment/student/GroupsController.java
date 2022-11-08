/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.student;

import assignment.login.BaseAuthenticationController;
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
import model.assignment.Group;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Subject;

/**
 *
 * @author User
 */
public class GroupsController extends BaseAuthenticationController {

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
        
        int subid = Integer.parseInt(request.getParameter("subid"));
        int gid = Integer.parseInt(request.getParameter("gid"));
        
        GroupDBContext groupDB = new GroupDBContext();
            ArrayList<Group> groups = groupDB.listByGid(gid);
            ArrayList<Group> groupss = groupDB.listBySubid(subid);
            Group group = groupDB.getId(gid);
            request.setAttribute("groupss", groupss);
            request.setAttribute("groups", groups);
            request.setAttribute("group", group);

            
             ArrayList<Group> gr = groupDB.listById(gid);
             request.setAttribute("gr", gr);
             
            
            SubjectDBContext subDB = new SubjectDBContext();
            ArrayList<Subject> subjects = subDB.list();
            Subject subject = subDB.get(subid);
            request.setAttribute("subjects", subjects);
            request.setAttribute("subject", subject);
            
            StudentDBContext stuDB = new StudentDBContext();
            ArrayList<Student> students = stuDB.Show(gid,subid);
            request.setAttribute("students", students);
            
            
            request.getRequestDispatcher("../view/student/group.jsp").forward(request, response);
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
        processRequest(request, response);
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req, resp);

    }

}
