package com.daycare.demo.demo.Controller;

import com.daycare.demo.demo.Model.Contact;
import com.daycare.demo.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController {


    @Autowired
    private ContactService COservice;

    @RequestMapping("/contacts")
    public String viewContactsPage(Model model){
        List<Contact> listContacts = COservice.listAll();
        model.addAttribute("listContacts", listContacts);
        return "contact/contact";
    }

    @RequestMapping("/contact/new_contact")
    public String showNewContactForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact/new_contact";
    }

    @RequestMapping(value = "/save_contact", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact){
        COservice.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("/edit_contact/{id}")
    public ModelAndView showNewContactForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/contact/edit_contact_info");
        Contact contact = COservice.get(id);
        modelAndView.addObject("contact", contact);
        return modelAndView;
    }

    @RequestMapping("/remove_contact/{id}")
    public String removeContact(@PathVariable(name = "id") Long id){
        COservice.delete(id);
        return "redirect:/contacts";
    }
}

