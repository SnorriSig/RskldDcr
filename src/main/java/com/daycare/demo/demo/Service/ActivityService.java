package com.daycare.demo.demo.Service;

import com.daycare.demo.demo.Model.Activity;
import com.daycare.demo.demo.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repo; // link to the database

    public List<Activity> listAll(){
        return repo.findAll(); // methods from the interface!
    }

    public void save(Activity activity){
        repo.save(activity);
    }

    public Activity get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}
