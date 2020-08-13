package com.example.employeemeeting.service.impl;

import com.example.employeemeeting.entity.EmployeeDetails;
import com.example.employeemeeting.repository.EmployeeRepository;
import com.example.employeemeeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(EmployeeDetails employeeDetails){
        employeeRepository.save(employeeDetails);
    }
}