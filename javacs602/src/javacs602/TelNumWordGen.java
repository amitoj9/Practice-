package javacs602;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TelNumWordGen {
	 public static void main(String args[])throws Exception{  
		   FileOutputStream fout=new FileOutputStream("mfile.txt");  
		   PrintStream pout=new PrintStream(fout);  
		 
		   Scanner scanner= new Scanner(System.in);
		   System.out.println("Enter 7 digit number to generate its 7 letter word combination");
		   long number=scanner.nextLong();
		   int length=7;
		   char[] digit1= new char[3];
		   char[] digit2= new char[3];
		   char[] digit3= new char[3];
		   char[] digit4= new char[3];
		   char[] digit5= new char[3];
		   char[] digit6= new char[3];
		   char[] digit7= new char[3];
		   while(length>0)
		   {
			   int digit=(int) (number/(Math.pow(10, length-1)));
			   number=(long) (number-(digit*Math.pow(10, length-1)));
			   switch(digit)
			   {
			   case 2:
				   switch(length)
				   {
				   case 7:
					   digit1[0]='a';
					   digit1[1]='b';
					   digit1[2]='c';
					   break;
				   case 6:
					   digit2[0]='a';
					   digit2[1]='b';
					   digit2[2]='c';
					   break;
				   case 5:
					   digit3[0]='a';
					   digit3[1]='b';
					   digit3[2]='c';
					   break;
				   case 4:
					   digit4[0]='a';
					   digit4[1]='b';
					   digit4[2]='c';
					   break;
				   case 3:
					   digit5[0]='a';
					   digit5[1]='b';
					   digit5[2]='c';
					   break;
				   case 2:
					   digit6[0]='a';
					   digit6[1]='b';
					   digit6[2]='c';
					   break;
				   case 1:
					   digit7[0]='a';
					   digit7[1]='b';
					   digit7[2]='c';
					   break;
				   
				   }
				   break;
			   case 3:
				   switch(length)
				   {
				   case 7:
					   digit1[0]='d';
					   digit1[1]='e';
					   digit1[2]='f';
					   break;
				   case 6:
					   digit2[0]='d';
					   digit2[1]='e';
					   digit2[2]='f';
					   break;
				   case 5:
					   digit3[0]='d';
					   digit3[1]='e';
					   digit3[2]='f';
					   break;
				   case 4:
					   digit4[0]='d';
					   digit4[1]='e';
					   digit4[2]='f';
					   break;
				   case 3:
					   digit5[0]='d';
					   digit5[1]='e';
					   digit5[2]='f';
					   break;
				   case 2:
					   digit6[0]='d';
					   digit6[1]='e';
					   digit6[2]='f';
					   break;
				   case 1:
					   digit7[0]='d';
					   digit7[1]='e';
					   digit7[2]='f';
					   break;
				   }
				   break;
			   case 4:switch(length)
			   {
			   case 7:
				   digit1[0]='g';
				   digit1[1]='h';
				   digit1[2]='i';
				   break;
			   case 6:
				   digit2[0]='g';
				   digit2[1]='h';
				   digit2[2]='i';
				   break;
			   case 5:
				   digit3[0]='g';
				   digit3[1]='h';
				   digit3[2]='i';
				   break;
			   case 4:
				   digit4[0]='g';
				   digit4[1]='h';
				   digit4[2]='i';
				   break;
			   case 3:
				   digit5[0]='g';
				   digit5[1]='h';
				   digit5[2]='i';
				   break;
			   case 2:
				   digit6[0]='g';
				   digit6[1]='h';
				   digit6[2]='i';
				   break;
			   case 1:
				   digit7[0]='g';
				   digit7[1]='h';
				   digit7[2]='i';
				   break;
			   
			   }
			   break;
			   case 5:switch(length)
			   {
			   case 7:
				   digit1[0]='j';
				   digit1[1]='k';
				   digit1[2]='l';
				   break;
			   case 6:
				   digit2[0]='j';
				   digit2[1]='k';
				   digit2[2]='l';
				   break;
			   case 5:
				   digit3[0]='j';
				   digit3[1]='k';
				   digit3[2]='l';
				   break;
			   case 4:
				   digit4[0]='j';
				   digit4[1]='k';
				   digit4[2]='l';
				   break;
			   case 3:
				   digit5[0]='j';
				   digit5[1]='k';
				   digit5[2]='l';
				   break;
			   case 2:
				   digit6[0]='j';
				   digit6[1]='k';
				   digit6[2]='l';
				   break;
			   case 1:
				   digit7[0]='j';
				   digit7[1]='k';
				   digit7[2]='l';
				   break;
			  
			   }
			   break;
			   case 6:switch(length)
			   {
			   case 7:
				   digit1[0]='m';
				   digit1[1]='n';
				   digit1[2]='o';
				   break;
			   case 6:
				   digit2[0]='m';
				   digit2[1]='n';
				   digit2[2]='o';
				   break;
			   case 5:
				   digit3[0]='m';
				   digit3[1]='n';
				   digit3[2]='o';
				   break;
			   case 4:
				   digit4[0]='m';
				   digit4[1]='n';
				   digit4[2]='o';
				   break;
			   case 3:
				   digit5[0]='m';
				   digit5[1]='n';
				   digit5[2]='o';
				   break;
			   case 2:
				   digit6[0]='m';
				   digit6[1]='n';
				   digit6[2]='o';
				   break;
			   case 1:
				   digit7[0]='m';
				   digit7[1]='n';
				   digit7[2]='o';
				   break;
			 
			   }
			   break;
			   case 7:switch(length)
			   {
			   case 7:
				   digit1[0]='p';
				   digit1[1]='r';
				   digit1[2]='s';
				   break;
			   case 6:
				   digit2[0]='p';
				   digit2[1]='r';
				   digit2[2]='s';
				   break;
			   case 5:
				   digit3[0]='p';
				   digit3[1]='r';
				   digit3[2]='s';
				   break;
			   case 4:
				   digit4[0]='p';
				   digit4[1]='r';
				   digit4[2]='s';
				   break;
			   case 3:
				   digit5[0]='p';
				   digit5[1]='r';
				   digit5[2]='s';
				   break;
			   case 2:
				   digit6[0]='p';
				   digit6[1]='r';
				   digit6[2]='s';
				   break;
			   case 1:
				   digit7[0]='p';
				   digit7[1]='r';
				   digit7[2]='s';
				   break;
			  
			   }
			   break;
			   case 8:switch(length)
			   {
			   case 7:
				   digit1[0]='t';
				   digit1[1]='u';
				   digit1[2]='w';
				   break;
			   case 6:
				   digit2[0]='t';
				   digit2[1]='u';
				   digit2[2]='w';
				   break;
			   case 5:
				   digit3[0]='t';
				   digit3[1]='u';
				   digit3[2]='w';
				   break;
			   case 4:
				   digit4[0]='t';
				   digit4[1]='u';
				   digit4[2]='w';
				   break;
			   case 3:
				   digit5[0]='t';
				   digit5[1]='u';
				   digit5[2]='w';
				   break;
			   case 2:
				   digit6[0]='t';
				   digit6[1]='u';
				   digit6[2]='w';
				   break;
			   case 1:
				   digit7[0]='t';
				   digit7[1]='u';
				   digit7[2]='w';
				   break;
			   
			   }
			   break;
			 case 9:switch(length)
			   {
			   case 7:
				   digit1[0]='w';
				   digit1[1]='x';
				   digit1[2]='y';
				   break;
			   case 6:
				   digit2[0]='w';
				   digit2[1]='x';
				   digit2[2]='y';
				   break;
			   case 5:
				   digit3[0]='w';
				   digit3[1]='x';
				   digit3[2]='y';
				   break;
			   case 4:
				   digit4[0]='w';
				   digit4[1]='x';
				   digit4[2]='y';
				   break;
			   case 3:
				   digit5[0]='w';
				   digit5[1]='x';
				   digit5[2]='y';
				   break;
			   case 2:
				   digit6[0]='w';
				   digit6[1]='x';
				   digit6[2]='y';
				   break;
			   case 1:
				   digit7[0]='w';
				   digit7[1]='x';
				   digit7[2]='y';
				   break;
			   
			   }
			   break;

			   }
			  length--; 
		   }
		   for(int i=0;i<3;i++)
		   {
			   StringBuffer str= new StringBuffer();
			   str.append(digit1[i]);
			   for(int j=0;j<3;j++)
			   {
				   StringBuffer strDigit2= new StringBuffer();
				   strDigit2.append(digit2[j]);
				   for(int k=0;k<3;k++)
				   {
					   StringBuffer strDigit3= new StringBuffer();
					   strDigit3.append(digit3[k]);
					   for(int l=0;l<3;l++)
					   {
						   StringBuffer strDigit4= new StringBuffer();
						   strDigit4.append(digit4[l]);
						   for(int m=0;m<3;m++)
						   {
							   StringBuffer strDigit5= new StringBuffer();
							   strDigit5.append(digit5[m]);
							   for(int n=0;n<3;n++)
							   {
								   StringBuffer strDigit6= new StringBuffer();
								   strDigit6.append(digit6[n]);
								   for(int o=0;o<3;o++)
								   {	StringBuffer strDigit7= new StringBuffer();
								   		strDigit7.append(str);
									    pout.println(strDigit7.append(strDigit2).append(strDigit3).append(strDigit4).append(strDigit5).append(strDigit6).append(digit7[o]));  
									    strDigit7= new StringBuffer();
								   }
								   strDigit6= new StringBuffer();
							   }
							   strDigit5= new StringBuffer();
						   }
						   strDigit4= new StringBuffer();
					   }
					   strDigit3= new StringBuffer();
				   }
				   strDigit2= new StringBuffer();
				  
			   }
			   str= new StringBuffer(); 
		   }
		   pout.close();  
		   fout.close();
		  
		 }  
}
