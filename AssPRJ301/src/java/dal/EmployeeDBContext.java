/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import helper.DateTimeHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Leave;
import model.Working;

/**
 *
 * @author MrTuan
 */
public class EmployeeDBContext extends DBContext {
    
        public ArrayList<Employee> getEmployees(int wdate) {
        ArrayList<Employee> total = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,[name],e.office, ISNULL(w.wid,-1) wid, w.wdate FROM Employee e\n"
                    + "                    LEFT JOIN (SELECT * FROM Working WHERE MONTH(wdate) = ? ) w \n"
                    + "                    ON e.eid = w.eid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, wdate);
            ResultSet rs = stm.executeQuery();
            Employee curEmp = new Employee();
            curEmp.setEid(-1);
            while (rs.next()) {
                int eid = rs.getInt("eid");
                if (eid != curEmp.getEid()) {
                    curEmp = new Employee();
                    curEmp.setEid(eid);
                    curEmp.setName(rs.getString("name"));
                    curEmp.setOffice(rs.getString("office"));
                    total.add(curEmp);
                }
                int tid = rs.getInt("wid");
                if (tid != -1) {
                    Working w = new Working();
                    w.setEmp(curEmp);
                    w.setWid(tid);
                    w.setWdate(DateTimeHelper.getDateFrom(rs.getTimestamp("wdate")));
                    curEmp.getWorking().add(w);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ArrayList<Working> getTimeSheet(int month) {
        ArrayList<Working> working = new ArrayList<>();
        try {
            String sql = "SELECT e.eid, e.name, w.wdate FROM Employee e, SalaryOffice s, Working w \n"
                    + "                            WHERE e.office = s.office AND e.eid = w.eid AND MONTH(w.wdate) = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, month);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Working w = new Working();
                Employee emp = new Employee();
                w.setEid(rs.getInt("eid"));
                w.setWdate(rs.getDate("wdate"));
                w.setWdate(DateTimeHelper.getDateFrom(rs.getTimestamp("wdate")));
                working.add(w);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return working;
    }
    
    



    public static void main(String[] args) {
        EmployeeDBContext ts = new EmployeeDBContext();
        ArrayList<Employee> total = ts.getEmployees(7);
        for (Employee timesheet1 : total) {
            System.out.println(timesheet1.getOffice());
        }

    }

}
