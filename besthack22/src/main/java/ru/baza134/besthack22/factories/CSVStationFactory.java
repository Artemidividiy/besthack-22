package ru.baza134.besthack22.factories;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import ru.baza134.besthack22.models.Station;

public class CSVStationFactory extends StationFactory {
  private char CSVSeparator;

  public CSVStationFactory(char CSVSeparator) {
    this.CSVSeparator = CSVSeparator;
  }

  @Override
  public List<Station> createStations(Map<String, String> mappingRules, String payload) throws Exception {
    CSVParser parser = new CSVParserBuilder().withSeparator(CSVSeparator).build();
    CSVReader reader = new CSVReaderBuilder(new StringReader(payload))
                            .withCSVParser(parser)
                            .build();
    List<String[]> data = reader.readAll();
    reader.close();
    data.remove(0);
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
