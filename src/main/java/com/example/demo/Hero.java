package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory") 
    private String name;

    /*SuperPower */
    @OneToMany(mappedBy = "hero")
    private List<Superpower> superpowers;
   

    public Hero() {
        super();
        this.superpowers = new ArrayList<Superpower>();
    }

    public Hero(String name, String[] superpowers) {
        this.name = name;
        this.superpowers = new ArrayList<Superpower>();
        for(String superpower : superpowers){
            Superpower superp = new Superpower(superpower);
            this.superpowers.add(superp);
        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Superpower> getSuperpowers() {
        return this.superpowers;
    }

    public void setSuperpowers(List<Superpower> superpowers) {
        this.superpowers = superpowers;
    }

   
}
