package practice;

import java.util.HashMap;

public class SubStringPalindroms {
	static int palindromeCount(String s) {
	    
        int count=0;
        HashMap<String, Integer> ss= new HashMap<String, Integer>();
        for(int i=0;i<s.length();i++)
        {
            for(int k=i;k<s.length();k++)
            {
                if(!ss.containsKey(s.substring(i,k+1)))
                {
                    
                    if(checkIsPalindrome(s,i,k))
                     {
                    	ss.put(s.substring(i,k+1),0);
                        count++;
                     }
                }
            
            }
        }
        return ss.size();
    }

    static boolean checkIsPalindrome(String s,int i,int k)
    {
        while (i<k)
        {
            if(s.charAt(i)!=s.charAt(k))
            {
                return false;
            }
            i++;
            k--;
        }
        
        return true;
        
    }

    public static void main(String args[])
    {
    	
    }

}
