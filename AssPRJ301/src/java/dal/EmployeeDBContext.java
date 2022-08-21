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
                w.setEid(rs.getInt("eid"));
                w.setWdate(rs.getDate("wdate"));
                working.add(w);
            return working;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeDBContext ts = new EmployeeDBContext();
        ArrayList<Working> timesheet = ts.getTimeSheet(7);
        for (Working working : timesheet) {
            System.out.println(working.getWdate());
        }}

    }
