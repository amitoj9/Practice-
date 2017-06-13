package practice;

public class BitShiftOperation {

	public static void main (String argsp[])
	{
		int a=1;
	/*	System.out.println(Integer.toBinaryString(a));
		System.out.println(a>>>1);
		System.out.println(Integer.toBinaryString(a>>>1));
		System.out.println(Integer.toBinaryString(a>>1));
		System.out.println(Integer.toBinaryString(a<<1));*/	
		for (int i=0;i<8;i++)
		{
			a=a<<1;
			if(i==7)
			System.out.println(Integer.toBinaryString(a));
		}
		for (int i=0;i<8;i++)
		{
			System.out.println(Integer.toBinaryString(a));
			a=a>>>1;
			
		}
		System.out.println(Integer.toBinaryString(a));
	}
}
