package com.example.demo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.Song;
import com.example.demo.service.MampService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CreateController {
    private static final Logger logger = LogManager.getLogger(CreateController.class);

    @Autowired
    private MampService service;
    
    @GetMapping("/create")
    public String create(Model model) {
        logger.info("Routing to /create");
        model.addAttribute("formData", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String submitForm(Song song) {
        logger.info("Post to /create");
        service.createSong(song);
        return "success";
    }
    

}
