package javacs602;

import java.util.ArrayList;

public class StudentMain {

	public static void main (String args[])
	{
		ArrayList<Student> ss= new ArrayList<Student>();
		
		Student s= new Student(1,"anmut");
		Student s2= new Student(1,"anddt");
		Student s1= new Student(1,"a2ut");
		Student s5= new Student(1,"an");
		ss.add(s5);
		ss.add(s);
		ss.add(s2);
		ss.add(s1);
		for(Student student:ss)
		{
			System.out.println(student);
		}
		System.out.println("modify list");
		modifyList(ss);
		for(Student student:ss)
		{
			System.out.println(student);
		}
	}
	
	
	public static void modifyList(ArrayList<Student> ss)
	{
		Student s= new Student(1,"anmut");
		Student s2= new Student(1,"anddtee");
		Student s1= new Student(1,"a2uet");
		Student s5= new Student(1,"aen");
		ss.add(s5);
		ss.add(s);
		ss.add(s2);
		ss.add(s1);
		
	}
}
