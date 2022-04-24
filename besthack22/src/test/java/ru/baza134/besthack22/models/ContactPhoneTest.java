package ru.baza134.besthack22.models;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ContactPhoneTest {
    ContactPhone ct = new ContactPhone("88005553535");
    @Test
    void getId() {
        ct.setId(Math.abs(new Random().nextInt()));
        assertNotNull(ct.getId());
        assertTrue(ct.getId() > 0);
    }

    @Test
    void getPhoneNumber() {
        assertEquals(ct.getPhoneNumber(), "88005553535");
    }

    @Test
    void getStation() {
        assertNull(ct.getStation());
    }

    @Test
    void setId() {
        Integer new_number = Math.abs( new Random().nextInt());
        ct.setId(new_number);
        assertNotEquals(ct.getId(), 1);
    }

    @Test
    void setPhoneNumber() {
        ct.setPhoneNumber("89851351693");
        assertEquals(ct.getPhoneNumber(), "89851351693");
    }

    @Test
    void setStation() {
    }
}