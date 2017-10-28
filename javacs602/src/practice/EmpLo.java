package practice;

import java.util.ArrayList;
import java.util.Collections;

public class EmpLo implements Comparable<EmpLo>{

	int empno;
	int age;
	String fName;
	String lName;
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public EmpLo() {
		this.empno = 01000;
		this.age = 18;
	}
	public EmpLo(int empno, int age) {
		super();
		this.empno = empno;
		this.age = age;
	}
	public String toString()
	{
		return empno+"  "+age;
	}

	public static void main(String args[])
	{
	
		ArrayList<EmpLo> list=new ArrayList<EmpLo>();
		EmpLo asdf= new EmpLo();
		EmpLo asdf3= new EmpLo();
		list.add(new EmpLo(10,15));
		list.add(new EmpLo(10,115));
		list.add(new EmpLo(10,145));
		list.add(new EmpLo(10,5));
		list.add(new EmpLo(10,415));
		Collections.sort(list,new AgeCompartator());
//		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
	}

	@Override
	public int compareTo(EmpLo arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

/*	@Override
	public int compareTo(EmpLo arg0) {
		// TODO Auto-generated method stub
		if(arg0.age==age)
		{
			return 0;
		}
		else
			if(arg0.age<age)
			{
				return 1;
			}
			else 
				return -1;
	}*/
}
