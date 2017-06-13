package practice;

import java.util.ArrayList;

public class ArrayListRemoveDuplicate {

	public static void main(String args[])
	{
		ArrayList<Integer>  testing=new ArrayList<Integer>();
		testing.add(1);
		testing.add(5);
		testing.add(4);
		testing.add(2);
		testing.add(1);testing.add(3);
		testing.add(12);
		testing.add(13);
		testing.add(11);testing.add(3);
		testing.add(14);
		testing.add(8);
		testing.add(8);
		for(int i=0;i<testing.size();i++)
		{
			for(int j=i+1;j<testing.size();j++)
			{
				if(testing.get(j)==testing.get(i))
				{
					testing.remove(j);
					j--;
				}
			}
		}
		for(Integer i:testing)
		{
			System.out.println(i);
		}
	}
}
