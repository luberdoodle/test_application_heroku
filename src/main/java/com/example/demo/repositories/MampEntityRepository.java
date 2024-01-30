package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Song;

import jakarta.transaction.Transactional;
import java.util.List;


public interface MampEntityRepository extends JpaRepository <Song, Long>{


}
