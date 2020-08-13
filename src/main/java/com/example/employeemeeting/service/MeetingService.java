package com.example.employeemeeting.service;

import com.example.employeemeeting.entity.EmployeeDetails;
import com.example.employeemeeting.entity.MeetingDetails;

public interface MeetingService {
    void createMeet(MeetingDetails meetingDetails);
    void joinMeet(Long employeeId, Long meetingId);
    void leaveMeet(Long employeeId, Long meetingId);
    EmployeeDetails[] getEmployeesDetailsFromMeeting(Long meetingId);
    MeetingDetails[] getMeetingDetailsFromEmployee(Long employeeId);
}