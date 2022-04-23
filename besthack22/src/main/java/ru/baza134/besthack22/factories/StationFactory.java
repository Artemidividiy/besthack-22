package ru.baza134.besthack22.factories;

import ru.baza134.besthack22.models.Station;

public interface StationFactory {
  Station constructStation(String serialized);
}