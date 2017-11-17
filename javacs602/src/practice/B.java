package practice;

public class B  extends A{
	private int x;
	private int y;
	private int z;

	public int getX() {
		return x;
	}

	public B() {
		super();
		this.x = x;
		System.out.println("B");
	}

	public B(int x) {
		this();
		this.x = x;
		System.out.println("B"+x);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	private B(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		System.out.println(x+" "+y+" "+z);
	}
	public B(int x, int y)
	{
		this(x,y,40);
		
	}
	public static void main(String...strings)
	{
		B b =new B(2);
	}
	

}
