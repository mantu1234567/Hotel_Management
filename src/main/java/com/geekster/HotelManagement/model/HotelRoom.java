package com.geekster.HotelManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HotelRoom {

    @Id
    private Long roomId;
    private Integer roomNumber;

    private RoomType roomType;
    private Double roomPrice;

    private boolean roomStatus;
}
