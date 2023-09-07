package com.pilot.pilot.repository;

import com.pilot.pilot.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRep extends JpaRepository<Employee, Long> {

    //All CURD methods
}
