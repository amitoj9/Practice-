package datastructure.stacks;

public class FixedMultipleStack {
	private int numberOfStacks=3;
	private int stackCapacity;
	private int values[];
	private int sizes[];
	public FixedMultipleStack(int stackCapacity) {
		super();
		this.stackCapacity = stackCapacity;
		values=new int[stackCapacity*numberOfStacks];
		sizes=new int[numberOfStacks];
	}
	

}
