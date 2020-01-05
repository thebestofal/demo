package com.example.demo;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Food;
import com.example.demo.domain.FoodDetails;
import com.example.demo.service.AnimalService;
import com.example.demo.service.FoodDetailsService;
import com.example.demo.service.FoodService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	AnimalService animalService;
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	FoodDetailsService foodDetailsService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void animalCrudTest()
	{
		Animal a1 = new Animal("Mustang", "1990-01-01", 100.0);
		animalService.save(a1);
		Animal a12 = new Animal("Mustang", "1990-01-01", 200.0);
		Animal a2 = new Animal("Fenek",  "2000-10-10", 10.0);
		Animal a3 = new Animal("Fenek",  "2000-10-10", 10.0);
		animalService.save(a1);
		animalService.save(a2);
		animalService.save(a3);
		
		animalService.update((long) 1, a12);
		animalService.delete((long)3);
		for(Animal a : animalService.listAll())
		{
			System.out.println(a.toString());
		}
	}
	
	@Test
	void foodCrudTest()
	{
		Food f1 = new Food("siano", "2020-02-20", 200.0);
		Food f2 = new Food("ryby", "2020-01-10", 10.0);
		Food f3 = new Food("pasza", "2020-03-05", 242.0);
		foodService.save(f1);
		foodService.save(f2);
		foodService.save(f3);
		
		foodService.update((long)2, new Food("ryby", "2020-01-10", 20.0));
		
		foodService.listAll().forEach(System.out::println);
		
		foodService.delete((long)3);
		foodService.listAll().forEach(System.out::println);
	}
	
	@Test
	void foodDetailsCrudTest()
	{
		FoodDetails fd1 = new FoodDetails(animalService.findById((long)1),foodService.findById((long)1),2.5);
		FoodDetails fd2 = new FoodDetails(animalService.findById((long)2),foodService.findById((long)2),3.7);
		foodDetailsService.save(fd1);
		foodDetailsService.save(fd2);
		
		foodDetailsService.listAll().forEach(System.out::println);
	}
	
	@Test
	void queryTest()
	{
		List<Animal> a = animalService.findYoungAnimal();
		a.forEach(System.out::println);
	}
	
	@Test
	void parameterQueryTest()
	{
		List<Animal> a = animalService.findAnimalByAge("2000-01-01");
		a.forEach(System.out::println);
	}

}
