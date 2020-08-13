package com.example.employeemeeting.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true)
@Entity
@IdClass(EmployeesInMeetingDetails.class)
public class EmployeesInMeetingDetails implements Serializable {
    @Id
    private Long meetingId;
    @Id
    private Long employeeId;
    private boolean present;
}