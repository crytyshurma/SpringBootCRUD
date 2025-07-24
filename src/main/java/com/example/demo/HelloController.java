package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private FamilyMemberRepository repository;

    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is a Spring Boot demo app.";
    }

    @GetMapping("/family")
    public List<FamilyMember> getFamily() {
        return repository.findAll();
    }

    @PostMapping("/add-member")
    public String addMember(@Valid@RequestBody FamilyMember member) {
        repository.save(member);
        return "Added: " + member.getName();
    }

    @DeleteMapping("/delete-member/{id}")
    public String deleteMember(@PathVariable Long id) {
        Optional<FamilyMember> member = repository.findById(id);
        if (member.isPresent()) {
            repository.deleteById(id);
            return "Deleted member with ID: " + id;
        } else {
            return "Member not found with ID: " + id;
        }
    }
    @PutMapping("/update-member/{id}")
public String updateMember(@PathVariable Long id,@Valid @RequestBody FamilyMember updated) {
    return repository.findById(id).map(member -> {
        member.setName(updated.getName());
        member.setAge(updated.getAge());
        member.setWeight(updated.getWeight());
        member.setGender(updated.getGender());
        repository.save(member);
        return "Updated member: " + member.getName();
    }).orElse("Member not found");
}
@GetMapping("/family/paginated")
public Page<FamilyMember> getPaginatedFamily(Pageable pageable) {
    return repository.findAll(pageable);
}
@GetMapping("/family/search")
public List<FamilyMember> searchByGender(@RequestParam String gender) {
    return repository.findByGenderIgnoreCase(gender);
}

// Add this method at the bottom of HelloController

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
}

}
