package org.spring.controller;


import org.spring.entity.Department;
import org.spring.entity.DepartmentXMLList;
import org.spring.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments/")
public class DepartmentRestController {

    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping(value = "/v1")
    public Iterable<Department> getAllDepartments(){
        return this.departmentRepo.findAll();
    }

    @GetMapping(value = "/v2")
    public DepartmentXMLList getAllDepartmentXML(){
        Iterable<Department> departmentIterable = this.departmentRepo.findAll();
        List<Department> departmentList = new ArrayList<>();
        departmentIterable.forEach(departmentList::add);
        return new DepartmentXMLList(departmentList);
    }

    @PostMapping(value = "/v1/add")
    public String addDepartment(@ModelAttribute("department") Department department){
        departmentRepo.save(department);
        return "department";
    }

    @DeleteMapping(value = "/v1/remove/{id}")
    public String removeDepartment(@PathVariable("id") int id){
        Department department = this.departmentRepo.findById(id).orElse(null);
        if(department == null)
            return null;
        this.departmentRepo.delete(department);
        return "department";
    }

}
