package com.daycare.demo.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Child {
    private Long childId;
    private String childFirstName;
    private String childLastName;
    private String childDoB;
    private Long teamId;
    private Long contactId;
    private int childStatus;


    public Child() {
        super();  // why like this??
    }

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    // child name
    public String getChildFirstName() {
        return childFirstName;
    }

    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }

    // child last name
    public String getChildLastName() {
        return childLastName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    // child date of birth
    public String getChildDoB() {
        return childDoB;
    }

    public void setChildDoB(String childDoB) {
        this.childDoB = childDoB;
    }

    // child team id
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    // child contact id
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    // child status
    public int getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(int childStatus) {
        this.childStatus = childStatus;
    }

}