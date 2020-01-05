package com.example.demo.domain;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Animal")
@NamedQueries({

})
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;
    @Column(name = "imie")
    String imie;
    @Column(name = "rokUrodzenia")
    String rokUrodzenia;
    @Column(name = "waga")
    Double waga;
    
    @OneToMany(mappedBy = "animal")
    Set<FoodDetails> details;
    
    public Animal()
    {
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getImie()
    {
        return imie;
    }
    
    public void setImie(String imie)
    {
        this.imie = imie;
    }
    
    public String getRokUrodzenia()
    {
        return rokUrodzenia;
    }
    
    public void setRokUrodzenia(String rokUrodzenia)
    {
        this.rokUrodzenia = rokUrodzenia;
    }
    
    public Double getWaga()
    {
        return waga;
    }
    
    public void setWaga(Double waga)
    {
        this.waga = waga;
    }
    
    public Set<FoodDetails> getDetails()
    {
        return details;
    }
    
    public void setDetails(Set<FoodDetails> details)
    {
        this.details = details;
    }
    
    public Animal(Long id, String imie, String rokUrodzenia, Double waga)
    {
        this.id = id;
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
        this.waga = waga;
    }
    
    public Animal(String imie, String rokUrodzenia, Double waga)
    {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
        this.waga = waga;
    }
    
    @Override
    public String toString()
    {
        return "Animal{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", rokUrodzenia='" + rokUrodzenia + '\'' +
                ", waga=" + waga +
                '}';
    }
}
