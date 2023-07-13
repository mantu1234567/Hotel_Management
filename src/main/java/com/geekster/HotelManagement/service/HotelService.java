package com.geekster.HotelManagement.service;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.RoomType;
import com.geekster.HotelManagement.repository.HotelRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;
    public String createRoom(HotelRoom hotelRoom) {
        hotelRepo.save(hotelRoom);
        return "hotel create room ";
    }

    public String addRooms(List<HotelRoom> hotelRooms) {
        hotelRepo.saveAll(hotelRooms);
        return "hotel room is put";
    }

    public Iterable<HotelRoom> getAll() {
        return hotelRepo.findAll();
    }

    public boolean checkRoomId(Long id) {
        return hotelRepo.existsById(id);
    }

    public Integer getTotalRoom() {
        return (int)hotelRepo.count();
    }

    public List<HotelRoom> getRoomStatus(boolean status) {
        return hotelRepo.findByRoomStatus(status);
    }

    public List<HotelRoom> getRoomByTypeAndPrice(RoomType type, Double price) {
        return hotelRepo.findByRoomTypeAndRoomPrice(type,price);
    }

    public List<HotelRoom> getStatusTypePrice(boolean status, RoomType type, Double lPrice, Double uPrice) {
        return hotelRepo.findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(status,type,lPrice,uPrice);
    }
//    public HotelRoom getRoomsById(Integer id) {
//        return hotelRepo.getAllR
//    }


}
