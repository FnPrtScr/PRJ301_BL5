/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author MrTuan
 */
public class Employee {
    private int eid;
    private String name;
    private String office;
    private ArrayList<Working> working = new ArrayList<>();
    private ArrayList<Leave> leaves = new ArrayList<>();
//working
    public ArrayList<Working> getWorking() {
        return working;
    }

    public void setWorking(ArrayList<Working> working) {
        this.working = working;
    }
    
    public int getNumberOfWorkingDays(){
        return working.size();
    }
//leave
    public ArrayList<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(ArrayList<Leave> leaves) {
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
