package org.spring.controller;


import org.spring.entity.Employee;
import org.spring.entity.EmployeeXMLList;
import org.spring.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees/")
public class EmployeeRestController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping(value = "/v1")
    public Iterable<Employee> getAllEmployees(){
        return this.employeeRepo.findAll();
    }

    @GetMapping(value = "/v2")
    public EmployeeXMLList getAllEmployeesXML(){
        Iterable<Employee> employeeIterable = this.employeeRepo.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList::add);
        return new EmployeeXMLList(employeeList);
    }

    @PostMapping(value = "/v1/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeRepo.save(employee);
        return "employee";
    }

    @DeleteMapping(value = "/v1/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        Employee employee = this.employeeRepo.findById(id).orElse(null);
        if(employee == null)
            return null;
        this.employeeRepo.delete(employee);
        return "department";
    }

}
