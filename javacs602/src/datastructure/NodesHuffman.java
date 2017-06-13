package datastructure;

//SINGH AMITOJ cs610 5449 prp
/*
* @author amitoj singh
* page rank algorithm
* 
*/
public class NodesHuffman implements Comparable<NodesHuffman> {

	public int value;
    public int weight;
    public NodesHuffman leftTree;
    public NodesHuffman rightTree;
    public NodesHuffman parent;

    // constructors
    public NodesHuffman() {
        parent = null;
    }

    public NodesHuffman( int v, int w, NodesHuffman lTree, NodesHuffman rTree, NodesHuffman par ) {
        value = v;
        weight = w;
        leftTree = lTree;
        rightTree = rTree;
        parent = par;
     }
    @Override
    public int compareTo(NodesHuffman rhs) {
        return weight - rhs.weight;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.value;
        return str;
    }
}