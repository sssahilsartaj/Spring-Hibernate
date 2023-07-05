package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting..........");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// take input from user
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean temp = true;
		while (temp) {
			System.out.println("********Welcome********");
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all students");
			System.out.println("PRESS 3 for display specific student details");
			System.out.println("PRESS 4 for delete student");
			System.out.println("PRESS 5 for update student");
			System.out.println("PRESS 6 for EXIT");

			try {
				// read input from user
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add student
					// enter student details
					System.out.println("Enter Student Id ");
					int studentId = Integer.parseInt(br.readLine());

					System.out.println("Enter Student Name ");
					String studentName = br.readLine();

					System.out.println("Enter Student City ");
					String studentCity = br.readLine();

					// create student object to for set values
					Student student = new Student(studentId, studentName, studentCity);

					// insert
					int s = studentDao.insertStudent(student);
					System.out.println("------------------------------");
					System.out.println("Student ID: " + s + " is Insert Successfully");
					System.out.println();
					break;

				case 2:
					// display students
					List<Student> students = studentDao.getAllStudents();
					System.out.println("\n***********All Student Details***********\n");
					for (Student st : students) {
						System.out.println("Student ID: " + st.getStudentId());
						System.out.println("Student Name: " + st.getStudentName());
						System.out.println("Student City: " + st.getStudentCity());
						System.out.println("________________________________");
					}
					System.out.println();
					break;

				case 3:
					// display specific student
						System.out.println("Enter Student Id for get details: ");
						int sId = Integer.parseInt(br.readLine());
						Student stud = studentDao.getStudent(sId);
						System.out.println(sId+" : Student Details:\n");
						System.out.println("Student ID: " + stud.getStudentId());
						System.out.println("Student Name: " + stud.getStudentName());
						System.out.println("Student City: " + stud.getStudentCity());
						System.out.println("________________________________\n");

					break;
					
				case 4:
					// delete student
					System.out.println("Enter the Student Id which you want to delete\n");
					int dltStud = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(dltStud);
					System.out.println(dltStud+" : Student Id is deleted successfully\n");
					break;
					
				case 5:
					// update student
					System.out.println("Enter the Student Id which you want to update\n");
					int updtStud = Integer.parseInt(br.readLine());
					// enter updated student details

					System.out.println("Enter Student Name ");
					String updtStudName = br.readLine();

					System.out.println("Enter Student City ");
					String updtStudCity = br.readLine();
					// create new student object and set updated values
					Student student2 = new Student();
					student2.setStudentId(updtStud);
					student2.setStudentName(updtStudName);
					student2.setStudentCity(updtStudCity);
					
					studentDao.updateStudent(student2);
					System.out.println(updtStud+" : student Id is updated successfully.\n");
					
					break;
					
				case 6:
					// exit
					temp = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input!!! Open eyes and press only mentioned keys\n");
				System.out.println(e.getMessage());
				System.out.println("\n");
			}

		}
		System.out.println("Thank you!!! See you soon.....");

	}
}
