package practice;

import java.util.Scanner;

public class ConvertToWords {
    
    private static final String[] twodigit = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] onedigit = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    public static String word="";
    public static void convert(int num )
    {
        String input = Integer.toString(num);
//		System.out.println(input);
        int len=input.length(); 
        if (len==1)
            word += onedigit[num];
        if (len ==2)
            {
                if(num <20)
                    word += onedigit[num];
                else
                {
                    word += twodigit[num/10];
                    word += onedigit[num%10];
                }
            }
        if (len ==3)
            {
                word += onedigit[num/100];
                word += " hundred";
                num= num%100;
                if(num <20)
                    word += onedigit[num];
                else
                {
                    word += twodigit[num/10];
                    word += onedigit[num%10];
                }
            }
        if (len>3 && len <=6)
        {
            convert(num/1000);
            word += " thousand";
            convert(num%1000);
        }
         if (len>6 && len <=9)
        {
            convert(num/1000000);
            word += " million";
            convert(num%1000000);
        }
        
    }
	public static void main (String[] args) {
	    Scanner sc =new Scanner(System.in);
	    
		System.out.println("Enter upto 9 digit num");
		int num= sc.nextInt();
		System.out.println(num);
		
		convert(num);
		System.out.println(word);
	}
}
