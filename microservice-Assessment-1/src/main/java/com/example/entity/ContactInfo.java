package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_contactinfo")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Field must be alphanumeric")
    private String FirstName;
    
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Field must be alphanumeric")
    private String LastName;
    
    @Email(message = "Email should be valid")
    private String Email;
    
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid and include only digits, optionally starting with '+'")
    private String PhoneNumber;
    
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;
    
}