package javacs602;

public class Student {

	int sId;
	String name;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int sId, String name) {
		super();
		this.sId = sId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + "]";
	}
	
}
