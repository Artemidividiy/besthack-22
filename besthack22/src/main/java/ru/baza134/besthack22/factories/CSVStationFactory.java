package ru.baza134.besthack22.factories;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

import ru.baza134.besthack22.models.Station;

public class CSVStationFactory extends StationFactory {
  @Override
  public List<Station> createStations(Map<String, String> mappingRules, String payload) throws Exception {
    CSVReader reader = new CSVReader(new StringReader(payload));
    List<String[]> data = reader.readAll();
    reader.close();
    List<Station> stations = new LinkedList<>(); 
    data.forEach(sourceEntity -> {
      Station station = new Station();
      for(Integer index = 0; index < sourceEntity.length; index++) {
        getPropertyAttachmentHelper().tryAttachPropertyToStation(station, mappingRules.get(index.toString()), sourceEntity[index]);
      }
      stations.add(station);
    });
    return stations;
  }
}
