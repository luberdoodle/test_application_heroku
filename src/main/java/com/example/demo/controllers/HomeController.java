package com.example.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Song;
import com.example.demo.service.MampService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Autowired
    private MampService service;
    
    @GetMapping("/")
    public String home(Model model) {
        logger.info("Routing to /");
        List<Song> songs = service.getAll();
        model.addAttribute("songs", songs);
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id, Model model) {
        logger.info("Routing to /delete/{id}");
        service.deleteSong(id);
        return "deleted";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        logger.info("routing to /edit/{id}");
        Song song = service.getById(id);
        model.addAttribute("song", song);
        return "edit";
    }
    
    @PostMapping("/editSuccess/{id}")
    public String editSong(@PathVariable Long id, @ModelAttribute Song song) {
        logger.info("routing to /editSuccess/{id}");
        service.editSong(song);
        return "editSuccess";
    }
    
    

}