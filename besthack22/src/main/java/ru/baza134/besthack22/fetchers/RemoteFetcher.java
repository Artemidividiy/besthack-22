package ru.baza134.besthack22.fetchers;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RemoteFetcher implements Fetcher {

  @Bean
  private RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  public String fetchSerialized(String source) throws RestClientException {
    return getRestTemplate().getForObject(source, String.class);
  }
}
