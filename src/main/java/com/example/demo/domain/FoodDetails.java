package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "food_details")
public class FoodDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;
    
    @ManyToOne
    @JoinColumn(name = "animalId")
    Animal animal;
    
    @ManyToOne
    @JoinColumn(name = "foodId")
    Food food;
    
    @Column(name = "ilosc")
    Double ilosc;
    
    public Animal getAnimal()
    {
        return animal;
    }
    
    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }
    
    public Food getFood()
    {
        return food;
    }
    
    public void setFood(Food food)
    {
        this.food = food;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public FoodDetails(Animal animal, Food food, Double ilosc)
    {
        this.animal = animal;
        this.food = food;
        this.ilosc = ilosc;
    }
    public FoodDetails(){}
    
    @Override
    public String toString()
    {
        return "FoodDetails{" +
                "id=" + id +
                ", animalId=" + animal.getId() +
                ", foodId=" + food.getId() +
                ", ilosc=" + ilosc +
                '}';
    }
}
