package com.rutu.model;

import javax.persistence.*;

@Entity
@Table(name = "Company_Data")
public class CompanyData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer compId;
    private String empCompany;
    private String empName;

    public CompanyData() {

    }

    public CompanyData(Integer compId, String empCompany, String empName) {
        this.compId = compId;
        this.empCompany = empCompany;
        this.empName = empName;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getEmpCompany() {
        return empCompany;
    }

    public void setEmpCompany(String empCompany) {
        this.empCompany = empCompany;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "CompanyData{" +
                "compId=" + compId +
                ", empCompany='" + empCompany + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
