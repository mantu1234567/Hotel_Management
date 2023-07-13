package com.geekster.HotelManagement.repository;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends CrudRepository<HotelRoom,Long> {


    List<HotelRoom> findByRoomStatus(boolean status);

    List<HotelRoom> findByRoomTypeAndRoomPrice(RoomType type, Double price);

    List<HotelRoom> findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(boolean status, RoomType type, Double lPrice, Double uPrice);
}
