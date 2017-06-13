package hackerRankPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashTableRansomNote {
	
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int m = in.nextInt();
	        int n = in.nextInt();
	        String magazine[] = new String[m];
	        for(int magazine_i=0; magazine_i < m; magazine_i++){
	            magazine[magazine_i] = in.next();
	        }
	        String ransom[] = new String[n];
	        for(int ransom_i=0; ransom_i < n; ransom_i++){
	            ransom[ransom_i] = in.next();
	        }
	        HashMap<String, Integer> mag= new HashMap<String,Integer>();
	        HashMap<String, Integer> ran= new HashMap<String,Integer>();
	        
	        for(String s:magazine)
	        {
	        	int count=0;
	        	count= mag.containsKey(s) ? mag.get(s):1 ;
	        	mag.put(s, count=count+1);
	        	
	        }
	        for(String s:magazine)
	        {
	        	int count=0;
	        	count= ran.containsKey(s) ? mag.get(s):1 ;
	        	ran.put(s, count=count+1);
	        	
	        }
	        boolean key=false;
	        if(m<n)
	        {
	        	System.out.println(key);
	        }
	        else {
	        	for( Map.Entry md: ran.entrySet())
		        {
		        	key=mag.containsKey(md.getKey());
		        	if(!key) {
		        		key=false;
		        		break;
		        	}
		        	else {
		        		key=true;
		        		int count=mag.get(md.getKey());
		        		if(count<(int)md.getValue())
		        		{
		        			key=false;
		        			break;
		        		}
		        		
		        	}
		        
		        }
		        System.out.println(key);
	        }
	        
	        
	    }
}
