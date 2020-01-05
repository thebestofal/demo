package com.example.demo.service;

import com.example.demo.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService
{
    @Autowired
    private AnimalRepository animalRepository;
    
    public List<Animal> listAll()
    {
        return animalRepository.findAll();
    }
    
    //create
    public void save(Animal animal)
    {
        animalRepository.save(animal);
    }
    
    //read
    public Animal findById(Long id)
    {
        return animalRepository.findById(id).get();
    }
    
    public void update(Long id, Animal animal)
    {
        Animal temp = findById(id);
        temp.setId(id);
        temp.setImie(animal.getImie());
        temp.setRokUrodzenia(animal.getRokUrodzenia());
        temp.setWaga(animal.getWaga());
        animalRepository.save(temp);
    }
    //delete
    public void delete(Long id)
    {
        animalRepository.deleteById(id);
    }
    
    public List<Animal> findYoungAnimal()
    {
        return animalRepository.findYoungAnimal();
    }
    
    public List<Animal> findAnimalByAge(String date)
    {
        return animalRepository.findAnimalByAge(date);
    }
}
