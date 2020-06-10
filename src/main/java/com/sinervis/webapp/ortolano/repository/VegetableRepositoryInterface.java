package com.sinervis.webapp.ortolano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinervis.webapp.ortolano.model.Vegetable;

public interface VegetableRepositoryInterface extends JpaRepository<Vegetable, Integer>{}
