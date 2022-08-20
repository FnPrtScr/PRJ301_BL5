/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author MrTuan
 */
public class Leave {
    private int lid;
    private Employee eid;
    private Date ldate;
    private String reason;
    private boolean acceptleave;

    public Leave() {
    }

    public Leave(int lid, Employee eid, Date ldate, String reason, boolean acceptleave) {
        this.lid = lid;
        this.eid = eid;
        this.ldate = ldate;
        this.reason = reason;
        this.acceptleave = acceptleave;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isAcceptleave() {
        return acceptleave;
    }

    public void setAcceptleave(boolean acceptleave) {
        this.acceptleave = acceptleave;
    }
    
    
    
    
}
