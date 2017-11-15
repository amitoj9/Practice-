package nqueen;

import java.util.Scanner;

public class NQueenBoardSolver {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the value of row/column in chess board");
		int n= sc.nextInt();
		
		int [][]board= new int[n][n];
		if(boardSolver(board, 0))
		System.out.println("Solution not found");		
		printBoard(board);
	}
	
	public static void printBoard(int board[][]) {
		for(int i=0;i<board.length;i++)
		{
			for( int j=0;j<board[i].length;j++)
			{
				if (board[i][j]==1)
				{
					System.out.print("Q\t");
				}
				else
					System.out.print("_\t");
			}
			System.out.println("\n");
		}
	}
	
	public static boolean boardSolver(int board[][], int col)
	{
		if(col>=board.length)
		{
			return true;
		}
		for( int i=0;i<board.length;i++)
		{
			if(toPlaceOrNotToPlace(board,i, col))
			{
				board[i][col]=1;
				if(boardSolver(board, col+1))
					return true;
				
				board[i][col]=0;
			}
			
		}
		
		
		return false;
	}
	
	public static boolean toPlaceOrNotToPlace( int board[][], int row, int col) {
		
		for(int i=0;i<col;i++)
		{
			if(board[row][i]==1)
				return false;
		}
		for(int i=row,  j=col;i>=0&&j>=0;i--,j--)
		{
			if(board[i][j]==1)
				return false;
		}
		for(int i=row,  j=col;j>=0 && i <board.length;i++,j--)
		{
			if(board[i][j]==1)
				return false;
		}
	
		return true;
	}
}
