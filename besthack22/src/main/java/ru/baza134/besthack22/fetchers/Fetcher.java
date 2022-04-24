package ru.baza134.besthack22.fetchers;

import java.io.IOException;

public interface Fetcher {
  String fetchSerialized(String source) throws IOException;
}
