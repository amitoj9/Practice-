package cpl;
import java.io.*;
public class CPLProject
{
	public static void main(String args[])
	{
		try
		{
			int i;
			char initial;
			String remainstr=null;
			int a=0;
			int check;
			String input=null;
			String finalinput=null;
			String firstchar=null;
			String endstr;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input:");
			String enteredinput=br.readLine();
			
			for(i=0;i<enteredinput.length();i++)
			{
				if((int)enteredinput.charAt(i)==62)
				{
					input=enteredinput.substring(i+1, enteredinput.length());
					
				}
				
			}
			firstchar=enteredinput.trim();
			finalinput=input.trim();
			for(i=0;i<finalinput.length();i++)
			{
				check=(int)finalinput.charAt(i);
				if(!(check>=65&&check<=90)&&!(check>=97&&check<=122))
				{
					System.out.println("Enter Correct Grammer");
					System.exit(0);
				}
			}
			//System.out.println(finalinput);
			System.out.println("Output:");
			
			for(i=0;i<finalinput.length();i++)
			{
				initial=finalinput.charAt(i);
				remainstr=finalinput.substring(i+1, finalinput.length());
				if((int)finalinput.charAt(i)>=97&&(int)finalinput.charAt(i)<=122&&remainstr.length()>=2)
				{
					if(i==0)
					{
						System.out.println(firstchar.charAt(0)+"->"+"<"+initial+">"+"<"+remainstr+">");
					}
					else
					{
						System.out.println("<"+finalinput.substring(a, finalinput.length())+">"+"->"+"<"+initial+">"+"<"+remainstr+">");
						
					}
					System.out.println("<"+initial+">"+"->"+initial);
				}
				
				else if((int)finalinput.charAt(i)>=65&&(int)finalinput.charAt(i)<=90&&remainstr.length()>=2)
				{
					if(i==0)
					{
						System.out.println(firstchar.charAt(0)+"->"+initial+"<"+remainstr+">");
					}
					else
					{
						System.out.println("<"+finalinput.substring(a, finalinput.length())+">"+"->"+initial+"<"+remainstr+">");
					}
						
				}
				else if(remainstr.length()<=2)
				{
					endstr=finalinput.substring(finalinput.length()-2, finalinput.length());
					endstr.trim();
				
					if((int)endstr.charAt(0)>=65&&(int)endstr.charAt(0)<=90)
					{
						if((int)endstr.charAt(1)>=65&&(int)endstr.charAt(1)<=90)
						{
							System.out.println("<"+endstr+">"+"->"+endstr);
							return;
						}
						else if((int)endstr.charAt(1)>=97&&(int)endstr.charAt(1)<=122)
						{
							System.out.println("<"+endstr+">"+"->"+endstr.charAt(0)+"<"+endstr.charAt(1)+">");
							return;
						}
					}
					else if((int)endstr.charAt(0)>=97&&(int)endstr.charAt(0)<=122)
					{
						if((int)endstr.charAt(1)>=97&&(int)endstr.charAt(1)<=122)
						{
							System.out.println("<"+endstr+">"+"->"+"<"+endstr.charAt(0)+">"+"<"+endstr.charAt(1)+">");
							System.out.println("<"+endstr.charAt(0)+">"+"->"+endstr.charAt(0));
							System.out.println("<"+endstr.charAt(1)+">"+"->"+endstr.charAt(1));
							return;
						}
						else if((int)endstr.charAt(1)>=65&&(int)endstr.charAt(1)<=90)
						{
							System.out.println("<"+endstr+">"+"->"+"<"+endstr.charAt(0)+">"+endstr.charAt(1));
							System.out.println("<"+endstr.charAt(0)+">"+"->"+endstr.charAt(0));
							return;
							
						}
					}
				}
				
				a++;
			}
		}
		
		catch(IOException ioe)
		{
			System.out.println(ioe);
		}
			
		catch(NullPointerException npe)
		{
			System.out.println(npe);
		}
	}
}