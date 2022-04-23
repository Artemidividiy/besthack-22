package ru.baza134.besthack22.fetchers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocalFetcher implements Fetcher {
  public String fetchSerialized(String source) throws IOException {
    return new String(Files.readAllBytes(Paths.get(source)));
  }
}
