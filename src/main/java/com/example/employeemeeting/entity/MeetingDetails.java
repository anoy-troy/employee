package com.example.employeemeeting.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true)
@Entity
@Table(name = "MEETING_DETAILS")
public class MeetingDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial", name = "MEETING_ID")
    private Long meetingId;

    @Column(name = "MEETING_NAME")
    private String meetingName;

//    @Column(name = "CURRENT_EMPLOYEES")
//    @ElementCollection
//    private ArrayList<Long> currentEmployees;
//
//    @Column(name = "ALL_EMPLOYEES")
//    @ElementCollection
//    private ArrayList<Long> allEmployees;

    @Column(name = "START_TIME")
    private Timestamp startTime;

    @Column(name = "END_TIME")
    private Timestamp endTime;

    @Column(name = "CREATED_ON")
    private Timestamp createdOn;
}
