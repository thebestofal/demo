package com.example.demo.service;

import com.example.demo.domain.FoodDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDetailsRepository extends JpaRepository<FoodDetails, Long>
{
}
