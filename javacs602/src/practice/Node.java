package practice;

public class Node implements Cloneable {
	private int asci;
	private int count;
	private String binRep;
	private String charct;
	public  Node leftChild;  // Not null
	
	public Node rightChild;  // Not null
	
	public String getCharct() {
		return charct;
	}

	public void setCharct(String charct) {
		this.charct = charct;
	}

	@Override
	public String toString() {
		return "Node [asci=" + asci + ", count=" + count + ", binRep=" + binRep + ", charct=" + charct + "]";
	}

	public Node() {

	}



	public Node(int asci, int count, String binRep, String charct) {
		super();
		this.asci = asci;
		this.count = count;
		this.binRep = binRep;
		this.charct = charct;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getAsci() {
		return asci;
	}

	public void setAsci(int asci) {
		this.asci = asci;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBinRep() {
		return binRep;
	}

	public void setBinRep(String binRep) {
		this.binRep = binRep;
	}

}
