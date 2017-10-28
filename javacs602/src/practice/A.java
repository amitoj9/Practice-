package practice;

public class A {
	int a,b,c;

	public A(int a) {
		super();
		this.a = a;
		System.out.println("ab"+a);
	}
	public A() {
		super();
	System.out.println("b");
	}
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
}
