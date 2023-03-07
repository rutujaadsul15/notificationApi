package com.rutu.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class RequestData {

    @NotBlank(message = "Comapany name should present")
    private String empCompany;

    @Min(value=1000, message = "salary in between 1000 to 500000")
    @Max(value=500000, message = "salary in between 1000 to 500000")
    private Integer empSalary;

    public RequestData() {

    }

    public RequestData(String empCompany, Integer empSalary) {
        this.empCompany = empCompany;
        this.empSalary = empSalary;
    }

    public String getEmpCompany() {
        return empCompany;
    }

    public void setEmpCompany(String empCompany) {
        this.empCompany = empCompany;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "empCompany='" + empCompany + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
