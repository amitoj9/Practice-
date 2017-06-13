package practice;

import java.util.ArrayList;

public class ArrayListPract {

	public static void main(String args[])
	{
		ArrayList arr= new ArrayList();
		arr.add("amitoj");
		arr.add("amitoj");
		arr.add(1231);
		arr.add(2, "Japneet");
		Object obj=arr.remove(1);
		System.out.println(obj);
		for(int i=0; i<arr.size();i++)
			System.out.print(arr.get(i));
				
	}
}
