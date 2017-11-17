package practice;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TwinString {
	public static void main(String argsp[])
	{
		String a[]= {"abbdd"};
		String b[]= {"ddbba"};
		
		System.out.println(twins(a,b)[0]);
	}
	 static String[] twins(String[] a, String[] b) {
	       String sa[]=new String[a.length];
	        for(int k=0;k<a.length;k++)
	        {
	        	int i=0,j=0;
	 	        TreeMap<Character, StringBuilder> charsA=new TreeMap<Character,StringBuilder>();
	 	        TreeMap<Character, StringBuilder> charsB=new TreeMap<Character,StringBuilder>();
	        	String sA=a[k];
	        	String sB=b[k];
	        	while(i<sA.length() && j<sB.length())
		        {
	        		if(charsA.containsKey(sA.charAt(i)))
	        		{
	        			charsA.put(sA.charAt(i),((StringBuilder)charsA.get(sA.charAt(i))).append(","+i));
	        		}
	        		else
	        		{
	        			charsA.put(sA.charAt(i),new StringBuilder(String.valueOf(i)));
	        		}
	        		if(charsB.containsKey(sB.charAt(j)))
	        		{
	        			charsB.put(sB.charAt(j),((StringBuilder)charsB.get(sB.charAt(j))).append(","+j));
	        		}
	        		else
	        		{
	        			charsB.put(sB.charAt(j),new StringBuilder(String.valueOf(j)));
	        		}
		        i++;
		        j++;
		        }
	        	
	        	Iterator<Map.Entry<Character,StringBuilder>> aas=charsA.entrySet().iterator();
	        	Set <Character> ss= charsB.keySet();
	        	Iterator<Map.Entry<Character,StringBuilder>> as=charsB.entrySet().iterator();
	        	boolean flag=true;
	        	while(aas.hasNext()&&as.hasNext())
	        	{
	        		Map.Entry<Character, StringBuilder> entryA=aas.next();
	        		Map.Entry<Character, StringBuilder> entryB=as.next();
	        		
	        		StringBuilder value=entryA.getValue();
	        		StringBuilder valB=entryB.getValue();
	        		if(entryA.getKey()!=entryB.getKey())
	        		{
	        			flag=false;
	        			break;
	        		}
	        		String first=value.toString();
	        		String second=valB.toString();
	        		String firstArr[]=first.split(",");
	        		String secArr[]=second.split(",");
	        		
	        		int m=0,n=0;
	        		int d=0;
	        		int sda=0;
	        		while(m<firstArr.length && n<secArr.length)
	        		{
	        			d+=Integer.parseInt(firstArr[m]);
	        			sda+=Integer.parseInt(secArr[n]);
	        			
	        			m++;
	        			n++;
	        		}
	        		if(Math.abs(d-sda)%2!=0)
        			{
        				flag=false;
        			}
	        	}
	        	System.out.println(flag);
	        	if(flag)
	        	{
	        		sa[k]="Yes";
	        	}
	        	else
	        		sa[k]="No";
	        	System.out.println(charsA);
	        	System.out.println(charsB);
	        	
	        }
	        
	        
	        

	        return sa;    
	        
	    }

}
