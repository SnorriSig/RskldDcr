package com.daycare.demo.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    private Long contactId;
    private String contactFirstName;
    private String contactLastName;
    private String contactPhoneNumber;
    private Long childId;

    public Contact() {
        super();  // why like this??
    }
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    // contact name
    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactName) {
        this.contactFirstName = contactName;
    }

    // contact last name
    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    // contact phone number
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    //child id
    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }
}