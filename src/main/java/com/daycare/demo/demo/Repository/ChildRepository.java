package com.daycare.demo.demo.Repository;

import com.daycare.demo.demo.Model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
    // JPA repository class has various methods, so we do not need to create them here
    // we implement interface to use them

    // encapsulate things here, expose in service

    // should check the data before I call DB
}
