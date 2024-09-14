package com.vidyudabhi.Recipeserv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rserv")
public class Controller {
    @GetMapping("recipes")
    public String rm(){
        return "Recipe service";
    }
}