package com.tus.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tus.flight.model.Flight;
import com.tus.flight.repo.FlightRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FlightController {

	private Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightRepository repo;

    @GetMapping("/flights")
    public List<Flight> getFlights(@RequestParam(required = false, defaultValue = "No Request Provided") String request) {
        logger.info("Received request: " + request);
        List<Flight> flights = repo.findAll();
        logger.info("Processed request successfully");
        return flights;
    }

}