/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.EmployeeDBContext;
import helper.DateTimeHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Employee;
import model.Leave;
import model.Working;

/**
 *
 * @author MrTuan
 */
public class TimeSheetReportController extends HttpServlet {

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
//        String m=request.getParameter("months");
//        String[] list = m.split("-");
//        int year=Integer.parseInt(list[0]);
//        int month=Integer.parseInt(list[1]);
////        Date today = new Date();
//        Date today = DateTimeHelper.removeTime(year,month-1);
//        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
//        Date begin = DateTimeHelper.addDays(today, -1 * (dayOfMonth - 1));
//        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1), -1);
//        ArrayList<Date> dates = DateTimeHelper.getDates(begin, end);
//        
//        request.setAttribute("dates", dates);
//        request.setAttribute("dates", dates);
//
//        EmployeeDBContext db=new EmployeeDBContext();
//        
//        ArrayList<Employee> employees = db.getAllEmployee();
//        request.setAttribute("employees", employees);
//        
//        
//        ArrayList<Working> working = db.getTimeSheet(7);
//        
//        request.setAttribute("working", working);        
//        
//        request.getRequestDispatcher("report.jsp").forward(request, response);
        response.sendRedirect("report.jsp");
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
        String m = request.getParameter("months");
//        String totalworking = request.getParameter("totalworking");
//        String totalleave = request.getParameter("totalleave");
//        String totalsalary = request.getParameter("totalsalary");
//        String save = request.getParameter("save");

        String[] list = m.split("-");
        int year = Integer.parseInt(list[0]);
        int month = Integer.parseInt(list[1]);
        Date today = DateTimeHelper.removeTime(year, month - 1);
        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
        Date begin = DateTimeHelper.addDays(today, -1 * (dayOfMonth - 1));
        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1), -1);
        ArrayList<Date> dates = DateTimeHelper.getDates(begin, end);

        request.setAttribute("dates", dates);
        request.setAttribute("dates", dates);

        EmployeeDBContext db = new EmployeeDBContext();

//        get total working
        ArrayList<Employee> totalWorking = db.getTotalWorking(7);
        request.setAttribute("totalWorking", totalWorking);

//        working timesheet
        ArrayList<Working> working = db.Working(7);
        request.setAttribute("working", working);
//        leave timesheet
        ArrayList<Leave> leave = db.Leave(7, 7);
        request.setAttribute("leave", leave);

//        get total leave
//        ArrayList<Employee> totalLeave=db.getTotalLeave(7,7);
//        request.setAttribute("totalLeave",totalLeave);
        request.getRequestDispatcher("report.jsp").forward(request, response);
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
