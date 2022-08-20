/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MrTuan
 */
public class SalaryOffice {
    private int sid;
    private Employee eid;
    private float salary;

    public SalaryOffice() {
    }

    public SalaryOffice(int sid, Employee eid, float salary) {
        this.sid = sid;
        this.eid = eid;
        this.salary = salary;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
}
