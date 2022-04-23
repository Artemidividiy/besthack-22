package ru.baza134.besthack22.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_phone")
@Getter
@Setter
public class ContactPhone {
  @Column(name = "phone_number")
  private String phoneNumber;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "station_id")
  private Station station;
}
