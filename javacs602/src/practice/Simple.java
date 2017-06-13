package practice;

class Test implements Test1,Test2{



@Override
public final int calPer(int i) {
	// TODO Auto-generated method stub
	System.out.println(i);
	return 0;
}
};
class Simple extends Test
{
	public static void testPrint()
	{
		Test test=new Test();
		test.calPer(5);
	}
	public static void main(String... args)
	{
		System.out.println("Hello");
		Test2 test2=new Simple();
		test2.calPer(0);
		Test1 test1=new Simple();
		test1.calPer(03);
		testPrint();
	}
}