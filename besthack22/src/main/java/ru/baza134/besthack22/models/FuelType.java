package ru.baza134.besthack22.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fuel_type")
@Getter
@Setter
@NoArgsConstructor
public class FuelType {
  @Id
  private String name;

  @OneToMany(mappedBy = "fuelType", cascade = CascadeType.ALL)
  private List<FuelTypeStationRelationship> fuelTypeStationRelationships = new ArrayList<>();

  public FuelType(String name) {
    this.name = name;
  }
}
