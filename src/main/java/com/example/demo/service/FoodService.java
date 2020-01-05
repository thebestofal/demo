package com.example.demo.service;

import com.example.demo.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQueries;
import java.util.List;

@Service
public class FoodService
{
    @Autowired
    private FoodRepository foodRepository;
    
    public List<Food> listAll() {return foodRepository.findAll();}
    
    //create
    public void save(Food food) {foodRepository.save(food);}
    
    //read
    public Food findById(Long id) {return foodRepository.findById(id).get();}
    
    //update
    public void update(Long id, Food food)
    {
        Food temp = findById(id);
        temp.setId(id);
        temp.setNazwa(food.getNazwa());
        temp.setDataWaznosci(food.getDataWaznosci());
        temp.setIlosc(food.getIlosc());
        foodRepository.save(temp);
    }
    
    //delete
    //@Transactional
    public void delete(Long id) {foodRepository.deleteById(id);}
    
}
