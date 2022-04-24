package ru.baza134.besthack22.fetchers;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoteFetcherTest {
    String testUrl = "https://developer.nrel.gov/api/alt-fuel-stations/v1.json?fuel_type=E85,ELEC&state=CA&limit=2&api_key=gEYGIEx3kXvdDEjFzXhYNazEwa6YfaWYdaYMg6fQ";

    @Test
    void fetchSerialized() {
        String target = new RemoteFetcher().fetchSerialized(testUrl);
        try {
            assertNotNull(new JSONObject(target));
        } catch (JSONException e) {
            assertTrue(1 == 0);
        }
    }
}