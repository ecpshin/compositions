package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class ProgramWorker {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter Worker data: ");
		
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departmentName));
		HourContract contract;
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			
			System.out.print("\nContract Data #" + i + ": ");
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Value Per Hour: ");
			Double valuePerhour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			sc.nextLine();
			
			contract = new HourContract(contractDate, valuePerhour, duration);
			
			worker.addContract(contract);
			
			System.out.print("\n-----------------------------------------------------\n");
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3, 7));
		
        double income = worker.income(year, month);
		
        System.out.println(
        		worker.toString() 
        		+ "\nIncome for " 
        		+ monthAndYear 
        		+ ": "
        		+ String.format("$ %.2f", income));
		
		
		sc.close();

	}

}
