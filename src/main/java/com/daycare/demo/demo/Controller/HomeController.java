package com.daycare.demo.demo.Controller;

import com.daycare.demo.demo.Model.Activity;
import com.daycare.demo.demo.Model.Child;
import com.daycare.demo.demo.Model.Contact;
import com.daycare.demo.demo.Service.ActivityService;
import com.daycare.demo.demo.Service.ChildService;
import com.daycare.demo.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ChildService CHservice;
    @Autowired
    private ActivityService ACservice;
    @Autowired
    private ContactService COservice;


    @GetMapping("/")
    public String Home() { return "index"; }

    // CHILD
    @RequestMapping("/children")
    public String viewHomePage(Model model){
        List<Child> listChildren = CHservice.listAll();
        model.addAttribute("listChildren", listChildren); // model attribute string needs to go into thymeleaf
        return "child/child";
    }

    @RequestMapping("/child/new_child")
    public String showNewChildForm(Model model){
        Child child = new Child();
        model.addAttribute("child", child);
        return "child/new_child";
    }

    @RequestMapping(value = "/save_child", method = RequestMethod.POST)
    public String saveChild(@ModelAttribute("child") Child child){
        CHservice.save(child);
        return "redirect:/children";
    }

    @RequestMapping("/edit_child_info{id}")
    public ModelAndView showEditChildForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("child/edit_child_info");
        Child child = CHservice.get(id);
        modelAndView.addObject("child", child);
        return modelAndView;
    }

    @RequestMapping("/remove/child_{id}")
    public String removeChild(@PathVariable(name = "id") Long id){
        CHservice.delete(id);
        return "redirect:/children";
    }

    // ACITVITY
    @RequestMapping("/activities") // CHANGE
    public String viewActivityPage(Model model){
        List<Activity> listActivities = ACservice.listAll();
        model.addAttribute("listActivities", listActivities); // model attribute string needs to go into thymeleaf
        return "activity"; // CHANGE
    }

    @RequestMapping("/new_activity")
    public String showNewActivityForm(Model model){
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "new_activity";
    }

    @RequestMapping(value = "/save_activity", method = RequestMethod.POST)
    public String saveActivity(@ModelAttribute("activity") Activity activity){
        ACservice.save(activity);
        return "redirect:/activities"; // change landing page
    }

    @RequestMapping("/edit_activity/{id}")
    public ModelAndView showNewAcivityForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_activity_info");
        Activity activity = ACservice.get(id);
        modelAndView.addObject("activity", activity);
        return modelAndView;
    }

    @RequestMapping("/remove_activity/{id}")
    public String removeActivity(@PathVariable(name = "id") Long id){
        ACservice.delete(id);
        return "redirect:/activities"; // change landing page for activity an child separate?
    }
    // Contact
    @RequestMapping("/contacts") // CHANGE
    public String viewContactsPage(Model model){
        List<Contact> listContacts = COservice.listAll();
        model.addAttribute("listContact", listContacts); // model attribute string needs to go into thymeleafcontact_Phone_Number
        return "contact"; // CHANGE
    }

    @RequestMapping("/new_contact")
    public String showNewContactForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "new_contact";
    }

    @RequestMapping(value = "/save_contact", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact){
        COservice.save(contact);
        return "redirect:/contacts"; // change landing page
    }

    @RequestMapping("/edit_contact/{id}")
    public ModelAndView showNewContactForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_contact_info");
        Contact contact = COservice.get(id);
        modelAndView.addObject("contact", contact);
        return modelAndView;
    }

    @RequestMapping("/remove_contact/{id}")
    public String removeContact(@PathVariable(name = "id") Long id){
        COservice.delete(id);
        return "redirect:/contacts"; // change landing page for activity an child separate?
    }
}
