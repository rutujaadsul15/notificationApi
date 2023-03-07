package com.rutu.model;

import javax.persistence.*;

@Entity
@Table(name = "Emp_Data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer empId;
    private String empName;
    private Integer empSalary;
    private String empCompany;

    public Employee() {

    }

    public Employee(Integer empId, String empName, Integer empSalary, String empCompany) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empCompany = empCompany;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpCompany() {
        return empCompany;
    }

    public void setEmpCompany(String empCompany) {
        this.empCompany = empCompany;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empCompany='" + empCompany + '\'' +
                '}';
    }


}
