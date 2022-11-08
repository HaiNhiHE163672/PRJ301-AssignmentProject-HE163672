/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.login;

import dal.AccountDBContext;
import dal.GroupDBContext;
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
import model.assignment.Subject;
/**
 *
 * @author User
 */
public class HomeController extends BaseRolesController {

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
        response.setContentType("text/html;charset=UTF-8");
        AccountDBContext accDB = new AccountDBContext();
        Account a = accDB.get();
        request.setAttribute("a", a);
        
        GroupDBContext groupDB = new GroupDBContext();
        Group g = groupDB.show();
        request.setAttribute("g", g);
        
        SubjectDBContext subDB = new SubjectDBContext();
        Subject s = subDB.get();
        request.setAttribute("s", s);
       request.getRequestDispatcher("home.jsp").forward(request, response);
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
