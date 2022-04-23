package ru.baza134.besthack22.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "station")
@Getter
@Setter
public class Station {
  private String address;

  private String region;
  
  private String country;

  private Float latitude;

  private Float longitude;

  @Column(name = "accessible_to_disabled")
  private Boolean accessibleToDisabled;

  @Column(name = "payment_by_card")
  private Boolean paymentByCard;

  @Column(name = "payment_from_vehicle")
  private Boolean paymentFromVehicle;

  @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
  private List<FuelTypeStationRelationship> fuelTypeStationRelationships = new ArrayList<>();

  @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
  private List<ContactEmail> contactEmail = new ArrayList<>();

  @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
  private List<ContactPhone> contactPhone = new ArrayList<>();
}
