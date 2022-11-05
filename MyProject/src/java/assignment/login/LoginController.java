/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.login;

import dal.AccountDBContext;
import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.assignment.Account;
import model.assignment.Student;

/**
 *
 * @author User
 */
public class LoginController extends HttpServlet {

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
        response.sendRedirect("login.jsp");

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

        String u = request.getParameter("user");
        String p = request.getParameter("pass");
        String r = request.getParameter("remember");
        AccountDBContext db = new AccountDBContext();
        Account account = db.get(u, p);

        if (account == null) {
            request.setAttribute("error", "login failed!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if (account != null) {
            request.getSession().setAttribute("account", account);

            Cookie username = new Cookie("user", u);
            Cookie password = new Cookie("pass", p);
            Cookie rem = new Cookie("remember", r);
            if (r == null) {
                username.setMaxAge(0);
                password.setMaxAge(0);
                rem.setMaxAge(0);

            } else {
                username.setMaxAge(60 * 60);// 1h
                password.setMaxAge(60 * 60); // 1h
                rem.setMaxAge(60 * 60); // 1h
            }
            response.addCookie(username);
            response.addCookie(password);
            response.addCookie(rem);
            request.getSession().setAttribute("account", account);
            
            response.sendRedirect("home");
            

            response.getWriter().println("login successful!");
        }
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
