package ru.baza134.besthack22.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.baza134.besthack22.models.FuelType;
import ru.baza134.besthack22.repositories.FuelTypeRepository;

@Service
@EnableRetry
public class FuelTypeService {
  @Autowired
  FuelTypeRepository fuelTypeRepository;

  @Retryable(value = CannotAcquireLockException.class)
  @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
  public FuelType findOrCreate(String name) {
    Optional<FuelType> existingFuelType = fuelTypeRepository.findById(name);
    return existingFuelType.isPresent() ? existingFuelType.get() : new FuelType();
  }
}
