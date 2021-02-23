package com.rbitcs.doctor;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.rbitcs.model.Doctor;

@SpringBootApplication
@Configuration
public class DoctorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorsApplication.class, args);
	}
	
	@Bean
	public Config hazelCastConfig() {
		return new Config().setManagementCenterConfig(
				new ManagementCenterConfig().setEnabled(true).setUrl("http://localhost:8080/hazelcast-mancenter"));
	}
	
	@Bean
	 public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
	  return Hazelcast.newHazelcastInstance(hazelCastConfig);
	 }
	@Bean
	 public Map<String, Doctor> doctorMap(HazelcastInstance hazelcastInstance) {
	  return hazelcastInstance.getMap("doctorMap");
	 }
}
