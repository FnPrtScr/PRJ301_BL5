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

    public Employee getEmployeeById(int eid) throws SQLException {
        try {
            String sql = "SELECT * FROM Employee WHERE eid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEid(rs.getInt("eid"));
                employee.setName(rs.getString("name"));
                employee.setOffice(rs.getString("office"));
                return employee;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Employee";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                employees.add(getEmployeeById(rs.getInt("eid")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
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
//                w.setEid(rs.getInt("eid"));
                w.setWdate(rs.getDate("wdate"));
                working.add(w);
                return working;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }
//
//    public ArrayList<Employee> getEmployee(Date wdate) {
//        ArrayList<Employee> employees = new ArrayList<>();
//
//        try {
//            String sql = "SELECT e.eid,[name],e.office, ISNULL(w.wid,-1) wid, w.wdate FROM Employee e \n"
//                    + "                    LEFT JOIN (SELECT * FROM Working WHERE wdate = ? ) w \n"
//                    + "                    ON e.eid = w.eid";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setTimestamp(1, DateTimeHelper.getTimeStamp(DateTimeHelper.removeTime(wdate)));
//            ResultSet rs = stm.executeQuery();
//            Employee curEmp = new Employee();
//            curEmp.setEid(-1);
//            while (rs.next()) {
//                int eid = rs.getInt("eid");
//                if (eid != curEmp.getEid()) {
//                    curEmp = new Employee();
//                    curEmp.setEid(rs.getInt("eid"));
//                    curEmp.setName(rs.getString("name"));
//                    curEmp.setOffice(rs.getString("office"));
//                    employees.add(curEmp);
//                }
//                int wid = rs.getInt("wid");
//                if (wid != -1) {
//                    Working w = new Working();
//                    w.setEid(curEmp);
//                    w.setWid(rs.getInt("wid"));
//                    w.setWdate(DateTimeHelper.getDateFrom(rs.getTimestamp("wdate")));
//                    curEmp.getWorking().add(w);
//                }
//
//            }
//
//        } catch (Exception e) {
//        }
//        try {
//            String sql = "SELECT e.eid,[name], ISNULL(l.lid,-1) lid, l.lfrom,lto FROM Employee e \n"
//                    + "LEFT JOIN (SELECT * FROM Leave WHERE lfrom >= ? and lto <= ? ) l \n"
//                    + "ON e.eid = l.eid";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setTimestamp(1, DateTimeHelper.getTimeStamp(DateTimeHelper.removeTime(wdate)));
//            ResultSet rs = stm.executeQuery();
//            Employee curEmp = new Employee();
//            curEmp.setEid(-1);
//            while (rs.next()) {
//                int lid = rs.getInt("lid");
//                if (lid != -1) {
//                    Leave leave=new Leave();
//                    leave.setLid(lid);
//                    leave.setReason(rs.getString("reason"));
//                    leave.setEid(employees.get(rs.getInt("eid")));
//                    Date d=new Date();
//                    d=DateTimeHelper.removeTime(d);
//                    leave.setLfrom(DateTimeHelper.addDays(d, rs.getInt("eid")));
//                    leave.setLto(DateTimeHelper.addDays(d, rs.getInt("eid")));
//                    employees.get(rs.getInt("eid")).getLeaves().add(leave);
//                }
//
//            }
//
//        } catch (Exception e) {
//        }
//        return employees;
//    }

}
