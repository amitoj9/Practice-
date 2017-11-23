package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TwinStringOpt {
	
	public static void main(String argsp[])
	{
		String a[]= {"abcde"};
		String b[]= {"cdabe"};
		
		System.out.println(checkTwins(a,b));
		
	}
	
	public static String checkTwins(String [] a, String[] b)
	{
		
		HashMap<Character, Integer> evenCount=new HashMap<Character,Integer>();
		HashMap<Character, Integer> oddCount=new HashMap<Character,Integer>();
		int i=0,j=0;
		
		while(i<a.length)
		{
			String ss=a[i];
			
			for(int s=0;s<ss.length();s++)
			{
				if(s%2==0)
				{
					if(evenCount.containsKey(ss.charAt(s)))
					{
						evenCount.put(ss.charAt(s),(Integer)evenCount.get(ss.charAt(s))+1);
					}
					else
					{
						evenCount.put(ss.charAt(s), 1);
					}
				}
				else
				{
					if(oddCount.containsKey(ss.charAt(s)))
					{
						oddCount.put(ss.charAt(s),(Integer)oddCount.get(ss.charAt(s))+1);
					}
					else
					{
						oddCount.put(ss.charAt(s), 1);
					}
				}
			}
			i++;
		}
		
		while(j<a.length)
		{
			String ss=b[j];
			
			for(int s=0;s<ss.length();s++)
			{
				if(s%2==0)
				{
					if(evenCount.containsKey(ss.charAt(s)))
					{
						evenCount.put(ss.charAt(s),(Integer)evenCount.get(ss.charAt(s))-1);
					}
					else
					{
						evenCount.put(ss.charAt(s), -1);
						return "No";
					}
				}
				else
				{
					if(oddCount.containsKey(ss.charAt(s)))
					{
						oddCount.put(ss.charAt(s),(Integer)oddCount.get(ss.charAt(s))-1);
					}
					else
					{
						oddCount.put(ss.charAt(s), -1);
						return "No";
					}
				}
			}
			j++;
		}
		
		boolean flag=true;
		Iterator<Entry<Character, Integer>> ssa=evenCount.entrySet().iterator();
		while(ssa.hasNext())
		{
			Map.Entry<Character, Integer> entryA=ssa.next();
			
    		if(entryA.getValue()!=0)
    		{
    			flag=false;
    			return "No";
    			
    		}
		}
		
		Iterator<Entry<Character, Integer>> ssb=evenCount.entrySet().iterator();
		while(ssb.hasNext())
		{
			Map.Entry<Character, Integer> entryA=ssb.next();
			
    		if(entryA.getValue()!=0)
    		{
    			flag=false;
    			return "No";
    		}	
		}		
			
		
		return "Yes";

	}
}
