package javacs602;

import java.security.SecureRandom;

public class Craps {
private static final SecureRandom random=new SecureRandom();
private enum Status {Continue,Won,Lost};
private static final int SNAKE_EYES=2;
private static final int TREY=3;
private static final int SEVEN=7;
private static final int YO_LEVEN=11;
private static final int BOX_CARDS=12;
public static void main(String args[])
{
	int myPoint=0;
	Status gameStatus=Status.Continue;
	int sumOfDice=rollDice();
	switch(sumOfDice)
	{
	case SEVEN:break;
	case YO_LEVEN:
		gameStatus=Status.Won;
		break;
	case SNAKE_EYES:break;
	case TREY:break;
	case BOX_CARDS:
		gameStatus=Status.Lost;
		break;
	default:
		gameStatus=Status.Continue;
		myPoint=sumOfDice;
		System.out.printf("Point is %d%n",myPoint);
		break;
	}
	while(gameStatus==Status.Continue)
	{
		sumOfDice=rollDice();
		if(sumOfDice==myPoint)
		{
		gameStatus=Status.Won;	
		}
		else
		{
			if(sumOfDice==SEVEN)
			{
				gameStatus=Status.Lost;
			}
		}
	}
	if(gameStatus==Status.Won)
	{
		System.out.println("Player Win");
	}
	else{
		System.out.println("Player loses");
	}
	}
	public static int rollDice()
	{
		int die1=1+random.nextInt(6);
		int die2=1+random.nextInt(6);
		int sum=die1+die2;
		System.out.printf("Player rolled %d+%d=%d%n",die1,die2,sum);
		
		return sum;
	}
}


