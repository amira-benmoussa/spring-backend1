package com.elcom.flux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elcom.flux.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer > {

}
