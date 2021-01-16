package org.spring.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="employees")
public class EmployeeXMLList {
    @XmlElement
    List<Employee> employee = new ArrayList<>();

    public EmployeeXMLList(){}

    public EmployeeXMLList(List<Employee> employees){this.employee = employees;}

    public List<Employee> getAllEmployees(){return this.employee;}
}
