package practice;

import java.util.Comparator;

public class AgeCompartator implements Comparator<EmpLo>{
public int compare(EmpLo emp1,EmpLo emp2)
{
	if(emp1.age==emp2.age)
	{
		return 0;
	}
	else if(emp1.age>emp2.age)
	{
		return 1;
	}
	else return -1;
}
}
