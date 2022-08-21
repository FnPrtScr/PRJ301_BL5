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
import model.Employee;
import model.Leave;
import model.Working;

/**
 *
 * @author MrTuan
 */
public class EmployeeDBContext extends DBContext {


    public ArrayList<Employee> getWorkingEmployees(Date begin, Date end) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,[name], ISNULL(w.wid,-1) wid, w.wdate FROM Employee e \n"
                    + "LEFT JOIN (SELECT * FROM Working WHERE wdate >= ? AND wdate <= ? ) w \n"
                    + "ON e.eid = w.eid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Employee curEmp = new Employee();
            curEmp.setEid(-1);
            while (rs.next()) {
                int eid = rs.getInt("eid");
                String name = rs.getString("name");
                String office = rs.getString("office");
                Employee employee = new Employee(eid, name, office);
                employees.add(employee);
            }
            int wid = rs.getInt("wid");
            if (wid != -1) {
                Working w = new Working();
                w.setWid(wid);
                w.setEid(curEmp);
                w.setWid(wid);
                w.setWdate(DateTimeHelper.getDateFrom(rs.getTimestamp("wdate")));
                curEmp.getWorking().add(w);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
//        try {
//            String sql = "SELECT e.eid,[name], ISNULL(l.lid,-1) lid, l.lfrom,lto FROM Employee e \n"
//                    + "LEFT JOIN (SELECT * FROM Leave WHERE lfrom >= ? and lto <= ? ) l \n"
//                    + "ON e.eid = l.eid";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            Employee curEmp = new Employee();
//            curEmp.setEid(-1);
//            while (rs.next()) {
//                int eid = rs.getInt("eid");
//                String name = rs.getString("name");
//                String office = rs.getString("office");
//                Employee employee = new Employee(eid, name, office);
//                employees.add(employee);
//            }
//            int lid = rs.getInt("lid");
//            String reason=rs.getString("reason");
//            if (lid != -1) {
//                Leave l = new Leave();
//                l.setLid(lid);
//                l.setEid(curEmp);
//                l.setReason(reason);
//                l.setLfrom(DateTimeHelper.getDateFrom(rs.getTimestamp("lfrom")));
//                l.setLto(DateTimeHelper.getDateFrom(rs.getTimestamp("lto")));
//                curEmp.getLeaves().add(l);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
        
        return employees;
        
    }
//
//    public void getLeaveEmployees(Date begin, Date end) {
//        List<Employee> employees = new ArrayList<>();
//        try {
//            String sql = "SELECT e.eid,[name], ISNULL(l.lid,-1) lid, l.lfrom,lto FROM Employee e \n"
//                    + "LEFT JOIN (SELECT * FROM Leave WHERE lfrom >= ? and lto <= ? ) l \n"
//                    + "ON e.eid = l.eid";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            Employee curEmp = new Employee();
//            curEmp.setEid(-1);
//            while (rs.next()) {
//                int eid = rs.getInt("eid");
//                String name = rs.getString("name");
//                String office = rs.getString("office");
//                Employee employee = new Employee(eid, name, office);
//                employees.add(employee);
//            }
//            int lid = rs.getInt("lid");
//            String reason=rs.getString("reason");
//            if (lid != -1) {
//                Leave l = new Leave();
//                l.setLid(lid);
//                l.setEid(curEmp);
//                l.setReason(reason);
//                l.setLfrom(DateTimeHelper.getDateFrom(rs.getTimestamp("lfrom")));
//                l.setLto(DateTimeHelper.getDateFrom(rs.getTimestamp("lto")));
//                curEmp.getLeaves().add(l);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//    
}
