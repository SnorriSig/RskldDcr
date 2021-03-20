package com.daycare.demo.demo.Service;

import com.daycare.demo.demo.Model.Child;
import com.daycare.demo.demo.Repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// gathering things here. should just take things from repo and share with controlled.
// not a good idea to contact repo directly from controller

@Service
public class ChildService {
    @Autowired
    private ChildRepository repo; // link to the database

    public List<Child> listAll(){
        return repo.findAll(); // methods from the interface!
    }

    public void save(Child child){
        repo.save(child);
    }

    public Child get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }



}
