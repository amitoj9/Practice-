package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListReverseSort {

	public static void main(String args[])
	{
		List<String> a=new ArrayList<String>();
		a.add("as");
		a.add("vs");
		a.add("ss");
		a.add("cs");
		a.add("es");
		a.add("rs");
		a.add("ks");
		Comparator  comparator=Collections.reverseOrder(); 
		for(String s:a)
		{
			System.out.print(s);
		}
		Collections.sort(a,comparator);
		
		System.out.println();
		for(String s:a)
		{
			System.out.print(s);
		}
		
	}
}
