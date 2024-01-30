package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Song;


public interface MampEntityRepository extends JpaRepository <Song, Long> {


}
