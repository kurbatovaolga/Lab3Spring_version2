package org.spring.controller;

import org.spring.entity.Department;
import org.spring.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public Iterable<Department> getAllDepartments(Model model) {
        Iterable<Department> departments = this.departmentRepo.findAll();
        model.addAttribute("departments",departments);
        return departments;
    }
}
