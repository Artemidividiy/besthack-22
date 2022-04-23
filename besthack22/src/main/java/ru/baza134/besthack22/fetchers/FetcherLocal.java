package ru.baza134.besthack22.fetchers;


import org.yaml.snakeyaml.util.UriEncoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FetcherLocal implements Fetcher {
    @Override
    public String fetchSerialized(String source) {
        Path filepath = Path.of(source);
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(filepath)), StandardCharsets.UTF_8)){
            stream.forEach(s -> contentBuilder.append(s).append('\n'));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contentBuilder.toString();
    }
}
