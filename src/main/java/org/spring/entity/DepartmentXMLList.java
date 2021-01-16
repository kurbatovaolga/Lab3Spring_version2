package org.spring.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "departments")
public class DepartmentXMLList {
    @XmlElement
    List<Department> department = new ArrayList<>();

    public DepartmentXMLList() {
    }

    public DepartmentXMLList(List<Department> departments) { this.department = departments;}

    public List<Department> getAllDepartments() { return department; }
}
