package javacs602;

public class SingleObjectDemo extends SingleObject{
public SingleObjectDemo() {
	super(12);
	// TODO Auto-generated constructor stub
}
public static void main(String args[])
{
	SingleObject object=SingleObject.getInstance();
	object.showMessage();
	SingleObjectDemo demo=new SingleObjectDemo();
}
}
