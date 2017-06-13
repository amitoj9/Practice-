package javacs602;

public class SingleObject {
private SingleObject()
{
}
private static final SingleObject instance= new SingleObject();
public static SingleObject getInstance()
{
	return instance;
}
public SingleObject(int a)
{
	System.out.println(a);
}
public void showMessage()
{
	System.out.println("SingleObject class");
}

}
