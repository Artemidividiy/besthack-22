package ru.baza134.besthack22.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fuel_type_station_relationship")
@Getter
@Setter
public class FuelTypeStationRelationship {
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "station_id")
  private Station station;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fuel_type_id")
  private FuelType fuelType;

  @Column(name = "price_per_liter")
  Integer pricePerLiter;
}