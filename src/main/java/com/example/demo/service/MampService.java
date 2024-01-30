package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Song;
import com.example.demo.repositories.MampEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class MampService {
    
    private static final Logger logger = LogManager.getLogger(MampService.class);
    
    @Autowired
    private MampEntityRepository repository;

    public List<Song> getAll() {
        List<Song> songs = repository.findAll();
        logger.info("Get All Songs");
        return songs;
    }

    public void createSong(Song song) {
        logger.info("Create New Song");
        repository.saveAndFlush(song);
    }

    public void deleteSong(Long id) {
        logger.info("Delete Song by Id");
        repository.deleteById(id);
    }

    public void editSong(Song song) {
        logger.info("Edit Song");
        repository.save(song);
    }

    public Song getById(Long id) {
        logger.info("Get Song By Id");
        return repository.findById(id).get();
    }

}
