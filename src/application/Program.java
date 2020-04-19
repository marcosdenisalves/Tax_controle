package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.Person;
import entities.PhysicalPerson;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Person> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char answer = sc.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if (answer == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				sc.nextLine();
				list.add(new PhysicalPerson(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int employeeNumber = sc.nextInt();
				sc.nextLine();
				list.add(new LegalPerson(name, anualIncome, employeeNumber));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Person person : list) {
			System.out.printf("%s: $ %.2f%n", person.getName(), person.payTax());
		}
		double sum = 0;
		for (Person person : list) {
			sum += person.payTax();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);
		
		sc.close();
	}

}
