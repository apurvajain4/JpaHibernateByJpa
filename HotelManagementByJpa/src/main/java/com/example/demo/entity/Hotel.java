package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "employees") // Specifies the table name
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generates unique ID for each record
    private long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Hotel type cannot be empty")
    private String hoteltype;

    @NotBlank(message = "Quality cannot be empty")
    private String quality;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email cannot be empty")
    private String hotelEmail;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
        message = "Password must be 8-20 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character."
    )
    private String password;

    // Constructor using fields
    public Hotel(long id, String name, String hoteltype, String quality, String hotelEmail, String password) {
        this.id = id;
        this.name = name;
        this.hoteltype = hoteltype;
        this.quality = quality;
        this.hotelEmail = hotelEmail;
        this.password = password;
    }

    // Non-parameterized constructor
    public Hotel() {
        super();
    }

    // Getters and Setters
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

    public String getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(String hoteltype) {
        this.hoteltype = hoteltype;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", hoteltype=" + hoteltype + ", quality=" + quality + ", hotelEmail=" + hotelEmail + "]";
    }
}
