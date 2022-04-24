package ru.baza134.besthack22.controllers;

import org.springframework.web.bind.annotation.RestController;

import ru.baza134.besthack22.factories.CSVStationFactory;
import ru.baza134.besthack22.factories.JSONStationFactory;
import ru.baza134.besthack22.factories.StationFactory;
import ru.baza134.besthack22.fetchers.Fetcher;
import ru.baza134.besthack22.fetchers.LocalFetcher;
import ru.baza134.besthack22.fetchers.RemoteFetcher;
import ru.baza134.besthack22.models.Station;
import ru.baza134.besthack22.services.StationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class StationController {
  
  @Autowired
  StationService stationService;

  @RequestMapping(value="/", method=RequestMethod.POST)
  public ResponseEntity<?> fetch(@RequestBody String requestData) {
    JacksonJsonParser parser = new JacksonJsonParser();
    Map<String, Object> data = parser.parseMap(requestData);
    String fetchMode = (String) data.get("fetchMode");
    String dataSource = (String) data.get("dataSource");
    String contentType = (String) data.get("contentType");
    Fetcher fetcher;
    switch(fetchMode) {
      case "local":
        fetcher = new LocalFetcher();
        break;
      case "remote":
        fetcher = new RemoteFetcher();
        break;
      default:
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    String sourceSerialized;
    if(dataSource == null)
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    try {
      sourceSerialized = fetcher.fetchSerialized(dataSource);
    } catch (Exception exception) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    StationFactory stationFactory;
    switch(contentType) {
      case "json":
        stationFactory = new JSONStationFactory();
        break;
      case "csv":
        stationFactory = new CSVStationFactory();
        break;
      default:
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    try {
      Map<String, String> mappingRules = new HashMap<>();
      for(Map.Entry<String, Object> entry : data.entrySet()) {
        if(entry.getKey().substring(0, 8) == "station.") {
          mappingRules.put((String) entry.getValue(), entry.getKey());
        }
      }
      List<Station> stations = stationFactory.createStations(mappingRules, sourceSerialized);
      stations.forEach(station -> { stationService.save(station); });
    } catch (Exception exception) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(null, HttpStatus.OK);
  }
}
