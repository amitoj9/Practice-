package dynamicprogramming;

public class CoinChangeRecursive {

	public static void main(String args[])
	{
		int coins[]= {2,3,5};
		System.out.println(makeChanges(coins,20,0));
	}
/*
	Without memoization
	
*/	public static long makeChanges(int []coins, int money,int index)
	{
		if(money==0)
			return 1;
		if(index>=coins.length)
			return 0;
		int amountWithCoin=0;
		long ways=0;
		while(amountWithCoin<=money)
		{
			int remainingAmount=money- amountWithCoin;
			
			ways+=makeChanges(coins, remainingAmount, index+1);
			amountWithCoin+=coins[index];
		}
		return ways;
	}

public static long makeChangesWithMemo(int []coins, int money,int index)
{
	if(money==0)
		return 1;
	if(index>=coins.length)
		return 0;
	int amountWithCoin=0;
	long ways=0;
	while(amountWithCoin<=money)
	{
		int remainingAmount=money- amountWithCoin;
		
		ways+=makeChanges(coins, remainingAmount, index+1);
		amountWithCoin+=coins[index];
	}
	return ways;
}

}
