package com.Passenger.service;

import com.Passenger.payload.PassengerDTO;

import java.util.List;

public interface PassengerService {

    PassengerDTO createPassenger(PassengerDTO passengerDTO);

    PassengerDTO getPassengerById(Long passengerId);

    List<PassengerDTO> getAllPassengers();



    PassengerDTO updatePassenger(Long passengerId, PassengerDTO passengerDTO);

    void deletePassenger(Long passengerId);
}
