package com.rutu.service;

import com.rutu.model.CompanyData;
import com.rutu.model.Employee;
import com.rutu.model.RequestData;
import com.rutu.repository.CompanyRepository;
import com.rutu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    public List<Employee> findRecordByCompanyName;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Employee insertEmpData(Employee employee) {
        CompanyData companyData = new CompanyData();
        companyData.setEmpCompany(employee.getEmpCompany());
        companyData.setEmpName(employee.getEmpName());
        companyRepository.save(companyData);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllRecords() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getRecordById(Integer id) {
        Optional<Employee> employeeOptionalData = employeeRepository.findById(id);
        if (employeeOptionalData.isPresent()) {
            return employeeOptionalData.get();
        } else
            throw new RuntimeException("Record Not Found in Database");

    }

    @Override
    public Employee deleteRecordById(Integer id) {
        Optional<Employee> optionalEmployee;
        try {
            optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                employeeRepository.deleteById(id);
            } else {
                throw new RuntimeException("Record does not found with given id");
            }
        } catch (Exception e) {
            throw new RuntimeException("something is wrong while deleting record" + e.getMessage());
        }
        return optionalEmployee.get();
    }

    @Override
    public Employee updateRecordById(Employee employee) {
        Optional<Employee> dbEmployeeOptional = employeeRepository.findById(employee.getEmpId());
        if (dbEmployeeOptional.isPresent()) {
            Employee employee1 = dbEmployeeOptional.get();
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmpCompany(employee.getEmpCompany());
            employee1.setEmpSalary(employee.getEmpSalary());
            return employeeRepository.save(employee1);
        } else {
            throw new RuntimeException("Record does not exist");
        }
    }

    @Override
    public List<Employee> findRecordByCompanyName(String empCompany) {
        List<Employee> employeeDataList = employeeRepository.findAll();
        return employeeDataList
                .stream()
                .filter(employee -> employee.getEmpCompany().equalsIgnoreCase(empCompany))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByCompanyAndSalary(RequestData requestData) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employeeResultList = employeeList
                .stream()
                .filter(employee -> employee.getEmpCompany().
                        equalsIgnoreCase(requestData.getEmpCompany()) &&
                        employee.getEmpSalary() >= requestData.getEmpSalary())
                .collect(Collectors.toList());
        if (employeeResultList.isEmpty()) {
            throw new RuntimeException("No Record Found with given input");
        } else {
            return employeeResultList;
        }
    }

    @Override
    public List<String> getEmployeeNamesByCompany(String empCompany) {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList
                .stream()
                .filter(employee -> employee.getEmpCompany().equalsIgnoreCase(empCompany))
                .map(Employee::getEmpName)
                .collect(Collectors.toList());
    }

    @Override
    public Employee insertValidEmpData(RequestData requestData) {
        Employee employee1 = new Employee();
        employee1.setEmpCompany(requestData.getEmpCompany());
        employee1.setEmpSalary(requestData.getEmpSalary());
        return employeeRepository.save(employee1);
    }
}

