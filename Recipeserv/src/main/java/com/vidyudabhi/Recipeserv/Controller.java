package com.vidyudabhi.Recipeserv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("recipes")
    public String rm(){
        return "Recipe service";
    }
}