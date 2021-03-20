package com.daycare.demo.demo.Service;

import com.daycare.demo.demo.Model.Contact;
import com.daycare.demo.demo.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repo;

    public List<Contact> listAll() {
        return repo.findAll();
    }
    public void save (Contact contact) {repo.save(contact);}

    public Contact get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) { repo.deleteById(id);}
}
