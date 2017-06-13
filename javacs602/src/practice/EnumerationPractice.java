package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class EnumerationPractice {

	public static void main(String args[])
	{
		Vector<String> testing= new Vector<String>();
		testing.add("amitoj");
		testing.add("am2itoj");
		testing.add("ami3toj");
		testing.add("amito1j");
		testing.add("amit4oj");
		testing.add("amitoj");
		Enumeration<String> enumeration=testing.elements();
		while(enumeration.hasMoreElements())
		{
			System.out.println(enumeration.nextElement());
		}
		ArrayList<String> test1= new ArrayList<String>();
		test1.add("amitoj");
		test1.add("amitoj3");
		test1.add("amitoj1");
		test1.add("amitoj2");
		test1.add("amitoj4");
		test1.add("amitoj5");
		test1.add("amitoj1");
		Enumeration<String> en=Collections.enumeration(test1);
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
		
		
	}
}
