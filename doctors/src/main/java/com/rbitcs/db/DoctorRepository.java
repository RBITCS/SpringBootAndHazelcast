package com.rbitcs.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbitcs.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	Doctor findByDoctorNumber(String doctorNumber);

	Doctor deleteByDoctorNumber(String doctorNumber);
}