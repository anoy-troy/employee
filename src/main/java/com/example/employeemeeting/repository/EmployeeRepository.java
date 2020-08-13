package com.example.employeemeeting.repository;

import com.example.employeemeeting.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {

    @Query(value = "select * from EMPLOYEE_DETAILS where EMPLOYEE_ID=?1", nativeQuery = true)
    EmployeeDetails getEmployeesDetails(Long employeeId);
}