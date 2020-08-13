package com.example.employeemeeting.repository;

import com.example.employeemeeting.entity.EmployeesInMeetingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeesInMeetingRepository extends JpaRepository<EmployeesInMeetingDetails, Long> {

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "update EMPLOYEES_IN_MEETING_DETAILS set present=false where EMPLOYEE_ID=?1 AND MEETING_ID=?2", nativeQuery = true)
    void leftMeet(Long employeeId, Long meetingId);

    @Query(value = "select EMPLOYEE_ID from EMPLOYEES_IN_MEETING_DETAILS WHERE MEETING_ID=?1", nativeQuery = true)
    Long[] findAllInMeeting(Long meetingId);

    @Query(value = "select MEETING_ID from EMPLOYEES_IN_MEETING_DETAILS WHERE EMPLOYEE_ID=?1", nativeQuery = true)
    Long[] findAllFromMeeting(Long employeeId);
}