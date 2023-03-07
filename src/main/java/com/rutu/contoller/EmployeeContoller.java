package com.rutu.contoller;

import com.rutu.model.Employee;
import com.rutu.model.RequestData;
import com.rutu.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employeeoperations")
public class EmployeeContoller {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/insertempdata")
    public Employee insertEmpData(@RequestBody Employee employee) {
        return employeeServiceImpl.insertEmpData(employee);
    }

    @GetMapping("/getallrecords")
    public List<Employee> getAllRecords() {
        return employeeServiceImpl.getAllRecords();
    }

    @GetMapping("/getrecordbyid/{id}")
    public Employee getRecordById(@PathVariable("id") Integer id) {
        return employeeServiceImpl.getRecordById(id);
    }

    @DeleteMapping("/deleterecordbyid/{id}")
    public Employee deleteRecordById(@PathVariable("id") Integer id) {
        return employeeServiceImpl.deleteRecordById(id);
    }

    @PutMapping("/updaterecords")
    public Employee updateRecordById(@RequestBody Employee employee) {
        return employeeServiceImpl.updateRecordById(employee);
    }


    @GetMapping("/findrecordbycompanyname/{empCompany}")
    public List<Employee> findRecordByCompanyName(@PathVariable("empCompany") String empCompany) {
        return employeeServiceImpl.findRecordByCompanyName(empCompany);
    }

    @PostMapping("/findbycompanyandsalary")
    public List<Employee> findByCompanyAndSalary(@RequestBody RequestData requestData) {
        List<Employee> response = null;
        try {
            response = employeeServiceImpl.findByCompanyAndSalary(requestData);
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;

    }


    @GetMapping("/getemployeenamesbycompany/{empCompany}")
    public List<String> getEmployeeNamesByCompany(@PathVariable("empCompany") String empCompany) {
        return employeeServiceImpl.getEmployeeNamesByCompany(empCompany);
    }


    @PostMapping("/validate")
    public ResponseEntity<Employee> insertValidEmpData(@RequestBody @Valid RequestData requestData) {
        Employee employee = employeeServiceImpl.insertValidEmpData(requestData);
         return ResponseEntity.ok(employee);
    }
}
