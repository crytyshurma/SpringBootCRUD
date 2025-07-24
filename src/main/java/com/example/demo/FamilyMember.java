package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;


@Entity
public class FamilyMember {

    @Id
    @GeneratedValue
    private Long id; // <-- Correct primary key

    @NotBlank(message = "Name is required")
    private String name;
    @Min(value=0,message="Age must be at least 0")
    private int age;
    private double weight;
    private String gender;

    public FamilyMember() {}

    // Constructor without ID (as it's auto-generated)
    public FamilyMember(String name, int age, double weight, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }
    // ✅ Setters — add these to fix the error
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
