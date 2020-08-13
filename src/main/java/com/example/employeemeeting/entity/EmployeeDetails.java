package com.example.employeemeeting.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true)
@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial", name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
}