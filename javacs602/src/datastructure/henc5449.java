package datastructure;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//SINGH AMITOJ cs610 5449 prp
/*
 * @author amitoj singh
 * Encoding using Huffman algo
 * 
*/

public class henc5449 {

//	Files to store the encoded value
	static File pathFile = new File("path.txt");
//	File to store the characters of file
	static File valueFile = new File("value.txt");

	public static void main(String args[]) {

		try {
//			Initial int array of size 256 created for freq.
			int arr[] = new int[256];
//			Array to store character code.
			char cha[] = new char[256];
//			file name to encode
			String filename = args[0];
//			Exception to be thrown when no file name found.
			if(filename==null)
			{
				throw new Exception("File name missing");
			}
//			file reader operation
			FileReader fin = new FileReader(filename);
//			Using String builder instead of String because it is mutable String is not
			StringBuilder ss = new StringBuilder();
			int i = 0;
//			Reading file and store value in character array and String Builder and its frequency.
//			Getting asci value of characters and increasing its count.
			while ((i = fin.read()) != -1) {
				if (i <= 256) {
					arr[i]++;
					cha[i] = (char) i;
					ss.append((char) i);
				}

			}
//			Counter to count the number of elements that are not having zero frequency.
			int counter = 0;
			for (int m = 0; m < 256; m++) {
				if (arr[m] > 0)
					counter++;
			}
//			creating new array to store frequency and character code of non zero frequencies.
			int freq[] = new int[counter];
			char code[] = new char[counter];
			int j = 0;
			for (int m = 0; m < 256; m++) {
				if (arr[m] > 0) {
					freq[j] = arr[m];
					code[j] = cha[m];
					j++;
				}
			}
//			Creating object of HuffTree passing the frequency and codes.
			HuffTree hTree = new HuffTree(freq, code);
			NodesHuffman curr = hTree.root;
			
//			creating object for file output stream.
			FileOutputStream fout = new FileOutputStream(filename + ".huf");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			hTree.compress(ss.toString().toCharArray(), bout);
			bout.flush();
			bout.close();
			fout.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static class HuffTree {
		// creating and initializing fields.
		private int size = 0;
		private NodesHuffman root = new NodesHuffman();
		private PriorityQueue<NodesHuffman> huffQueue = new PriorityQueue();
		public List<String> pathTable = new ArrayList();
		public List<Character> valueTable = new ArrayList();
		public static int currentByte = 0;
		public static int numBitsRemaining = 0;
		public int numBitsFilled = 0;

		// constructor
		public HuffTree(int[] freq, char[] code) {
			// get the counts
			this.size = freq.length;
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
		 * 
		 * @param null
		 */
		private void createTree() {
			while (huffQueue.size() > 1) {
				// pop off two minimum elements in huffQueue
				NodesHuffman tempL = huffQueue.poll();
				NodesHuffman tempR = huffQueue.poll();

				// create root for two minimum elements and build tree
				NodesHuffman parent = new NodesHuffman(0, tempL.weight + tempR.weight, tempL, tempR, null);
				tempL.parent = parent;
				tempR.parent = parent;
				huffQueue.offer(parent);
				this.size++;
			}

			// set HuffTree root to remaining element in huffQueue
			this.root = huffQueue.peek();
		}
//	Create table of the generated code with values.
		private void createTable(NodesHuffman curr, String str) {
			// if iterator is null, return
			if (curr == null)
				return;

			// else if leaf, display path and value
			if (curr.leftTree == null && curr.rightTree == null) {
				char tempChar;
				
					tempChar = (char) curr.value;
				// add value and path to code tables
				this.valueTable.add(tempChar);
				this.pathTable.add(str);
			}

			// add 0 if before moving to left child
			str += "0";
			// recursively call in pre-order
			createTable(curr.leftTree, str);

			// adjust path and add 1 before moving to right child
			str = str.substring(0, str.length() - 1);
			str += "1";
			createTable(curr.rightTree, str);
		}
//  In this method we compress the input that is provided.
//	We also generate two files path and value. Path contains the code and value contains the character.
			public void compress(char[] input, BufferedOutputStream bout) throws Exception {
			FileOutputStream fos = new FileOutputStream(pathFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pathTable);
			oos.close();
			FileOutputStream fos2 = new FileOutputStream(valueFile);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(valueTable);
			oos2.close();
//			Here we are calling write function for every character.
			for (int i = 0; i < input.length; i++) {

				int b = input[i];
				if (b == -1)
					break;
				write(input[i], bout);

			}
		}
//  In this write function we are writing the data using Buffered Output Stream We are using a character for every 8 bit while writing the code this is called bit packing in Java.
		public void write(int i, BufferedOutputStream bout) throws IOException {
			int n = valueTable.indexOf((char) i);
			if (n == -1) {
				return;
			}
			String bits = pathTable.get(n);
			for (char b : bits.toCharArray()) {
				int mm = Character.getNumericValue(b);
				if (mm == -1)
					return;
				if (mm != 0 && mm != 1)
					throw new IllegalArgumentException("Argument must be 0 or 1");
				currentByte = (currentByte << 1) | mm;
				numBitsFilled++;
				if (numBitsFilled == 8) {
					bout.write(currentByte);
					currentByte = 0;
					numBitsFilled = 0;
				}
			}
		}
	}

}
