package com.hospital.dao;

import org.springframework.data.repository.CrudRepository;

import entity.Nurse;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {

}