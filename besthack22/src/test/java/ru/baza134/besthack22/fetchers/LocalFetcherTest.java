package ru.baza134.besthack22.fetchers;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LocalFetcherTest {

    @Test
    void fetchSerialized() {
        String pathname = "textFile.txt";
        File file = new File("testFile.txt");
        boolean result;
        try{
            result = file.createNewFile();
            String target = new LocalFetcher().fetchSerialized(pathname);
            assertTrue(target.isEmpty());
        }catch (IOException e) {
            System.out.println(e.toString());
            return;
        }
    }
}