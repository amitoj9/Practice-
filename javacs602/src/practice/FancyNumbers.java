package practice;

public class FancyNumbers {

	public static void main(String args[])
	{
		
		String s="345333";
		 
		  int lastNumber=-1;
          if(s.length()==1)
          {
              System.out.println("NO");
          }
          
          else
          {
              int num=0;
              boolean flag=true;
              for(int i=0;i<s.length()/2;i++)
              {
                  flag=true;
                  for(int k=0;k<s.length()-i;k++)
	               		{
				         System.out.print(s.substring(k, k+i)+" ");
                      int currentNumber=Integer.parseInt(s.substring(k, k+i+1));
                      if(i>0&&currentNumber<10)
                      {
                          flag=false;
                          break;
                      }
                      if(lastNumber==-1)
                      {
                          lastNumber=currentNumber;
                      }
                      else
                      {
                          if(lastNumber+1==currentNumber&&flag==true)
                          {
                             if(flag&&k==1)
                               {
                          num=lastNumber;
                               }
                              lastNumber=currentNumber;   
                          }
                          else 
                          {
                              flag=false;
                          }
                              
                      }
                      
                      
			         }
                  if(flag)
                  {
                      System.out.println("YES "+num);
                  }
                  else
                  {System.out.println("NO ");
                  }
              }
          }
	}
}
