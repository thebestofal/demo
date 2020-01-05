package com.example.demo.service;

import com.example.demo.domain.FoodDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDetailsService
{
    @Autowired
    private FoodDetailsRepository foodDetailsRepository;
    
    public List<FoodDetails> listAll(){return foodDetailsRepository.findAll();}
    
    //create
    public void save(FoodDetails fd){foodDetailsRepository.save(fd);}
    
    //read
    public FoodDetails findById(Long id){return foodDetailsRepository.findById(id).get();}
    
    //update
    public void update(Long id, FoodDetails fd)
    {
        FoodDetails temp = findById(id);
        temp.setId(id);
        temp.setAnimal(fd.getAnimal());
        temp.setFood(fd.getFood());
        foodDetailsRepository.save(temp);
    }
    
    //delete
    public void delete(Long id){foodDetailsRepository.deleteById(id);}
}
