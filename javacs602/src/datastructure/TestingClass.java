package datastructure;

public class TestingClass {
	public static void main(String ...args)
	{
		SparseMatrix A= new SparseMatrix("-5r4c4, 5r1c4, 2r2c2, 5r3c1, -3r3c2, 6r4c2, -7r2c3, 3r1c1");
		SparseMatrix B= new SparseMatrix("1r4c4, 1r4c1, 1r3c3, 1r2c6, 1r2c2, 1r1c1, 1r1c5");
/*		SparseMatrix C = new SparseMatrix(5,6);
		SparseMatrix D = new SparseMatrix(6,5);
		SparseMatrix E = new SparseMatrix(200,200);
		SparseMatrix F = new SparseMatrix(200,1);
		SparseMatrix G = new SparseMatrix(30000,30000);

		//Initialize	
		C.initializeMatrix(5, 6);
		D.initializeMatrix(6, 5);
		E.initializeMatrix(200, 200);
		F.initializeMatrix(200, 1);
		G.initializeMatrix(30000, 30000);

		//  Print
		System.out.println("MATRIX A: ");
		A.print();
		System.out.println();
		System.out.println("MATRIX B: ");
		B.print();
		System.out.println();
		System.out.println("MATRIX C: ");
		C.print();
		System.out.println();
		System.out.println("MATRIX D: ");
		D.print();
		System.out.println();
		System.out.println("MATRIX E: ");
		E.print();
		System.out.println();
		System.out.println("MATRIX F: ");
		F.print();
		System.out.println();
		System.out.println("MATRIX G: ");
		G.print();
		System.out.println();

		//	Scalar Multiplication and Print
		System.out.println("MATRIX A after multiplying by 5:");
		SparseMatrix A5 = A.scalarMultiply(5);
		A5.print();
		System.out.println();
		System.out.println("MATRIX B after multiplying by 5:");
		SparseMatrix B5 = B.scalarMultiply(5);
		B5.print();
		System.out.println();
		System.out.println("MATRIX C after multiplying by 5:");
		SparseMatrix C5 = C.scalarMultiply(5);
		C5.print();
		System.out.println();
		System.out.println("MATRIX D after multiplying by 5:");
		SparseMatrix D5 = D.scalarMultiply(5);
		D5.print();
		System.out.println();
		System.out.println("MATRIX E after multiplying by 5:");
		SparseMatrix E5 = E.scalarMultiply(5);
		E5.print();
		System.out.println();
		System.out.println("MATRIX F after multiplying by 5:");
		SparseMatrix F5 = F.scalarMultiply(5);
		F5.print();
		System.out.println();
		System.out.println("MATRIX G after multiplying by 5:");
		SparseMatrix G5 = G.scalarMultiply(5);
		G5.print();
		System.out.println();

		//  equals method invocation	
		SparseMatrix array_of_matrices[] = new SparseMatrix[7];
		array_of_matrices[0] = A;
		array_of_matrices[1] = B;
		array_of_matrices[2] = C;
		array_of_matrices[3] = D;
		array_of_matrices[4] = E;
		array_of_matrices[5] = F;
		array_of_matrices[6] = G;


		char names[] = new char[7];
		names[0] = 'A';
		names[1] = 'B';
		names[2] = 'C';
		names[3] = 'D';
		names[4] = 'E';
		names[5] = 'F';
		names[6] = 'G';
		for(int i=0;i<7;i++)
		{	
			for(int j=0;j<7;j++)
			{
				if(array_of_matrices[i].equals(array_of_matrices[j])==true)
					System.out.println(names[i]+" is equal to "+names[j]);
				else
					System.out.println(names[i]+" is not equal to "+names[j]);
			}
		}

		System.out.println("--------------------------------STEP 2-------------------------------");
		//Adding each matrix with itself	
		System.out.println("Matrix A after adding with itself");
		SparseMatrix Aplus = A.add(A);
		Aplus.print();
		System.out.println("Matrix B after adding with itself");
		SparseMatrix Bplus = B.add(B);
		Bplus.print();
		System.out.println("Matrix C after adding with itself");
		SparseMatrix Cplus = C.add(C);
		Cplus.print();
		System.out.println("Matrix D after adding with itself");
		SparseMatrix Dplus = D.add(D);
		Dplus.print();
		System.out.println("Matrix E after adding with itself");
		SparseMatrix Eplus = E.add(E);
		Eplus.print();
		System.out.println("Matrix F after adding with itself");
		SparseMatrix Fplus = F.add(F);
		Fplus.print();
		System.out.println("Matrix G after adding with itself");
		SparseMatrix Gplus = G.add(G);
		Gplus.print();
		
		//Subtracting each matrix with itself	
		System.out.println("Matrix A after subtracting with itself");
		SparseMatrix Aminus = A.subtract(A);
		Aminus.print();
		System.out.println("Matrix B after subtracting with itself");
		SparseMatrix Bminus = B.subtract(B);
		Bminus.print();
		System.out.println("Matrix C after subtracting with itself");
		SparseMatrix Cminus = C.subtract(C);
		Cminus.print();
		System.out.println("Matrix D after subtracting with itself");
		SparseMatrix Dminus = D.subtract(D);
		Dminus.print();
		System.out.println("Matrix E after subtracting with itself");
		SparseMatrix Eminus = E.subtract(E);
		Eminus.print();
		System.out.println("Matrix F after subtracting with itself");
		SparseMatrix Fminus = F.subtract(F);
		Fminus.print();
		System.out.println("Matrix G after subtracting with itself");
		SparseMatrix Gminus = G.subtract(G);
		Gminus.print();
		
		//Subtracting each matrix with scalar multiplication of itself	
		System.out.println("5A - A");
		SparseMatrix A5minus = A5.subtract(A);
		A5minus.print();
		System.out.println("5B - B");
		SparseMatrix B5minus = B5.subtract(B);
		B5minus.print();
		System.out.println("5C - C");
		SparseMatrix C5minus = C5.subtract(C);
		C5minus.print();
		System.out.println("5D - D");
		SparseMatrix D5minus = D5.subtract(D);
		D5minus.print();
		System.out.println("5E - E");
		SparseMatrix E5minus = E5.subtract(E);
		E5minus.print();
		System.out.println("5F - F");
		SparseMatrix F5minus = F5.subtract(F);
		F5minus.print();
		System.out.println("5G - G");
		SparseMatrix G5minus = G5.subtract(G);
		G5minus.print();
*/		
		//Multiplication
		System.out.println();
		System.out.println("Rubal Test Mulitply A*A");
		A.multiply(B);
/*		SparseMatrix examp = A.transpose();
		examp.print();*/
	}
}
