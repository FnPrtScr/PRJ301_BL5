/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Employee;

/**
 *
 * @author MrTuan
 */
public class EmployeeDBContext extends DBContext {

    List<Employee> employees = new ArrayList<>();

    public void getEmployees() {
        try {
            String sql = "SELECT e.eid,[name], ISNULL(w.wid,-1) wid, w.wdate FROM Employee e \n"
                    + "LEFT JOIN (SELECT * FROM Working WHERE wdate >= ? AND wdate <= ? ) w \n"
                    + "ON e.eid = w.eid";
            PreparedStatement stm= connection.prepareStatement(sql);
            ResultSet rs =stm.executeQuery();
            while(rs.next()){
                int eid=rs.getInt("eid");
                String name=rs.getString("name");
                String office=rs.getString("office");
                Employee employee=new Employee(eid, name, office);
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
}
