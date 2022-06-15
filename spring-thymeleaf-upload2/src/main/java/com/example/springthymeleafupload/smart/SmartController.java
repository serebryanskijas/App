package com.example.springthymeleafupload.smart;

import com.example.springthymeleafupload.firm.Firm;
import com.example.springthymeleafupload.firm.FirmService;
import com.example.springthymeleafupload.os.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SmartController {
    @Autowired
    private SmartService smartService;
    @Autowired
    private FirmService firmService;
    @Autowired
    private OsService osService;

    @GetMapping(value="/add_smart")
    public String addSmart(Model model){
        model.addAttribute("smart",new Smart());
        model.addAttribute("firms",firmService.findAll());
        model.addAttribute("os",osService.findAll());
        return "add_smart";
    }

    @PostMapping(value="/save_smart")
    public String saveSmart(Smart smart, Model model){
        System.out.println(smart);
        smartService.save(smart);
        model.addAttribute("smarts", smartService.findAll());
        return "redirect:list_smarts";
    }

    @RequestMapping(value="/delete_smart", method = RequestMethod.GET)
    public String deleteSmart(@RequestParam(name="id") Long id){
        System.out.println("delete");
        smartService.deleteById(id);
        return "redirect:/list_smarts";
    }

    @GetMapping(value="/list_smarts")
    public String listSmart(Model model){
        model.addAttribute("smarts",smartService.findAll());
        return "list_smarts";
    }

    @GetMapping(value="/edit_smart")
    public String editSmart(Model model, @RequestParam(name="id") Long id){
        Smart smart = smartService.findById(id);
        model.addAttribute("smart",smart);
        model.addAttribute("firms",firmService.findAll());
        model.addAttribute("os",osService.findAll());
        return "edit_smart";
    }

    @PostMapping(value="/edit_smart")
    public String editSmart(Smart smart, Model model){
        Smart smartDb = smartService.findById(smart.getId());
        smartDb.setName(smart.getName());
        smartDb.setFirm(smart.getFirm());
        smartDb.setOs(smart.getOs());
        smartDb.setColor(smart.getColor());
        smartDb.setSize(smart.getSize());
        smartService.save(smartDb);
        model.addAttribute("smarts", smartService.findAll());
        return "redirect:list_smarts";
    }
}
