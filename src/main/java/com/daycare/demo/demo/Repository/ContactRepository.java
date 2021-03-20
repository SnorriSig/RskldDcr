package com.daycare.demo.demo.Repository;

import com.daycare.demo.demo.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
