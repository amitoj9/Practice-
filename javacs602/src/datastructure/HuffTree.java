package datastructure;

import java.util.ArrayList;
import java.util.PriorityQueue;

public  class HuffTree {
    // fields
    private static int size = 0;
    private static NodesHuffman root = new NodesHuffman();
    private static PriorityQueue<NodesHuffman> huffQueue = new PriorityQueue();
    public static ArrayList<String> pathTable = new ArrayList();
    public static ArrayList<Character> valueTable = new ArrayList();

    // constructor
    public HuffTree(int[] freq, char[] code) {
        // get the counts
        this.size = freq.length;

        // throw exception if arrays are different sizes
        if (freq.length != code.length) {
        throw new UnsupportedOperationException("Error: Character and code length mismatch.");
        }

        // build huffQueue from frequencies given
        for (int i = 0; i < this.size; i++) {
            huffQueue.offer(new NodesHuffman(code[i], freq[i], null, null, null));
        }

        // build huffman tree from queue
        createTree();

        // build code table from huffman tree
        createTable(this.root, "");
    }

    // setters/getters

    /**
     * creates Huffman Tree from frequencies and values
     * @param null
     */
    private void createTree() {
        // while elements remain in huffQueue, add to tree
        while (huffQueue.size() > 1) {
            // pop off two minimum elements in huffQueue
        	NodesHuffman tempL = huffQueue.poll();
        	NodesHuffman tempR = huffQueue.poll();
            
            // create root for two minimum elements and build tree
        	NodesHuffman parent = new NodesHuffman(0, tempL.weight+tempR.weight, tempL, tempR, null);
            tempL.parent = parent;
            tempR.parent = parent;
            
            // add new tree back in huffQueue
            huffQueue.offer(parent);
            this.size++;
        }
        
        // set HuffTree root to remaining element in huffQueue
        this.root = huffQueue.peek();
    }

    /**
     * creates code table for a huffman tree
     * @param NodesHuffman -- root for tree, string -- for building paths
     */
    private void createTable(NodesHuffman curr, String str) {
        // if iterator is null, return
        if (curr == null) return;
        
        // else if leaf, display path and value
        if (curr.leftTree == null && curr.rightTree == null) {
            char tempChar;
            if (curr.value == 32)
                tempChar = ' ';
            
            if (curr.value == 10)
                tempChar = 'n';
            
            else 
                tempChar = (char)curr.value;
            // add value and path to code tables
            this.valueTable.add(tempChar);
            this.pathTable.add(str);
        }

        // add 0 if before moving to left child
        str += "0";
        // recursively call in pre-order
        createTable(curr.leftTree, str);
        
        // adjust path and add 1 before moving to right child
        str = str.substring(0, str.length()-1);
        str += "1";
        createTable(curr.rightTree, str);
    }

    /**
     * display given huffman tree using pre-order traversal
     * @param NodesHuffman -- root of tree to be displayed
     */
    // global variable used for representing 'levels' of tree
    String tacks = "";
    public void getTree(NodesHuffman curr) {
        // if iterator is null, return
        if (curr == null) return;
        
        // else if leaf, display level, weight, and value
        if (curr.leftTree == null && curr.rightTree == null) {
        	// case statements to handle displaying space and newline
        	switch (curr.value) {
        		case 32:
        			System.out.println(tacks + curr.weight + ": space");
        			break;
        		case 10:
        			System.out.println(tacks + curr.weight + ": nl");
        			break;
        		default:
        			System.out.println(tacks + curr.weight + ": " + (char)curr.value);
        			break;
        	}              
        }
        
        // else display level and weight
        else
            System.out.println(tacks + curr.weight);

        // increment level marker
        tacks += "- ";
        // recursively call in pre-order
        getTree(curr.leftTree);
        getTree(curr.rightTree);
        // decrement level marker
        tacks = tacks.substring(0, tacks.length()-2);
    }

    /**
     * returns size of a given huffman tree
     * @param HuffTree - to obtain size of
     * @return int -- size of tree
     */
    public int getSize() { return this.size; }

    /**
     * returns encoded bits for a given string
     * @param String -- to be encoded
     * @return String -- encoded version of original string
     */
    public String encode(char[] input){
        // create empty string to hold code
        String str = "";
        
        // iterate through given string
        for (int x = 0; x < input.length; x++) {
            // iterate through code tables
            for (int i = 0; i < valueTable.size(); i++) {
                // if char in string matches code in table, add path to string
                if (valueTable.get(i) == input[x])
                    str += pathTable.get(i);
            }
        }
        return str;
    }

    /**
     * returns decoded string for a given set of bits
     * @param String -- bits to be decoded
     * @return String -- decoded version of bits
     */
    public String decode(String bits) {
        // create empty string to hold decoded message
        String decodedStr = "";

        // iterate through bits
        for (int i = 0; i < bits.length(); i++) {
            if (!getChar(bits.substring(0, i+1)).equals("")) {
                decodedStr += getChar(bits.substring(0, i+1));
                bits = bits.substring(i+1);
                i = 0;
            }
        }
        return decodedStr;
    }

    /**
     * returns character for a given set of bits
     * @param String -- bits to be checked
     * @return String -- character associated with bits if any
     */
    private String getChar(String bits) {
    	// create string to hold potential character
        String character = "";
        	// traverse code table to seek match
            for (int i = 0; i < pathTable.size(); i++) {
                // add to string if match is found
            	if (pathTable.get(i).equals(bits))
                    character = valueTable.get(i).toString();
            }
        return character;
    }
}
