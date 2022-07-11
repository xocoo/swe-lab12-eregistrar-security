package edu.mum.cs.cs425.demowebapps.eregistrar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Classroom;
import edu.mum.cs.cs425.demowebapps.eregistrar.model.Role;
import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.model.User;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.ClassroomService;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.RoleService;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.UserService;

@SpringBootApplication
public class EregistrarApplication implements CommandLineRunner {
	@Autowired
	StudentService studentService;

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@Autowired
	ClassroomService classroomService;

	public static void main(String[] args) {
		SpringApplication.run(EregistrarApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// List<Student> students = new ArrayList<Student>() {
		// {
		// add(new Student(null, "000-61-0001", "Anna", "Lynn", "Smith",
		// 3.45, LocalDate.parse("2019-05-12"), false));
		// add(new Student(null, "000-62-5987", "Khosbayar", "", "Sandag",
		// 3.8, LocalDate.parse("2021-11-04"), true));
		// add(new Student(null, "000-62-4987", "Temuujin", "", "Tsogt",
		// 4, LocalDate.parse("2021-11-04"), true));
		// add(new Student(null, "000-62-1566", "Tamir", "", "Bold",
		// 8, LocalDate.parse("2022-02-10"), true));
		// }
		// };
		// Student savedStudent = studentService.addNewStudent(students.get(0));
		// Student savedStudent2 = studentService.addNewStudent(students.get(1));
		// Student savedStudent3 = studentService.addNewStudent(students.get(2));
		// Student savedStudent4 = studentService.addNewStudent(students.get(3));
		// System.out.println(savedStudent);
		// System.out.println(savedStudent2);
		// System.out.println(savedStudent3);
		// System.out.println(savedStudent4);

		// List<Role> roles = new ArrayList<Role>() {
		// {
		// add(new Role(null, "ROLE_ADMIN"));
		// add(new Role(null, "ROLE_REGISTRAR"));
		// add(new Role(null, "ROLE_STUDENT"));
		// }
		// };
		// Role role1 = roleService.addNewRole(roles.get(0));
		// Role role2 = roleService.addNewRole(roles.get(1));
		// Role role3 = roleService.addNewRole(roles.get(2));
		// System.out.println(role1);
		// System.out.println(role2);
		// System.out.println(role3);

		// List<User> users = new ArrayList<User>() {
		// {
		// add(new User(null, "Anna", "Lynn", "Smith", "ana.admin",
		// "test1234", "ana.admin@eregistrar.com",
		// true,
		// true, true, true));
		// add(new User(null, "Bob", null, "John", "bob.registrar",
		// "test1234", "bob.registrar@eregistrar.com",
		// true,
		// true, true, true));
		// add(new User(null, "Carlos", "Mangar", "Santa", "carlos.student",
		// "test1234", "carlos.student@eregistrar.com",
		// true,
		// true, true, true));
		// }
		// };
		// User user1 = userService.saveUser(users.get(0));
		// User user2 = userService.saveUser(users.get(1));
		// User user3 = userService.saveUser(users.get(2));
		// System.out.println(user1);
		// System.out.println(user2);
		// System.out.println(user3);

		// List<Classroom> classrooms = new ArrayList<Classroom>() {
		// {
		// add(new Classroom(null, "McLaughlin building", "M105"));
		// add(new Classroom(null, "Verill hall", "35"));
		// add(new Classroom(null, "Argiro", "350"));

		// }
		// };
		// Classroom classroom1 = classroomService.addNewClassroom(classrooms.get(0));
		// Classroom classroom2 = classroomService.addNewClassroom(classrooms.get(1));
		// Classroom classroom3 = classroomService.addNewClassroom(classrooms.get(2));
		// System.out.println(classroom1);
		// System.out.println(classroom2);
		// System.out.println(classroom3);
	}

}
