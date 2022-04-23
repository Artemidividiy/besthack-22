package ru.baza134.besthack22.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fuel_type_station_relationship")
@Getter
@Setter
@NoArgsConstructor
public class FuelTypeStationRelationship {
  @Id
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "station_id")
  private Station station;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fuel_type_id")
  private FuelType fuelType;

  @Column(name = "price_per_liter")
  private Integer pricePerLiter;

  public FuelTypeStationRelationship(Station station, FuelType fuelType, Integer pricePerLiter) {
    this.station = station;
    this.fuelType = fuelType;
    this.pricePerLiter = pricePerLiter;
  }
}