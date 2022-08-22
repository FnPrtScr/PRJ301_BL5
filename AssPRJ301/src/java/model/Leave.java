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
public class Leave {

    private int lid;
    private int eid;
    private Employee emp;
    private Date lfrom;
    private Date lto;
    private String reason;
    private boolean acceptleave;

    public Leave() {
    }

    public Leave(int lid, int eid, Employee emp, Date lfrom, Date lto, String reason, boolean acceptleave) {
        this.lid = lid;
        this.eid = eid;
        this.emp = emp;
        this.lfrom = lfrom;
        this.lto = lto;
        this.reason = reason;
        this.acceptleave = acceptleave;
    }

    public int getTotalDays() {
        return DateTimeHelper.getDates(lfrom, lto).size();
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Date getLfrom() {
        return lfrom;
    }

    public void setLfrom(Date lfrom) {
        this.lfrom = lfrom;
    }

    public Date getLto() {
        return lto;
    }

    public void setLto(Date lto) {
        this.lto = lto;
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
