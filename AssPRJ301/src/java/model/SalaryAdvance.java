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
public class SalaryAdvance {
    private int said;
    private Employee eid;
    private Date datesa;
    private float howmuchsa;
    private String reasonsa;
    private boolean acceptsa;

    public SalaryAdvance() {
    }

    public SalaryAdvance(int said, Employee eid, Date datesa, float howmuchsa, String reasonsa, boolean acceptsa) {
        this.said = said;
        this.eid = eid;
        this.datesa = datesa;
        this.howmuchsa = howmuchsa;
        this.reasonsa = reasonsa;
        this.acceptsa = acceptsa;
    }

    public int getSaid() {
        return said;
    }

    public void setSaid(int said) {
        this.said = said;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }

    public Date getDatesa() {
        return datesa;
    }

    public void setDatesa(Date datesa) {
        this.datesa = datesa;
    }

    public float getHowmuchsa() {
        return howmuchsa;
    }

    public void setHowmuchsa(float howmuchsa) {
        this.howmuchsa = howmuchsa;
    }

    public String getReasonsa() {
        return reasonsa;
    }

    public void setReasonsa(String reasonsa) {
        this.reasonsa = reasonsa;
    }

    public boolean isAcceptsa() {
        return acceptsa;
    }

    public void setAcceptsa(boolean acceptsa) {
        this.acceptsa = acceptsa;
    }
    
}
