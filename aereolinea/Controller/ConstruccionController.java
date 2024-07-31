package com.springboot.aereolinea.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class ConstruccionController {
    @RequestMapping(value ="/construccion")
    public String notifyConstruccion() { return "construccion";}
}
