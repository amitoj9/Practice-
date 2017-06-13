package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPractice {
	/**
	 * @param strings
	 */
	public static void main(String...strings)
	{
		List<Integer> a= new ArrayList<>();
		List<Integer> b= new ArrayList<>();
		a.add(10);
		a.add(20);
		a.add(40);
		b.add(1);
		b.add(4);
		b.add(12);
		b.add(51);
		b.add(105);
		b.add(125);
		int counterList1=0;
		int counterList2=0;
		List<Integer> mergeList=new ArrayList<>();
		while(counterList1<a.size()&&counterList2<b.size())
		{
			if(a.get(counterList1)<b.get(counterList2))
			{
				mergeList.add(a.get(counterList1));
				counterList1++;
			}
			else
			{
				mergeList.add(b.get(counterList2));
				counterList2++;
			}
		}
		Iterator iterator=mergeList.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(10))
					{
				iterator.remove();
					}
	}
		System.out.println(mergeList);
	}
}
