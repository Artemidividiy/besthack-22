package ru.baza134.besthack22.factories;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import ru.baza134.besthack22.factories.helpers.PropertyAttachmentHelper;
import ru.baza134.besthack22.models.Station;

public abstract class StationFactory {

  @Bean
  protected PropertyAttachmentHelper getPropertyAttachmentHelper() {
    return new PropertyAttachmentHelper();
  }

  public abstract List<Station> createStations(Map<String, String> mappingRules, String payload) throws Exception;
}