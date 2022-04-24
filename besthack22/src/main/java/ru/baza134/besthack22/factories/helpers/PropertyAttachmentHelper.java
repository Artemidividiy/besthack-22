package ru.baza134.besthack22.factories.helpers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;

import ru.baza134.besthack22.factories.intermediates.FuelTypeStationIntermediate;
import ru.baza134.besthack22.models.ContactEmail;
import ru.baza134.besthack22.models.ContactPhone;
import ru.baza134.besthack22.models.FuelTypeStationRelationship;
import ru.baza134.besthack22.models.Station;
import ru.baza134.besthack22.services.FuelTypeService;
import ru.baza134.besthack22.services.StationService;

public class PropertyAttachmentHelper {

  @Autowired
  protected StationService stationService;

  @Autowired
  protected FuelTypeService fuelTypeService;
  
  public void tryAttachPropertyToStation(Station station, String propertyName, String value) {
    switch(propertyName) {
      case "station.name":
        station.setName(value);
        break;
      case "station.address":
        station.setAddress(value);
        break;
      case "station.region":
        station.setRegion(value);
        break;
      case "station.country":
        station.setCountry(value);
        break;
      case "station.latitude":
        station.setLatitude(Float.parseFloat(value));
        break;
      case "station.longitude":
        station.setLongitude(Float.parseFloat(value));
        break;
      case "station.accessibleToDisabled":
        station.setAccessibleToDisabled(Boolean.parseBoolean(value));
        break;
      case "station.paymentByCard":
        station.setPaymentByCard(Boolean.parseBoolean(value));
        break;
      case "station.paymentFromVehicle":
        station.setPaymentFromVehicle(Boolean.parseBoolean(value));
        break;
      case "station.contactPhone":
        List<ContactPhone> contactPhones = station.getContactPhones();
        contactPhones.add(new ContactPhone(value));
        break;
      case "station.contactEmail":
        List<ContactEmail> contactEmails = station.getContactEmails();
        contactEmails.add(new ContactEmail(value));
        break;
      case "station.fuelTypes":
        List<FuelTypeStationRelationship> fuelTypeStationRelationships = new LinkedList<>();
        JacksonJsonParser listParser = new JacksonJsonParser();
        listParser.parseList(value).forEach(sourceRelationship -> {
          fuelTypeStationRelationships.add(
            new FuelTypeStationRelationship(
              station,
              fuelTypeService.findOrCreate(
                ((FuelTypeStationIntermediate) sourceRelationship).getName()
              ),
              ((FuelTypeStationIntermediate) sourceRelationship).getPricePerLiter()
            )
          );
        });
        station.setFuelTypeStationRelationships(fuelTypeStationRelationships);
        break;
    }
  }
}
