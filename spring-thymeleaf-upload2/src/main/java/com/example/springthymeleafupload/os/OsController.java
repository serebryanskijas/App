package com.example.springthymeleafupload.os;

import com.example.springthymeleafupload.firm.Firm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OsController {
    @Autowired
    private OsService osService;

    @GetMapping(value="/add_os")
    public String addOs(Model model){
        model.addAttribute("os",new Os());
        return "add_os";
    }

    @PostMapping(value="/save_os")
    public String saveOs(Os os, Model model){
        System.out.println(os);
        osService.save(os);
        model.addAttribute("os", osService.findAll());
        return "redirect:list_os";
    }

    @RequestMapping(value="/delete_os", method = RequestMethod.GET)
    public String deleteOs(@RequestParam(name="id") Long id){
        System.out.println("delete");
        osService.deleteById(id);
        return "redirect:/list_os";
    }

    @GetMapping(value="/list_os")
    public String listOs(Model model){
        model.addAttribute("os", osService.findAll());
        return "list_os";
    }

    @GetMapping(value="/edit_os")
    public String editOs(Model model, @RequestParam(name="id") Long id){
        Os os = osService.findById(id);
        model.addAttribute("os",os);
        return "edit_os";
    }

    @PostMapping(value="/edit_os")
    public String editOs(Os os, Model model){
        Os osDb = osService.findById(os.getId());
        osDb.setName(os.getName());
        osDb.setDeveloper(os.getDeveloper());
        osService.save(osDb);
        model.addAttribute("os", osService.findAll());
        return "redirect:list_os";
    }
}
