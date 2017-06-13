package javacs602;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
	public static void main(String args[])
	{
		BigInteger bigInteger=new BigInteger("1");
		int ad;
		Scanner sc= new Scanner(System.in);
		ad=sc.nextInt();
		if(ad>0){
		for(int i=1;i<=ad;i++)
		{
			bigInteger=bigInteger.multiply(BigInteger.valueOf(i));
			
		}
		System.out.println(bigInteger);
		}
		else{
		System.out.println(0);	
		}
	}

}
