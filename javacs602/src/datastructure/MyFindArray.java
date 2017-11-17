package datastructure;

import java.util.Arrays;

public class MyFindArray implements FindArray {
	public  String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
       
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
            b.append("");
        }
    }


	@Override
	public int findArray(int[] array, int[] subArray) {
		// TODO Auto-generated method stub
		String ar=toString(array);
		System.out.println(ar);
		String sub=toString(subArray);
		System.out.println(sub);
		int position=-1;
		for(int i=0;i<=ar.length()-sub.length();i=i+sub.length())
		{
			if(sub.matches(ar.substring(i,i+ sub.length())))
			{
			position=i;
			}
		}
		return position;
	}

}
