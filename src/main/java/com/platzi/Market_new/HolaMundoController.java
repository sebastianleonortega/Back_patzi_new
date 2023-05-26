package com.platzi.Market_new;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sal")
public class HolaMundoController {

    @GetMapping("/udar")
    public String saludar(){
        return  ":3";
    }
}
