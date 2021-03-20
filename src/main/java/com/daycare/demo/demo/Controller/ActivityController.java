package com.daycare.demo.demo.Controller;

import com.daycare.demo.demo.Model.Activity;
import com.daycare.demo.demo.Service.ActivityService;
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
public class ActivityController {

    @Autowired
    private ActivityService ACservice;

    @RequestMapping("/activities")
    public String viewActivityPage(Model model){
        List<Activity> listActivities = ACservice.listAll();
        model.addAttribute("listActivities", listActivities);
        return "activity/activity";
    }

    @RequestMapping("/activity/new_activity")
    public String showNewActivityForm(Model model){
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "activity/new_activity";
    }

    @RequestMapping(value = "/save_activity", method = RequestMethod.POST)
    public String saveActivity(@ModelAttribute("activity") Activity activity){
        ACservice.save(activity);
        return "redirect:/activities";
    }

    @RequestMapping("/edit_activity/{id}")
    public ModelAndView showNewAcivityForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("activity/edit_activity_info");
        Activity activity = ACservice.get(id);
        modelAndView.addObject("activity", activity);
        return modelAndView;
    }

    @RequestMapping("/remove_activity/{id}")
    public String removeActivity(@PathVariable(name = "id") Long id){
        ACservice.delete(id);
        return "redirect:/activities";
    }
}
