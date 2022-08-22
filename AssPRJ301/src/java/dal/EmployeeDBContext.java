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

    public ArrayList<Employee> getTotalWorking(int wdate) {
        ArrayList<Employee> totalWorking = new ArrayList<>();
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
                    totalWorking.add(curEmp);
                }
                int wid = rs.getInt("wid");
                if (wid != -1) {
                    Working w = new Working();
                    w.setEmp(curEmp);
                    w.setWid(wid);
                    w.setWdate(rs.getDate("wdate"));
                    curEmp.getWorking().add(w);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalWorking;
    }

    public ArrayList<Working> Working(int month) {
        ArrayList<Working> working = new ArrayList<>();
        try {
            String sql = "SELECT e.eid, e.name, w.wdate FROM Employee e, SalaryOffice s, Working w \n"
                    + "                            WHERE e.office = s.office AND e.eid = w.eid AND MONTH(w.wdate) = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, month);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Working w = new Working();
                w.setEid(rs.getInt("eid"));
                w.setWdate(rs.getDate("wdate"));
                working.add(w);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return working;
    }

    public ArrayList<Leave> Leave(int lfrom, int lto) {
        ArrayList<Leave> leave = new ArrayList<>();
        try {
            String sql = "SELECT e.eid, [name], l.lfrom,l.lto,l.reason FROM Employee e, SalaryOffice s, Leave l\n"
                    + "WHERE e.office = s.office AND e.eid = l.eid AND MONTH(l.lfrom) >= ? And MONTH(l.lto)<=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, lfrom);
            stm.setInt(2, lto);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Leave l = new Leave();
                l.setEid(rs.getInt("eid"));
                l.setLfrom(rs.getDate("lfrom"));
                l.setLto(rs.getDate("lto"));
                l.setReason(rs.getString("reason"));
                leave.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return leave;
    }
//

    public ArrayList<Employee> getTotalLeave(int lfrom, int lto) {
        ArrayList<Employee> totalLeave = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,[name],e.office, ISNULL(l.lid,-1) lid, l.lfrom,lto,l.reason FROM Employee e \n"
                    + "LEFT JOIN (SELECT * FROM Leave WHERE MONTH(lfrom) = ? and MONTH(lto) = ? ) l \n"
                    + "ON e.eid = l.eid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, lfrom);
            stm.setInt(2, lto);
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
                    totalLeave.add(curEmp);

                }
                int lid = rs.getInt("lid");
                if (lid != -1) {
                    Leave l = new Leave();
                    l.setEmp(curEmp);
                    l.setLid(lid);
                    l.setReason(rs.getString("reason"));
                    l.setLfrom(rs.getDate("lfrom"));
                    l.setLfrom(rs.getDate("lto"));
                    curEmp.getLeaves().add(l);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalLeave;
    }

    public static void main(String[] args) {

        EmployeeDBContext ts = new EmployeeDBContext();
        ArrayList<Employee> timesheet = ts.getTotalLeave(7, 7);
        for (Employee timesheet1 : timesheet) {
            System.out.println(timesheet1.getNumberOfLeaveDays());
        }

    }

}
