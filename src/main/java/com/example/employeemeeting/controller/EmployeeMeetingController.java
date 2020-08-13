package com.example.employeemeeting.controller;

import com.example.employeemeeting.entity.EmployeeDetails;
import com.example.employeemeeting.entity.MeetingDetails;
import com.example.employeemeeting.service.EmployeeService;
import com.example.employeemeeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meet")
public class EmployeeMeetingController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public void addEmployee(@RequestBody EmployeeDetails employeeDetails){
        employeeService.addEmployee(employeeDetails);
    }

    @PostMapping("/create")
    public void createMeet(@RequestBody MeetingDetails meetingDetails){
        meetingService.createMeet(meetingDetails);
    }

    @PostMapping("/join")
    public void joinMeet(@RequestParam Long employeeId, @RequestParam Long meetingId){
        meetingService.joinMeet(employeeId, meetingId);
    }

    @PostMapping("/leave")
    public void leaveMeet(@RequestParam Long employeeId, @RequestParam Long meetingId ){
        meetingService.leaveMeet(employeeId, meetingId);
    }

    @GetMapping("/getemployeesdetails/{meetingId}")
    public EmployeeDetails[] getEmployeesDetailsFromMeeting(@PathVariable("meetingId") Long meetingId){
        return meetingService.getEmployeesDetailsFromMeeting(meetingId);
    }

    @GetMapping("/getmeetingdetails/{employeeId}")
    public MeetingDetails[] getMeetingDetailsFromMeeting(@PathVariable("employeeId") Long employeeId){
        return meetingService.getMeetingDetailsFromEmployee(employeeId);
    }
}