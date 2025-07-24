package com.example.demo;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    // JpaRepository gives you all basic CRUD methods
    List<FamilyMember> findByGenderIgnoreCase(String gender);
List<FamilyMember> findByNameContainingIgnoreCase(String name);
List<FamilyMember> findByAgeGreaterThan(int age);

}

