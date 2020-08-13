package com.example.employeemeeting.service.impl;

import com.example.employeemeeting.entity.EmployeeDetails;
import com.example.employeemeeting.entity.EmployeesInMeetingDetails;
import com.example.employeemeeting.entity.MeetingDetails;
import com.example.employeemeeting.repository.EmployeesInMeetingRepository;
import com.example.employeemeeting.repository.EmployeeRepository;
import com.example.employeemeeting.repository.MeetingRepository;
import com.example.employeemeeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    EmployeesInMeetingRepository employeesInMeetingRepository;

    @Override
    public void createMeet(MeetingDetails meetingDetails) {
        meetingRepository.save(meetingDetails);
    }

    @Override
    public void joinMeet(Long employeeId, Long meetingId) {
        Optional<MeetingDetails> meetingDetails = meetingRepository.findById(meetingId);

        if(meetingDetails.isPresent()) {
//            meetingDetails.get().getCurrentEmployees().add(employeeId);
//            meetingDetails.get().getAllEmployees().add(employeeId);
//
//            meetingRepository.joinMeeting(meetingId, meetingDetails.get().getCurrentEmployees(), meetingDetails.get().getAllEmployees());
            EmployeesInMeetingDetails employeesInMeetingDetails = new EmployeesInMeetingDetails();
            employeesInMeetingDetails.setEmployeeId(employeeId);
            employeesInMeetingDetails.setMeetingId(meetingId);
            employeesInMeetingDetails.setPresent(true);
            employeesInMeetingRepository.save(employeesInMeetingDetails);
        }

    }

    @Override
    public void leaveMeet(Long employeeId, Long meetingId) {
        Optional<MeetingDetails> meetingDetails= meetingRepository.findById(meetingId);
        if(meetingDetails.isPresent()){
//            meetingDetails.get().getCurrentEmployees().remove(employeeId);
//            meetingRepository.leaveMeeting(meetingId, meetingDetails.get().getCurrentEmployees());
            employeesInMeetingRepository.leftMeet(employeeId, meetingId);
        }
    }

    @Override
    public EmployeeDetails[] getEmployeesDetailsFromMeeting(Long meetingId) {
        /*
        Optional<MeetingDetails> meetingDetails = meetingRepository.findById(meetingId);
        EmployeeDetails[] employeeDetails = {};
        ArrayList<EmployeeDetails> toBeReturned = new ArrayList<EmployeeDetails>();
        if(meetingDetails.isPresent()){
            for (Long employeeId:meetingDetails.get().getAllEmployees()) {
                String stringToConvert = String.valueOf(empId);
                Long employeeId = Long.parseLong(stringToConvert);
                toBeReturned.add(employeeRepository.getEmployeesDetails(employeeId));
            }
        }
        return toBeReturned.toArray(new EmployeeDetails[0]);

         */
        Optional<MeetingDetails> meetingDetails = meetingRepository.findById(meetingId);
        ArrayList<EmployeeDetails> toBeReturned = new ArrayList();
        if(meetingDetails.isPresent()){
            Long[] list = employeesInMeetingRepository.findAllInMeeting(meetingId);
            for(Long employeeId:list){
                toBeReturned.add(employeeRepository.findById(employeeId).get());
            }
        }
        return toBeReturned.toArray(new EmployeeDetails[0]);
    }

    @Override
    public MeetingDetails[] getMeetingDetailsFromEmployee(Long employeeId) {
        /*
        MeetingDetails[] meetingDetails = meetingRepository.getAllMeetings();
        ArrayList<MeetingDetails> toBeReturned = new ArrayList<MeetingDetails>();
        for(MeetingDetails meet:meetingDetails){
            if(meet.getAllEmployees().contains(employeeId)){
                toBeReturned.add(meet);
            }
        }
        return toBeReturned.toArray(new MeetingDetails[0]);
        */

        Long[] list = employeesInMeetingRepository.findAllFromMeeting(employeeId);
        ArrayList<MeetingDetails> toBeReturned = new ArrayList<>();
        for (Long meetingId: list){
            toBeReturned.add(meetingRepository.findById(meetingId).get());
        }
        return toBeReturned.toArray(new MeetingDetails[0]);
    }
}