package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Splitwise {
	
	 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int aars[]=new int[m+1];
        Arrays.fill(aars, 0);
        
		int totalAmount=0;
        for(int a0 = 0; a0 < n; a0++){
            int id_number = in.nextInt();
            int amount = in.nextInt();
            aars[id_number]=aars[id_number]+amount;
            totalAmount+=amount;
            
        }
        int perHeadShare=totalAmount/m;
        int firstPersonShare=totalAmount-(perHeadShare*(m-1));
        for(int i=1;i<aars.length;i++)
        {
        	if(i==0)
        		System.out.println(i+1+" "+ (aars[i] -firstPersonShare));
        	else
        		System.out.println(i+1+" "+ (aars[i] -perHeadShare));
        }
        in.close();
    }

}
