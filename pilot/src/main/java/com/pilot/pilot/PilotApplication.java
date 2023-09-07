package com.pilot.pilot;

import com.pilot.pilot.models.Employee;
import com.pilot.pilot.repository.EmpRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PilotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PilotApplication.class, args);
	}

	@Autowired
	private EmpRep empRep;

	@Override
	public void run(String... args) throws Exception {
		Employee emp=new Employee();
		emp.setFirstName("Virat");
		emp.setLastName("Kohli");
		emp.setEmailId("vk@gmail.com");
		empRep.save(emp);
	}
}
