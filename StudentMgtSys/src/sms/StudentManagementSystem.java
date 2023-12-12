package sms;

import java.util.ArrayList;
import java.util.Scanner;

class StudentManagementSystem
{
	private ArrayList<Student> students;
	private Scanner scanner;

	public StudentManagementSystem()
	{
		students = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	

	public void addStudent()
	{
		System.out.println();
		
		System.out.print("\t\tEnter Student Roll Number  :  ");
		int rollNumber = scanner.nextInt();
		scanner.nextLine();

		System.out.print("\t\tEnter Student Name  :  ");
		String name = scanner.nextLine();
		
		System.out.print("\t\tEnter Student Address  :  ");
		String address = scanner.nextLine();
		
		System.out.print("\t\tEnter Student Contact  :  ");
		long contact = scanner.nextLong();

		System.out.print("\t\tEnter Student Grade(%)  :  ");
		double grade = scanner.nextDouble();

		System.out.print("\t\tEnter Student Attendance(%)  :  ");
		int attendance = scanner.nextInt();
		

		Student newStudent = new Student(name, rollNumber, grade, attendance, address, contact);
		students.add(newStudent);

		System.out.println("\t\t\t---Student added successfully!!!---");
	}

	public void updateStudent()
	{
		System.out.print("\t\tEnter Student roll number to update  :  ");
		int rollNumber = scanner.nextInt();

		for (Student student : students)
		{
			if (student.rollNumber == rollNumber)
			{
				System.out.print("\t\tEnter updated Grade(%)  :  ");
				student.grade = scanner.nextDouble();

				System.out.print("\t\tEnter updated attendance(%)  :  ");
				student.attendance = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("\t\tEnter updated Contact No  :  ");
				student.contact = scanner.nextLong();

				System.out.println("\t\t\t---Student information updated successfully!!!---");
				return;
			}
		}

		System.out.println("\t\t\t------Student not found with the given roll number.----");
	}

	
	public void deleteStudent()
	{
		System.out.print("\t\tEnter Student Roll Number to delete  :  ");
		int rollNumber = scanner.nextInt();

		students.removeIf(student -> student.rollNumber == rollNumber);

		System.out.print("\t\t\t---Student deleted successfully!!!---");
	}
	

	public void generateReport()
	{
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t\tAll Student Detail:");
		System.out.println("\t\t\t\t===================");
		
		int i=1;
		for (Student student : students)
		{
			System.out.println();
			System.out.println("\t\t\t\tStudent No. : "+i);
			System.out.println("\t\t\t\t-----------------");
			System.out.println();
			System.out.println("\t\tRoll Number\t:\t"+student.rollNumber);
			System.out.println("\t\tName\t\t:\t"+student.name);
			System.out.println("\t\tAddress\t\t:\t"+student.address);
			System.out.println("\t\tContact\t\t:\t"+student.contact);
			System.out.println("\t\tGrade\t\t:\t"+student.grade+"%");
			System.out.println("\t\tAttendance\t:\t"+student.attendance+"%");
			System.out.println();
			i=i+1;
		}
	}

	public static void main(String[] args) 
	{
		StudentManagementSystem sms = new StudentManagementSystem();
		Scanner scanner = new Scanner(System.in);

		int choice;

		do
		{
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\tStudent Management System Menu:");
			System.out.println("\t\t\t\t===============================");
			System.out.println();
			System.out.println("\t\t\t1. Add Student");
			System.out.println("\t\t\t2. Update Student");
			System.out.println("\t\t\t3. Delete Student");
			System.out.println("\t\t\t4. Generate Report");
			System.out.println("\t\t\t5. Exit");

			System.out.println();
			System.out.print("\t\tEnter your choice  :  ");
			choice = scanner.nextInt();

			switch (choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.updateStudent();
				break;
			case 3:
				sms.deleteStudent();
				break;
			case 4:
				sms.generateReport();
				break;
			case 5:
				System.out.println("\t\t\t---Exiting the program. Goodbye!!!---");
				break;
			default:
				System.out.println("\t\t==>\t<Invalid choice. Please enter a valid option....>\t<==");
			}
		}
		while (choice != 5);
	}
}
