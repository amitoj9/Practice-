package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovingElevator {
	
	public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	      int n = scanner.nextInt();
	      int k = scanner.nextInt();
	      
	      Pattern r = getRegex(n, k);
	      
	      int m = scanner.nextInt();
	      for (int i = 0; i < m; ++i) {
	        String s = scanner.next();
	        Matcher matcher = r.matcher(s);
	        System.out.println((matcher.matches() ? "YES" : "NO"));
	      }
	    }
	
	public static Pattern getRegex(int n, int k) {
    
		
		return Pattern.compile("[<>+-][0-"+"[n]");
	}



}
