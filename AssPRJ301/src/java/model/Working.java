/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import helper.DateTimeHelper;
import java.util.Date;

/**
 *
 * @author MrTuan
 */
public class Working {
    private int wid;
//    private int eid;
    private Employee eid;
    private Date wdate; 
    private Date cidate; 

    public Working() {
    }
    public Date getCidate() {
        return DateTimeHelper.removeTime(wdate);
    }

    public Working(int wid, Employee eid, Date wdate) {
        this.wid = wid;
        this.eid = eid;
        this.wdate = wdate;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }
    
}
