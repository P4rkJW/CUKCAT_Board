package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Welcome {

    @GetMapping("/")
    public String index(){
        return "welcome";
    }

    @GetMapping("/rank")
    public String rank(){
        return "board/rank";
    }

    @GetMapping("/write")
    public String write(){ return "board/test_write"; }

//    @PostMapping("/write_proc")
//    public String post(){
//
//    }
}
