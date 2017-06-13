package datastructure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//SINGH AMITOJ cs610 5449 prp
/*
 * @author amitoj singh
 * Decoding using Huffman algo
 * 
*/
public class hdec5449 {
//	Files to read the encoded value
	static File pathFile = new File("path.txt");
//	File to read the characters of file
	static File valueFile = new File("value.txt");

	public static void main(String args[]) {

		try {
			String filename = args[0];
//			Exception to be thrown when no file name found.
			if(filename==null)
			{
				throw new Exception("File name missing");
			}
//			Reading input huf file.
			FileReader fin = new FileReader(filename);

			HuffTree hTree = new HuffTree();

			String asd = hTree.decode(filename);
//			Splitting filename ex: as.txt.huf to get as.txt name
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(filename.split("\\.")[0] + "." + filename.split("\\.")[1]));
//			Writing data to file
			bufferedOutputStream.write(asd.getBytes());
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static class HuffTree {
		// fields
		private int size = 0;
		private NodesHuffman root = new NodesHuffman();
		private PriorityQueue<NodesHuffman> huffQueue = new PriorityQueue();
		public List<String> pathTable = new ArrayList();
		public List<Character> valueTable = new ArrayList();
		public static int currentByte = 0;
		public static int numBitsRemaining = 0;
		public int numBitsFilled = 0;

//		Decoding the huf file 
		public String decode(String fileName) throws Exception {
			String bits;
			// create empty string to hold decoded message
			String decodedStr = "";
//			Reading path file and creating its list 
			FileInputStream fis = new FileInputStream(pathFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			pathTable = (List<String>) ois.readObject();
			ois.close();
//			Reading value file and creating its list.
			FileInputStream fis2 = new FileInputStream(valueFile);
			ObjectInputStream ois2 = new ObjectInputStream(fis2);
			valueTable = (List<Character>) ois2.readObject();
			ois2.close();
//			method call to read huf file
			bits = readHuffFile(fileName);
			// iterate through bits
//			Value is checked in the path table If we found the matching record we remove that from bits and store that in decodedStr.
			for (int i = 0; i < bits.length(); i++) {
				if (!getChar(bits.substring(0, i + 1)).equals("")) {
					decodedStr += getChar(bits.substring(0, i + 1));
					bits = bits.substring(i + 1);
					i = 0;
				}
			}
			return decodedStr;
		}
//Method to read Huf file and unpacking the bytes.
		
		private static String readHuffFile(String fileName) {
			StringBuilder stringBuilder = new StringBuilder();
			int j = 0;
			try {
				InputStream is = new BufferedInputStream(new FileInputStream(fileName));
				while (true) {
					if (currentByte == -1)
						break;
					if (numBitsRemaining == 0) {
						currentByte = is.read();
						if (currentByte == -1)
							break;
						numBitsRemaining = 8;
					}
					if (numBitsRemaining <= 0)
						throw new AssertionError();
					numBitsRemaining--;
					stringBuilder.append(String.valueOf((currentByte >>> numBitsRemaining) & 1));
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stringBuilder.toString();
		}

		/*
		 * 
		 * @param String
		 *            -- bits to be checked
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

}
