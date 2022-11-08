/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.student;

import assignment.login.BaseAuthenticationController;
import dal.AccountDBContext;
import dal.AttandanceDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import dal.TimeSlotDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import model.assignment.Account;
import model.assignment.Attandance;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author User
 */
public class TimeTableController extends BaseAuthenticationController {

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
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        java.sql.Date from = null;
        java.sql.Date to = null;
        if (raw_from == null || raw_from.length() == 0) {
            Date today = new Date();
            int todayOfWeek = DateTimeHelper.getDayofWeek(today);
            Date e_from = DateTimeHelper.addDays(today, 2 - todayOfWeek);
            Date e_to = DateTimeHelper.addDays(today, 8 - todayOfWeek);
            from = DateTimeHelper.toDateSql(e_from);
            to = DateTimeHelper.toDateSql(e_to);
        } else {
            from = java.sql.Date.valueOf(raw_from);
            to = java.sql.Date.valueOf(raw_to);
        }

        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("year", DateTimeHelper.getYear(from));
        request.setAttribute("dates", DateTimeHelper.getDateList(from, to));

        AccountDBContext accDB = new AccountDBContext();
        Account acc = accDB.get();
        request.setAttribute("acc", acc);

        TimeSlotDBContext slotDB = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = slotDB.list();
        request.setAttribute("slots", slots);

        SessionDBContext sesDB = new SessionDBContext();
        ArrayList<Session> sessions = sesDB.filter(stdid, from, to);
        request.setAttribute("sessions", sessions);

        StudentDBContext stuDB = new StudentDBContext();
        Student student = stuDB.get(stdid);
        request.setAttribute("student", student);

        AttandanceDBContext atDB = new AttandanceDBContext();
        ArrayList<Attandance> atts = atDB.list(stdid);
        request.setAttribute("atts", atts);

        request.getRequestDispatcher("../view/student/timetable.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
