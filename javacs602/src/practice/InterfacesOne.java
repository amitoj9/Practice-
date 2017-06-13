package practice;

interface MyInter
{
	void connect();
	void disconnect();
}

class oracleDB implements MyInter
{
	public void connect()
	{
		System.out.println("connecting to oracleDB.......");
	}
	public void disconnect()
	{
		System.out.println("ending connection");
	}
}
class sybase implements MyInter
{
	public void connect()
	{
		System.out.println("connecting to sybaseDB.......");
	}
	public void disconnect()
	{
		System.out.println("ending connection");
	}
}
public class InterfacesOne 
{
	public static void main(String args[]) throws Exception
	{
		Class c=Class.forName(args[0]);
		MyInter mi=(MyInter)c.newInstance();
		mi.connect();
		mi.disconnect();
	}
}
