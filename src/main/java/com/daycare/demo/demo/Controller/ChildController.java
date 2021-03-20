package com.daycare.demo.demo.Controller;

import com.daycare.demo.demo.Model.Child;
import com.daycare.demo.demo.Service.ChildService;
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
public class ChildController {
    @Autowired
    private ChildService CHservice;

    @RequestMapping("/children")
    public String viewHomePage(Model model){
        List<Child> listChildren = CHservice.listAll();
        model.addAttribute("listChildren", listChildren);
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

    @RequestMapping("/edit_child_info/{id}")
    public ModelAndView showEditChildForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("child/edit_child_info");
        Child child = CHservice.get(id);
        modelAndView.addObject("child", child);
        return modelAndView;
    }

    @RequestMapping("/remove/child/{id}")
    public String removeChild(@PathVariable(name = "id") Long id){
        CHservice.delete(id);
        return "redirect:/children";
    }

}
