package ru.baza134.besthack22.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.baza134.besthack22.models.FuelType;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FuelTypeServiceTest {
    @Autowired
    FuelTypeService fuelTypeService;

    @Test
    void findOrCreate() {
            FuelType ft1 = fuelTypeService.findOrCreate("a");
            FuelType ft2 = fuelTypeService.findOrCreate("a");
            assertSame(ft1, ft2);
            FuelType ft3 = fuelTypeService.findOrCreate("b");
            assertNotSame(ft1, ft3);
    }

}