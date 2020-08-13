package com.example.employeemeeting.repository;

import com.example.employeemeeting.entity.MeetingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingDetails, Long> {

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "update MEETING_DETAILS set CURRENT_EMPLOYEES_LIST=?2 AND All_EMPLOYEES_LIST=?3 where MEETING_ID=?1", nativeQuery = true)
    void joinMeeting(Long meetingId, ArrayList<Long> currentEmployeesList, ArrayList<Long> allEmployeesList);

    /*
    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "insert into ALL_EMPLOYEES_LIST values(?1,?2)", nativeQuery = true)
    void joinMeet2(Long meetingId, Long employeeId);
    */

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "update MEETING_DETAILS set CURRENT_EMPLOYEES_LIST=?2 where MEETING_ID=?1", nativeQuery = true)
    void leaveMeeting(Long meetingId, ArrayList<Long> currentEmployeesList);

    /*
    @Query(value = "select * from MEETING_DETAILS", nativeQuery = true)
    MeetingDetails[] getAllMeetings();
    */
}