package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;

@Service //serve as a service class

public class HotelService {
	
	@Autowired

	private HotelRepository hotelRepository;
	
	//getting data
	public List<Hotel>getAllHotel(){
		return hotelRepository.findAll();
		
	}
	
	//saving data
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
		
	}
	
	//update
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	//Get hotel Id
	
	public Hotel getHotelbyId(long id) {
		return hotelRepository.findById(id).orElse(null);
		
	}
	
	//deleting hotel by id
	public boolean deleteHotelById(long id) {
		if(hotelRepository.existsById(id)) {
		    hotelRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}
	
}
