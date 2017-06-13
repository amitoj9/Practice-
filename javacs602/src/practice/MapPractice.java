package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapPractice {
	public static void main(String args[])
	{
		HashMap<Integer,Emp> hash= new HashMap<>();
		hash.put(1, new Emp(10,15));
		hash.put(5, new Emp(11,15));
		hash.put(4, new Emp(12,45));
		hash.put(3, new Emp(14,35));
		hash.put(2, new Emp(10,25));
		hash.put(null, null);
		hash.put(25, null);
		for(Map.Entry e: hash.entrySet())
		{
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		
		HashMap<Integer,Emp> hashCopy= new HashMap<>();
		hashCopy.put(1, new Emp(10,15));
		hashCopy.putAll(hash);
		Set<Integer> test=hashCopy.keySet();
		for(Integer e:test)
		{
			System.out.println("Key is "+e+"Value is "+hashCopy.get(e));
		}
		for(Map.Entry e: hash.entrySet())
		{
			if(hash.containsKey(10))
			{System.out.println(e.getKey()+"  "+e.getValue());}
			else{System.out.println("amitoj");}
			
		}
		hash.clear();
		Set<Entry<Integer, Emp>> pract=hash.entrySet();
		for(Entry<Integer,Emp> e:pract)
		{
			System.out.println(e.getKey()+"  amitoj  "+e.getValue());
		}
		HashMap<Emp,Integer> testingE=new HashMap<>();
		testingE.put(new Emp(10,15), 150);
		testingE.put(new Emp(8,15), 150);
		testingE.put(new Emp(10,15), 150);
		testingE.put(new Emp(12,15), 150);
		testingE.put(new Emp(13,15), 150);
		testingE.put(new Emp(11,15), 150);
	Set<Entry<Emp,Integer>> setTestingE=testingE.entrySet();
	for(Entry <Emp,Integer> e:setTestingE)
	{
		System.out.println(e.getKey()+" Singh "+e.getValue());
	}
	System.out.println("Check Key "+testingE.containsKey(new Emp(10,15)));
	testingE.remove(new Emp(10,15));
	System.out.println("Check Key "+testingE.containsKey(new Emp(10,15)));
	}
	public static class Emp
	{
		int empNum;
		int sal;
		public int getEmpNum() {
			return empNum;
		}
		public void setEmpNum(int empNum) {
			this.empNum = empNum;
		}
		public Emp(int empNum, int sal) {
			super();
			this.empNum = empNum;
			this.sal = sal;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
		public String toString()
		{
			return empNum+" "+ sal;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + empNum;
			result = prime * result + sal;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Emp other = (Emp) obj;
			if (empNum != other.empNum)
				return false;
			if (sal != other.sal)
				return false;
			return true;
		}
	}

}
