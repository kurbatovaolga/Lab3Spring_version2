package org.spring.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@Entity
@XmlRootElement(name="employees")
@Table(schema = "public", name = "employee")
public class Employee {
    private int id;
    private String fullName;
    private int age;
    private Department department;

    public Employee() {
    }

    @Id
    @Column(name = "id", nullable = false )
    public int getID() {
        return id;
    }

    @XmlElement
    public void setID(int id) {
        this.id = id;
    }

    @Column(name = "full_name", nullable = false, length = 50)
    public String getFullName() {
        return fullName;
    }

    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    @XmlElement
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(id, employee.id) &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
