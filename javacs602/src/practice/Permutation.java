package practice;

import java.util.ArrayList;
import java.util.Scanner;

class Permutation {
 
	static ArrayList<ArrayList<Integer>> aa= new ArrayList<ArrayList<Integer>>();

    static void expectedAmount(int[] a) {
        // Complete this function
    	aa= new ArrayList<ArrayList<Integer>>();
       permute(a,0);
        int units=0;
       int coins[]= new int[3];
        for(int i=0;i<3;i++)
        {
            coins[i]=-1;
        }
       int visitedNumber[]= new int [3];
         for(int i=0;i<3;i++)
        {
            visitedNumber[i]=0;
        }
        for(int i=0;i<aa.size();i++)
        {
            ArrayList<Integer> asd=aa.get(i);
	        for(int kk=0;kk<asd.size();kk++)
            {
                if(coins[1]==-1)
                {
                    coins[1]=asd.get(kk);
                    visitedNumber[1]++;
                }
                else if(coins[1]>asd.get(kk))
                {visitedNumber[1]++;
                    if(coins[0]==-1)
                    {
                        coins[0]=asd.get(kk);
                        visitedNumber[0]++;
                    }
                    else
                    {
                        visitedNumber[0]++;
                        units+=asd.get(kk);
                    }
                }
                else
                {visitedNumber[1]++;
                    if(coins[2]==-1)
                    {
                        
                        coins[2]=asd.get(kk);
                        visitedNumber[2]++;
                        
                    }
                    else
                    {
                        visitedNumber[2]++;
                        units+=asd.get(kk);
                    }
                }
                
            }
            
            for(int ms=0;ms<3;ms++)
            {
                if(visitedNumber[ms]<=1&&coins[ms]!=-1)
                {
                     units+=coins[ms];
                }
            }
            for(int ss=0;ss<3;ss++)
            {
                coins[ss]=-1;
            }
             for(int ss=0;ss<3;ss++)
            {
                visitedNumber[ss]=0;
            }
            
        }
        System.out.println(units);
        
        
    }
    static void permute(int[] a, int k) 
    {
        if (k == a.length) 
        {
            ArrayList<Integer> as= new ArrayList<Integer>();
            
            for (int i = 0; i < a.length; i++) 
            {
                as.add(a[i]);
            }
            aa.add(as);
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            expectedAmount(a);
        }
        in.close();
    }
}
