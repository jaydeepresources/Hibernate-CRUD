package com;

import java.util.Scanner;

import dao.EmployeeFacadeImpl;
import model.Employee;

public class TestProject {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		HibernateConfigurations configuration = new HibernateConfigurations();
		EmployeeFacadeImpl empImpl = new EmployeeFacadeImpl(configuration);
		int doChoice=0;
				
		do {
			System.out.println("1.Insert\t2.Update\t3.Delete\t4.View");
			int choice = scan.nextInt();
			Employee e = new Employee();
			switch (choice) {
			case 1:
				System.out.println("Enter id, name and salary");
				e = new Employee(scan.nextInt(), scan.next(), scan.nextFloat());
				empImpl.insert(e);
				break;

			case 2:
				System.out.println("Enter id, name and salary");
				e = new Employee(scan.nextInt(), scan.next(), scan.nextFloat());
				empImpl.update(e);
				break;

			case 3:
				System.out.println("Enter id");
				e.setId(scan.nextInt());
				empImpl.delete(e);
				break;

			case 4:
				empImpl.view();
				break;

			default:
				break;
			}
			
			System.out.println("1.Re Run\t\t2.Exit");
			doChoice = scan.nextInt();
			
		} while (doChoice==1);

		configuration.getSession().close();
		System.out.println("********Good Bye For Now********");
		
	}

}
