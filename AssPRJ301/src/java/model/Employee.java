/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MrTuan
 */
public class Employee {
    private int eid;
    private String name;
    private String office;
    private List<Working> working = new ArrayList<>();
    private List<Leave> leaves = new ArrayList<>();
//working
    public List<Working> getWorking() {
        return working;
    }

    public void setWorking(List<Working> working) {
        this.working = working;
    }
    
    public int getNumberOfWorkingDays(){
        return working.size();
    }
//leave
    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }
    
    public int getTotalLeave(){
        int sum=0;
        for (Leave leave : leaves) {
            sum+=leave.getTotalDays();
        }
        return sum;
    }
    

    public Employee() {
    }

    public Employee(int eid, String name, String office) {
        this.eid = eid;
        this.name = name;
        this.office = office;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    
    
}
