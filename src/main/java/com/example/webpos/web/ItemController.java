package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ItemController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }


    @GetMapping("/item/delete/{ProductId}")
    public String delete(Model model, @PathVariable String ProductId) {

        if (posService.delete(ProductId)){
            return  "redirect:/";
        }
        model.addAttribute("errorMessage", "item not found");
        return "error";
    }

    @GetMapping("/item/add/{ProductId}")
    public String add(Model model, @PathVariable String ProductId) {
        if (posService.add(ProductId, 1)) {
            return  "redirect:/";
        }
        model.addAttribute("errorMessage", "unexpected");
        return "error";
    }

    @PostMapping("/item/modify/{ProductId}")
    @ResponseBody
    public Map<String, String> modify(@RequestBody(required = true) Map<String, Object> data, @PathVariable String ProductId) {
        Map<String, String> rep = new LinkedHashMap<>();
        if (data.get("quantity") instanceof Integer) {
            int quantity = (Integer) data.get("quantity");
            if (posService.modify(ProductId, quantity)) {
                rep.put("success", "1");
            } else
                rep.put("success", "0");
        } else {
            rep.put("success", "0");
            rep.put("message", "格式错误");
        }
        return rep;
    }

    @GetMapping("/item/empty")
    public String empty(Model model) {
        if (posService.empty()) {
            return "redirect:/charge";
        }
        model.addAttribute("errorMessage", "empty fail");
        return "error";
    }

}
