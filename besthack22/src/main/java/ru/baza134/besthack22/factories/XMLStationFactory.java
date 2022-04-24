package ru.baza134.besthack22.factories;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.baza134.besthack22.models.Station;

public class XMLStationFactory extends StationFactory {

  @Override
  public List<Station> createStations(Map<String, String> mappingRules, String payload) throws Exception {
    XmlMapper objectMapper = new XmlMapper();
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
