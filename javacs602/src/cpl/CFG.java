package cpl;

import java.util.Scanner;
/*
Amitoj Singh
*/public class CFG {

	public static void main(String args[])
	{
		try{
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter your Grammar");
		String input=scanner.nextLine();
		char cr[]= new char[input.length()];
		cr=input.toCharArray();
		boolean flag=false;
		boolean firstCapital=true;
		char [] init;
		int ff=0;
		System.out.println();
		System.out.println("Output:");
		for(int i=0;i<cr.length;i++)
		{
			int temp=cr[i];
//			System.out.println(temp);
			if(temp==62||temp==63)
			{
				if(flag)
				{
					System.out.println("Error in grammer");
					return;
				}
				ff=i+1;
				flag=true;
			}
			if(temp>=97&& temp<=122)
			{
				if(ff==0)
				{
					System.out.print("<");
					for(int m=i;m<cr.length;m++)
					System.out.print(cr[m]);
				
					System.out.print("> ");
					System.out.print("->");
				}
				
				for(int mm=0;mm<ff;mm++)
				{
					System.out.print(cr[mm]);
				}
				ff=0;
				if(i<cr.length-1)
				{
				System.out.print("<"+cr[i]+">");
				if(i==cr.length-2)
				{
					if(!(cr[cr.length-1]>=65&&cr[cr.length-1]<=90))
					{
						System.out.print("<");
						for(int j=i+1;j<cr.length;j++)
						{
							System.out.print(cr[j]);
						}
						System.out.print(">");
						System.out.println();
						
					}
					else
						System.out.println(cr[cr.length-1]);
					System.out.println("<"+cr[i]+"> -> "+cr[i]);
				}
				else
				{
					System.out.print("<");
					for(int j=i+1;j<cr.length;j++)
					{
						System.out.print(cr[j]);
					}
					System.out.print(">");
					System.out.println();
					System.out.println("<"+cr[i]+"> -> "+cr[i]);
				}
			
				}
				if(i==cr.length-1)
				{
					System.out.println(cr[i]);
				}
				
				
			}
			if(flag)
			{
			if(firstCapital&&temp>=65&& temp<=90)
			{
				if(i==cr.length-2)
				{
					int t=cr[cr.length-1];
					if(t>=65 && temp<=90)
					{
						System.out.print("<");
						for(int m=i;m<cr.length;m++)
						System.out.print(cr[m]);
						System.out.print(">");
						System.out.print(" ->");
						for(int m=i;m<cr.length;m++)
							System.out.print(cr[m]);
							
					}
					else
					{

						if(ff==0)
						{
							System.out.print("<");
							for(int m=i;m<cr.length;m++)
							System.out.print(cr[m]);
						
							System.out.print("> ");
							System.out.print("->");
						}
						for(int mm=0;mm<ff;mm++)
						{
							System.out.print(cr[mm]);
						}
						ff=0;
						System.out.print(cr[i]);
						if(i<cr.length-1)
						{
							System.out.print("<");
							for(int mm=i+1;mm<cr.length;mm++)
							{
								System.out.print(""+cr[mm]);
							}
							System.out.println(">");
								
						}
					
					}
					
				}
				else
				{
					if(ff==0)
					{
						System.out.print("<");
						for(int m=i;m<cr.length;m++)
						System.out.print(cr[m]);
					
						System.out.print("> ");
						System.out.print("->");
					}
					for(int mm=0;mm<ff;mm++)
					{
						System.out.print(cr[mm]);
					}
					ff=0;
					System.out.print(cr[i]);
					if(i<cr.length-1)
					{
						System.out.print("<");
						for(int mm=i+1;mm<cr.length;mm++)
						{
							System.out.print(""+cr[mm]);
						}
						System.out.println(">");
							
					}
				}
				
				
				firstCapital=false;
			}
			else
			if(temp>=65&& temp<=90&&i<cr.length-1)
			{	
				if(i==cr.length-2)
				{
					int t=cr[cr.length-1];
					if(t>=65 && temp<=90)
					{
						System.out.print("<");
						for(int m=i;m<cr.length;m++)
						System.out.print(cr[m]);
						System.out.print(">");
						System.out.print(" ->");
						for(int m=i;m<cr.length;m++)
							System.out.print(cr[m]);
							
					}
					else
					{
						for(int mm=0;mm<ff;mm++)
						{
							System.out.print(cr[mm]);
						}
						ff=0;
						System.out.print("<");
						for(int mm=i;mm<cr.length;mm++)
						{
							System.out.print(""+cr[mm]);
						}
						System.out.print("> ->");
						if(i<cr.length-1)
						{
						System.out.print(cr[i]);
						System.out.print("<");
						for(int mm=i+1;mm<cr.length;mm++)
						{
							System.out.print(cr[mm]);
						}
						System.out.print(">");
						System.out.println();
						}
						else
						{
							System.out.println(cr[i]);
						}
					}
				}
				else
				{
					for(int mm=0;mm<ff;mm++)
					{
						System.out.print(cr[mm]);
					}
					ff=0;
					System.out.print("<");
					for(int mm=i;mm<cr.length;mm++)
					{
						System.out.print(""+cr[mm]);
					}
					System.out.print("> ->");
					if(i<cr.length-1)
					{
					System.out.print(cr[i]);
					System.out.print("<");
					for(int mm=i+1;mm<cr.length;mm++)
					{
						System.out.print(cr[mm]);
					}
					System.out.print(">");
					System.out.println();
					}
					else
					{
						System.out.println(cr[i]);
					}
				}
				
			}
		}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
