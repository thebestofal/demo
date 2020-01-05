package com.example.demo.service;

import com.example.demo.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>
{
    @Query("SELECT a FROM Animal a WHERE a.rokUrodzenia > '2000-01-01'")
    List<Animal> findYoungAnimal();
    
    @Query("SELECT a FROM Animal a WHERE a.rokUrodzenia > CONCAT(:parameter, '%')")
    List<Animal> findAnimalByAge(@Param("parameter") String date);
    
    //List<Animal>
}
