package com.rbitcs.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
private static final long serialVersionUID = 1L;
@Id
 @Column(name = "id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
@Column(name = "doctorNumber")
 private String doctorNumber;
@Column(name = "name")
 private String name;
@Column(name = "address")
 private String address;
public String getName() {
  return name;
 }
public void setName(String name) {
  this.name = name;
 }
public String getAddress() {
  return address;
 }
public void setAddress(String address) {
  this.address = address;
 }
public String getDoctorNumber() {
  return doctorNumber;
 }
public void setDoctorNumber(String doctorNumber) {
  this.doctorNumber = doctorNumber;
 }
}