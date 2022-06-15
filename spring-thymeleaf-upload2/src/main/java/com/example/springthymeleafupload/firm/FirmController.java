package com.example.springthymeleafupload.firm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirmController {
    @Autowired
    private FirmService firmService;

    @GetMapping(value="/add_firm")
    public String addFirm(Model model){
        model.addAttribute("firm",new Firm());
        return "add_firm";
    }

    @PostMapping(value="/save_firm")
    public String saveFirm(Firm firm, Model model){
        System.out.println(firm);
        firmService.save(firm);
        model.addAttribute("firms", firmService.findAll());
        return "redirect:list_firms";
    }

    @RequestMapping(value="/delete_firm", method = RequestMethod.GET)
    public String deleteFirm(@RequestParam(name="id") Long id){
        System.out.println("delete");
        firmService.deleteById(id);
        return "redirect:/list_firms";
    }

    @GetMapping(value="/list_firms")
    public String listFirm(Model model){
        model.addAttribute("firms",firmService.findAll());
        return "list_firms";
    }

    @GetMapping(value="/edit_firm")
    public String editFirm(Model model, @RequestParam(name="id") Long id){
        Firm firm = firmService.findById(id);
        model.addAttribute("firm",firm);
        return "edit_firm";
    }

    @PostMapping(value="/edit_firm")
    public String editFirm(Firm firm, Model model){
        Firm firmDb = firmService.findById(firm.getId());
        firmDb.setName(firm.getName());
        firmService.save(firmDb);
        model.addAttribute("firms", firmService.findAll());
        return "redirect:list_firms";
    }
}
