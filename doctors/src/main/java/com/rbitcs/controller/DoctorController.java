package com.rbitcs.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rbitcs.db.DoctorRepository;
import com.rbitcs.model.Doctor;
@RestController
@RequestMapping(path = "doctors")
public class DoctorController {
@Autowired
 private DoctorRepository doctorRepository;
@Autowired
 private Map<String, Doctor> doctorMap;
@GetMapping(path = { "/get/{doctorNumber}" })
 public Doctor getDoctor(@PathVariable("doctorNumber") String doctorNumber) {
  //First call is to check if doctormap has doctor details if yes, return the value otherwise call database.
  Doctor doctor = (doctorMap.get(doctorNumber) != null) ? doctorMap.get(doctorNumber)
    : doctorRepository.findByDoctorNumber(doctorNumber);
  return doctor;
 }
@PostMapping("/add")
 public void createDoctor(@RequestBody Doctor doctor) {
     //save doctor details in cache
  doctorMap.put(doctor.getDoctorNumber(), doctor);
  doctorRepository.save(doctor);
 }
@DeleteMapping(path = { "/delete/{doctorNumber}" })
 public Doctor deleteDoctor(@PathVariable("doctorNumber") String doctorNumber) {
  //remove doctor details from both cache and database
  doctorMap.remove(doctorNumber);
  return doctorRepository.deleteByDoctorNumber(doctorNumber);
 }
}