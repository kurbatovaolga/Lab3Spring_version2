package org.spring.repo;

import org.spring.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department,Integer> {
}
