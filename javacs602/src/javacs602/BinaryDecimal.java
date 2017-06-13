package javacs602;

import java.util.Scanner;

public class BinaryDecimal {
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Binary Number");
		int binaryNumber=input.nextInt();
		String copyOfBinaryNumber=Integer.toString(binaryNumber);
		int sizeOfBinaryNumber=copyOfBinaryNumber.length();
		int number=0;
		int temp=0;
		int count=0;
		int result=0;
		while(count<=sizeOfBinaryNumber)
		{
			number=binaryNumber%10;
			temp=(int)(number*Math.pow(2,count));
			result=result+temp;
			count++;
			binaryNumber=binaryNumber/10;
			temp=0;
		}
		System.out.println("Decimal number is "+result);
	}
};
