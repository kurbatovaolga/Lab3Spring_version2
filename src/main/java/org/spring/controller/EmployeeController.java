package org.spring.controller;


import org.spring.entity.Employee;
import org.spring.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public Iterable<Employee> getAllEmployees(Model model){
        Iterable<Employee> employees = this.employeeRepo.findAll();
        model.addAttribute("employees",employees);
        return employees;
    }
}
