package ru.baza134.besthack22.factories;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import ru.baza134.besthack22.models.Station;

public class JSONStationFactory extends StationFactory {
  @Override
  public List<Station> createStations(Map<String, String> mappingRules, String payload) throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(payload);
    List<Station> stations = new LinkedList<>();
    arrayNode.forEach(sourceEntity -> {
      Station station = new Station();
      mappingRules.keySet().forEach(key -> {
        JsonNode valueNode = sourceEntity.findValue(key);
        if(valueNode != null)
          getPropertyAttachmentHelper().tryAttachPropertyToStation(station, mappingRules.get(key), valueNode.asText());
      });
      stations.add(station);
    });
    return stations;
  }
}
