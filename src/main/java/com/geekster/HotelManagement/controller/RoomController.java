package com.geekster.HotelManagement.controller;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.RoomType;
import com.geekster.HotelManagement.service.HotelService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    HotelService hotelService;

    // get all rooms
    @GetMapping("find/all")
    public Iterable<HotelRoom> getAll(){
        return hotelService.getAll();
    }
    // get all room by I'd
//    @GetMapping("rooms/{id}")
//    public HotelRoom getRoomsById(@PathVariable Integer  id){
//        return hotelService.getRoomsById(id);
//    }

    // create room
    @PostMapping("create")
    public String createRoom(@RequestBody HotelRoom hotelRoom){
      return hotelService.createRoom(hotelRoom);
  }

    //create list of rooms
    @PostMapping("addRooms")
    public String addRooms(@RequestBody List<HotelRoom> hotelRooms){
        return hotelService.addRooms(hotelRooms);
    }
    // check room present or not
    @GetMapping("room/{Id}")
    public boolean checkRoomId(@PathVariable Long Id){
        return hotelService.checkRoomId(Id);
    }
    @GetMapping("count/room")
    public Integer getTotalRoom(){
        return hotelService.getTotalRoom();
    }

    @GetMapping("get/room/status/{status}")

    public List<HotelRoom> getRoomStatus(@PathVariable boolean status){
        return hotelService.getRoomStatus(status);
    }
    @GetMapping("rooms/type/price/{type}/{price}")
    public List<HotelRoom> getRoomByTypeAndPrice(@PathVariable RoomType type,@PathVariable Double price){
        return hotelService.getRoomByTypeAndPrice(type,price);

    }
     @GetMapping("status/{status}/type/{type}/price/{lPrice}/{uPrice}")
    public List<HotelRoom> getStatusTypePrice(@PathVariable boolean status,@PathVariable RoomType type,@PathVariable Double lPrice,@PathVariable Double uPrice){
        return hotelService.getStatusTypePrice(status,type,lPrice,uPrice);
    }
}
