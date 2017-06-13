package datastructure;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JFileChooser;

public class huffmanproject {

    public static class HuffNode implements Comparable<HuffNode> {
        // fields
        public int value;
        public int weight;
        public HuffNode leftTree;
        public HuffNode rightTree;
        public HuffNode parent;

        // constructors
        public HuffNode() {
            parent = null;
        }

        public HuffNode( int v, int w, HuffNode lTree, HuffNode rTree, HuffNode par ) {
            value = v;
            weight = w;
            leftTree = lTree;
            rightTree = rTree;
            parent = par;
         }
        
        // setters/getters
        
        @Override
        public int compareTo(HuffNode rhs) {
            return weight - rhs.weight;
        }

        @Override
        public String toString() {
            String str = "";
            str += this.value;
            return str;
        }
    }

    // object representing a huffman tree
    public static class HuffTree {
        // fields
        private int size = 0;
        private HuffNode root = new HuffNode();
        private PriorityQueue<HuffNode> huffQueue = new PriorityQueue();
        public ArrayList<String> pathTable = new ArrayList();
        public ArrayList<Character> valueTable = new ArrayList();

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
                huffQueue.offer(new HuffNode(code[i], freq[i], null, null, null));
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
                HuffNode tempL = huffQueue.poll();
                HuffNode tempR = huffQueue.poll();
                
                // create root for two minimum elements and build tree
                HuffNode parent = new HuffNode(0, tempL.weight+tempR.weight, tempL, tempR, null);
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
         * @param HuffNode -- root for tree, string -- for building paths
         */
        private void createTable(HuffNode curr, String str) {
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
         * @param HuffNode -- root of tree to be displayed
         */
        // global variable used for representing 'levels' of tree
        String tacks = "";
        public void getTree(HuffNode curr) {
            // if iterator is null, return
            if (curr == null) return;
            
            // else if leaf, display level, weight, and value
            if (curr.leftTree == null && curr.rightTree == null) {
            	// case statements to handle displaying space and newline
            	switch (curr.value) {
            		case 32:
            			System.out.println(tacks + curr.weight + ": sp");
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
        public String encode(String input){
            // create empty string to hold code
            String str = "";
            
            // iterate through given string
            for (int x = 0; x < input.length(); x++) {
                // iterate through code tables
                for (int i = 0; i < valueTable.size(); i++) {
                    // if char in string matches code in table, add path to string
                    if (valueTable.get(i) == input.charAt(x))
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

    // driver program -- main
        public static void main(String[] args) throws Exception {
            // fields
            int arr[]=new int[256]; 
    		char cha[]=new char[256];
    		ArrayList<Character> charArr=new ArrayList<Character>();
    		FileReader fin=new FileReader("myfile.txt");  
    	    int i=0;  
    	    while((i=fin.read())!=-1){  
    	    	if(i<=256){
    	    		arr[i]++;
       	    	 cha[i]=(char)i;	
    	    	}
    	    	 
    	    }
    	    int counter=0;
    	    for(int m=0;m<256;m++)
    	    {
    	    	if(arr[m]>0)
    	    		counter++;
    	    }
    	    int freq[] = new int[counter];
            char code[] = new char[counter];
            int j=0;
            for(int m=0;m<256;m++)
            {
            	if(arr[m]>0)
            	{
            		freq[j]=arr[m];
            		code[j]=cha[m];
            		j++;
            	}
            }
            // build Huffman Tree using given codes/frequencies
            HuffTree hTree = new HuffTree(freq, code);

            // display contents of Huffman Tree in Pre-Order Traversal
            System.out.println("Display Tree:");
            HuffNode curr = hTree.root;
            hTree.getTree(curr);
            System.out.println("");

            // encode 'tea'
            System.out.println("Encode 'tea': " + hTree.encode("aeistiii aeisti") +"\n");

            // decode 'tea' -- using the actual methods built in
            System.out.println("Decode '" + hTree.encode("aeistiii aeisti") + "': " + 
            								hTree.decode(hTree.encode("aeistiii aeisti")));
            
            final JFileChooser fc = new JFileChooser();
        }
}