package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Get all hotels
    @GetMapping
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotel();
    }

    // Create a new hotel
    @PostMapping
    
    /* whenever we used @valid with @requestBody it ensures that upcoming/incoming 
    json request data is validated before reaching to the controller method..
     if validation fails, a 400 Bad Request Response is automatically returned */
    
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // Update hotel data
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotels(@PathVariable long id, @Valid @RequestBody Hotel updateHotel ,BindingResult result) {
    	
    	/* if(result.hasErrors()) {
    		return ResponseEntity.badRequest().body(getValidationError(result));
    	} */
    	
    	

        Hotel existingHotel = hotelService.getHotelbyId(id);

        if (existingHotel != null) {
            existingHotel.setName(updateHotel.getName());
            existingHotel.setHoteltype(updateHotel.getHoteltype());
            existingHotel.setQuality(updateHotel.getQuality());
            existingHotel.setHotelEmail(updateHotel.getHotelEmail());

            Hotel savedHotel = hotelService.updateHotel(existingHotel);

            return ResponseEntity.ok(savedHotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a hotel by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable long id) {

        boolean isDeleted = hotelService.deleteHotelById(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
