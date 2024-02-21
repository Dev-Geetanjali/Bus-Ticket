package com.Passenger.service;

import com.Passenger.entity.Passenger;
import com.Passenger.exception.PassengerNotFoundException;
import com.Passenger.payload.PassengerDTO;
import com.Passenger.repository.PassengerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.Passenger.constants.PassengerConstants.MESSAGE_201;
import static com.Passenger.constants.PassengerConstants.STATUS_201;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return modelMapper.map(savedPassenger, PassengerDTO.class);
    }


    @Override
    public PassengerDTO getPassengerById(Long passengerId) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerId);
        return optionalPassenger.map(value -> modelMapper.map(value, PassengerDTO.class)).orElse(null);
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        return passengers.stream()
                .map(passenger -> modelMapper.map(passenger, PassengerDTO.class))
                .collect(Collectors.toList());
    }




    @Override
    public PassengerDTO updatePassenger(Long passengerId, PassengerDTO passengerDTO) {
        if (passengerId == null) {
            throw new IllegalArgumentException("PassengerId cannot be null");
        }

        Passenger existingPassenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger with ID " + passengerId + " not found"));

        //modelMapper.map(passengerDTO, existingPassenger);
        existingPassenger.setEmail(passengerDTO.getEmail());
        Passenger updatedPassenger = passengerRepository.save(existingPassenger);
        PassengerDTO dt = new PassengerDTO();

        dt.setEmail(updatedPassenger.getEmail());
        return dt;
    }


    @Override
    public void deletePassenger(Long passengerId) {
        passengerRepository.deleteById(passengerId);
    }
}
