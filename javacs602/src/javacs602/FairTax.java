package javacs602;

import static java.lang.System.out;

import java.util.Scanner;

public class FairTax {
	public static void main(String...strings )
	{
		Scanner scanner=new Scanner(System.in);
		out.println("Enter your total income");
		Double totalIncome=scanner.nextDouble();
		System.out.println("Enter your expense in housing");
		Double housing=(Double)scanner.nextDouble();
		System.out.println("Enter your expense in food");
		Double food=(Double)scanner.nextDouble();
		System.out.println("Enter your expense in clothing");
		Double clothing=(Double)scanner.nextDouble();
		System.out.println("Enter your expense in transportation");
		Double transportation=(Double)scanner.nextDouble();
		System.out.println("Enter your expense in education");
		Double education=(Double)scanner.nextDouble();
		System.out.println("Enter your expense in health care");
		Double health=(Double)scanner.nextDouble();
		System.out.println("Enter your expense in vacations");
		Double vacations=(Double)scanner.nextDouble();
		Double taxableIncome=totalIncome-(housing+food+clothing+education+health+vacations+transportation);
		Double taxAmount=taxableIncome*.23;
		System.out.println("Fair Tax Amount is "+taxAmount);
		
	}
}
