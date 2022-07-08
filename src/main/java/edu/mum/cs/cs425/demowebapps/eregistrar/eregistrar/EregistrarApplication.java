package edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.service.StudentService;

@SpringBootApplication
public class EregistrarApplication implements CommandLineRunner {
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(EregistrarApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> students = new ArrayList<Student>() {
			{
				add(new Student(null, "000-61-0001", "Anna", "Lynn", "Smith",
						3.45, LocalDate.parse("2019-05-12"), false));
				add(new Student(null, "000-62-5987", "Khosbayar", "", "Sandag",
						3.8, LocalDate.parse("2021-11-04"), true));
				add(new Student(null, "000-62-4987", "Temuujin", "", "Tsogt",
						4, LocalDate.parse("2021-11-04"), true));
				add(new Student(null, "000-62-1566", "Tamir", "", "Bold",
						8, LocalDate.parse("2022-02-10"), true));
			}
		};
		// Student student = new Student(null, "000-61-0001", "Anna", "Lynn", "Smith",
		// 3.45, dateOfEnrollment, true);
		Student savedStudent = studentService.addNewStudent(students.get(0));
		Student savedStudent2 = studentService.addNewStudent(students.get(1));
		Student savedStudent3 = studentService.addNewStudent(students.get(2));
		Student savedStudent4 = studentService.addNewStudent(students.get(3));
		System.out.println(savedStudent);
		System.out.println(savedStudent2);
		System.out.println(savedStudent3);
		System.out.println(savedStudent4);

	}

}
