package com.example.demo.Entity;

import jakarta.persistence.*;


@Entity
@Table
public class xlentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    private String productName;
    private String period;
    private String plan;
    private String zone;
    private String pincode;
    private String ped;
    private String deduction;
    private String odPerc;
    private String sumInsured;

//    public xlentity(String productCode, String productName, String period, String plan, String zone, String pincode, String deduction, String odPerc, String sumInsured) {
//        this.productCode = productCode;
//        this.productName = productName;
//        this.period = period;
//        this.plan = plan;
//        this.zone = zone;
//        this.pincode = pincode;
//        this.ped = deduction;
//        this.deduction = deduction;
//        this.odPerc = odPerc;
//        this.sumInsured = sumInsured;
//    }


    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getPeriod() {
        return period;
    }

    public String getPlan() {
        return plan;
    }

    public String getZone() {
        return zone;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPed() {
        return ped;
    }

    public String getDeduction() {
        return deduction;
    }

    public String getOdPerc() {
        return odPerc;
    }

    public String getSumInsured() {
        return sumInsured;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setPeriod(String period) {
        this.period = period;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setPed(String ped) {
        this.ped = ped;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public void setOdPerc(String odPerc) {
        this.odPerc = odPerc;
    }

    public void setSumInsured(String sumInsured) {
        this.sumInsured = sumInsured;
    }

//    public static String toString(xlentity user) {
//        return user.getProductCode() + "\n " + user.getProductName() + "\n" + user.getPeriod() + "\n " + user.getPlan() + "\n" + user.getZone() + "\n" + user.getPincode() + "\n " + user.getPed() + "\n" + user.getDeduction() + "\n" + user.getOdPerc() + "\n " + user.getSumInsured();
//    }

    public String toString() {
        return "-" + this.productCode + "-" + this.productName + "-" + this.period + "-"+"-" + this.plan + "-" + this.zone + "-" + this.pincode + "-"+"-" + this.ped + "-" + this.deduction + "-" + this.odPerc + "-"+this.sumInsured;
    }
}
