package practice;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTablePractice {

	public static void main(String args[])
	{
		Hashtable<String,String> test=new Hashtable<String,String>();
		test.put("amitoj", "singh");
		test.put("amitoj", "singh21");
		test.put("amitoj3", "singh2");
		test.put("amitoj4", "singh4");
		for(Map.Entry t:test.entrySet())
		{
			System.out.println(t.getValue()+"  "+t.getKey());
		}
		Set<String> e=test.keySet();
		for(String s:e)
		{
			System.out.println(s+test.get(s));
		}
		HashMap<String,String> ets=new HashMap<String,String>();
		ets.putAll(test);
		Set<String> asd=ets.keySet();
		for(String a:asd)
		{
			System.out.println(a+" "+ets.get(a));
		}
		Set<Entry<String,String>> asb=ets.entrySet();
		for(Entry<String,String> a:asb)
		{
			System.out.println(a.getValue()+a.getKey());
		}
		ets.clear();
		System.out.println(ets+" asdf ");
		Enumeration<String> afa=test.keys();
		while(afa.hasMoreElements())
		{
			String key=afa.nextElement();
			System.out.println(key+test.get(key)+"adasd");
		}
	}
}
