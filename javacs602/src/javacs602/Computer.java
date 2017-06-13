package javacs602;

public class Computer {
private String hdd;
private String ram;
private boolean isGraphicCardEnabeled;
public String getHdd() {
	return hdd;
}
public String getRam() {
	return ram;
}
public boolean isGraphicCardEnabeled() {
	return isGraphicCardEnabeled;
}
private Computer(String hdd, String ram, boolean isGraphicCardEnabeled) {
	
	this.hdd = hdd;
	this.ram = ram;
	this.isGraphicCardEnabeled = isGraphicCardEnabeled;
}
public String toString()
{
	return hdd+"  "+ram+" "+isGraphicCardEnabeled;
}

public Computer(ComputerBuilder computerBuilder) {
	// TODO Auto-generated constructor stub

	this.hdd = computerBuilder.hdd;
	this.ram = computerBuilder.ram;
	this.isGraphicCardEnabeled = computerBuilder.isGraphicCardEnabeled;
}


public static class ComputerBuilder
{
	private String hdd;
	private String ram;
	private boolean isGraphicCardEnabeled;
	public ComputerBuilder (String hdd, String ram,Boolean isGraphicCardEnabeled)
	{
		this.ram=ram;
		this.hdd=hdd;
		this.isGraphicCardEnabeled=isGraphicCardEnabeled;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public void setGraphicCardEnabeled(boolean isGraphicCardEnabeled) {
		this.isGraphicCardEnabeled = isGraphicCardEnabeled;
	}
	public Computer build()
	{
		return new Computer(this);
	}
}
}