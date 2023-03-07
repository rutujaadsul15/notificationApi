package com.rutu.service;

import com.rutu.model.Employee;
import com.rutu.model.RequestData;

import java.util.List;

public interface EmployeeService {
    Employee insertEmpData(Employee employee);

    List<Employee> getAllRecords();

    Employee getRecordById(Integer id);

    Employee deleteRecordById(Integer id);

    Employee updateRecordById(Employee employee);

    List<Employee> findRecordByCompanyName(String empCompany);

    List<Employee> findByCompanyAndSalary(RequestData requestData);

    List<String> getEmployeeNamesByCompany(String empCompany);

    Employee insertValidEmpData(RequestData requestData);
}
