package ru.baza134.besthack22.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.baza134.besthack22.models.Station;
import ru.baza134.besthack22.repositories.StationRepository;

@Service
public class StationService {

  @Autowired
  private StationRepository stationRepository;

  public void save(Station station) {
    stationRepository.save(station);
  }
}
