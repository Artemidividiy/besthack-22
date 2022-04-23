package ru.baza134.besthack22.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fuel_type")
@Getter
@Setter
public class FuelType {
  private String name;

  @OneToMany(mappedBy = "fuel_type", cascade = CascadeType.ALL)
  private List<FuelTypeStationRelationship> fuelTypeStationRelationships = new ArrayList<>();
}
