package com.example.demo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;
    
    @Column(name = "nazwa")
    String nazwa;
    
    @Column(name ="dataWaznosci")
    String dataWaznosci;
    
    @Column(name = "ilosc")
    Double ilosc;
    
    @OneToMany(mappedBy = "food")
    Set<FoodDetails> details;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getNazwa()
    {
        return nazwa;
    }
    
    public void setNazwa(String nazwa)
    {
        this.nazwa = nazwa;
    }
    
    public String getDataWaznosci()
    {
        return dataWaznosci;
    }
    
    public void setDataWaznosci(String dataWaznosci)
    {
        this.dataWaznosci = dataWaznosci;
    }
    
    public Double getIlosc()
    {
        return ilosc;
    }
    
    public void setIlosc(Double ilosc)
    {
        this.ilosc = ilosc;
    }
    
    public Set<FoodDetails> getDetails()
    {
        return details;
    }
    
    public void setDetails(Set<FoodDetails> details)
    {
        this.details = details;
    }
    
    public Food(Long id, String nazwa, String dataWaznosci, Double ilosc)
    {
        this.id = id;
        this.nazwa = nazwa;
        this.dataWaznosci = dataWaznosci;
        this.ilosc = ilosc;
    }
    
    public Food(){}
    public Food(String nazwa, String dataWaznosci, Double ilosc)
    {
        this.nazwa = nazwa;
        this.dataWaznosci = dataWaznosci;
        this.ilosc = ilosc;
    }
    
    @Override
    public String toString()
    {
        return "Food{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", dataWaznosci='" + dataWaznosci + '\'' +
                ", ilosc=" + ilosc +
                '}';
    }
}
