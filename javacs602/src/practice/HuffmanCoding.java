package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class HuffmanCoding {
    private static final int R = 256;
	public static void main(String args[])
	{
		try{
		ArrayList<Integer> arra=new ArrayList<Integer>();
		
		FileReader fin=new FileReader("mfile.txt");  
	    int i=0;  
	    while((i=fin.read())!=-1){  
	     arra.add(i);
	     
	    }  
	    BufferedReader fina= new BufferedReader(fin);
		CopyOnWriteArrayList<Node> asd= new CopyOnWriteArrayList<Node>();
		Node n =new Node();
		n.setAsci(arra.get(0));
		n.setCount(1);
		n.setCharct((char)(int)arra.get(0)+"");
		asd.add(n);
		int count=0;
		boolean flag=false;
		for(i=1;i<arra.size();i++)
		{
			n =new Node();
			for(int j=0; j<count;j++)
			{
				if(arra.get(i)==asd.get(j).getAsci())
				{
					flag=true;
					count=j;
					break;
				}
				else
				{flag=false;
				}	
			}
			if(flag)
			{
				asd.get(count).setCount(asd.get(count).getCount()+1);
				
			}
			else
			{
				n.setAsci(arra.get(i));
				n.setCount(1);
				n.setCharct((char)(int)arra.get(i)+"");
				asd.add(n);
				count++;
				
			}
		}
		asd=sort(asd);
		int size=asd.size();
		int maxCount=asd.get(0).getCount();
		CopyOnWriteArrayList<CopyOnWriteArrayList<Node>> temparrays= new CopyOnWriteArrayList<CopyOnWriteArrayList<Node>>();
		do
		{
			temparrays= generateSlotMethod(asd);
			asd=mergeSlots(temparrays);
			asd=sort(asd);
			
		}while(temparrays.size()>1);
			int slots[] = new int[temparrays.size()];
			
			
		}	
	catch(Exception e)
	{
	System.out.println(e);	
	}
	}
	public static CopyOnWriteArrayList<Node> mergeSlots(CopyOnWriteArrayList<CopyOnWriteArrayList<Node>> temparrays)
	{
		try{
		CopyOnWriteArrayList<Node> temp;
		CopyOnWriteArrayList<Node> fin=new CopyOnWriteArrayList<Node>();
		Node fi1=new Node();
		Node fi2=new Node();
		Node n =null;
		int count=0;
		for(int i=temparrays.size()-1;i>=0;i--)
		{
			temp= new CopyOnWriteArrayList<Node>();
			temp=temparrays.get(i);
			if(n!=null)
			{
				temp.add(n);
				n=null;
			}
			if(temp.size()%2!=0)
			{
				int size=temp.size();
				n=temp.get(size-1);
				temp.remove(size-1);
				
			}
			else
			{
				
				


				fi1=new Node();
				fi1=(Node)temp.get(0).clone();
				fi2=new Node();
				fi2=(Node)temp.get(1).clone();
				fi2.setBinRep(fi1.getBinRep()+"0");
				
				fi2.setCharct(fi2.getCharct()+""+fi1.getCharct());
				fin.add(fi2);
				count=1;
				for(int intern = 2;intern<temp.size();intern=+2)
				{
						fi1=new Node();
						fi2=new Node();
						fi1=(Node)temp.get(intern).clone();
						if(count%2==0)
						fi2.setBinRep(fi1.getBinRep()+"0");
						else
							fi2.setBinRep(fi1.getBinRep()+"1");
						
						
						fi2=(Node)temp.get(intern+1).clone();
						fi2.setCharct(fi2.getCharct()+""+fi1.getCharct());
						fin.add(fi2);
						count++;
				}
			
			}
		}
		return fin;
		}catch(Exception e)
		{
		System.out.println(e);	
		}
		return null;
	}
	public static CopyOnWriteArrayList<CopyOnWriteArrayList<Node>> generateSlotMethod(CopyOnWriteArrayList<Node>  asd)
	{
		try{
		int size=asd.size();
		int maxCount=asd.get(0).getCount();
		CopyOnWriteArrayList<CopyOnWriteArrayList<Node>> temparrays= new CopyOnWriteArrayList<CopyOnWriteArrayList<Node>>();
		CopyOnWriteArrayList<Node> temp; 
			Node ntemp = new Node();
			temp = new CopyOnWriteArrayList<Node>();
			for(int m=0;m<asd.size();m++)
			{				
				if(maxCount!=asd.get(m).getCount())
				{
					maxCount=asd.get(m).getCount();
					temparrays.add(temp);
					temp = new CopyOnWriteArrayList<Node>();
					ntemp = (Node)asd.get(m).clone();
					temp.add(ntemp);
				}
				else
				{
					ntemp = (Node)asd.get(m).clone();
					temp.add(ntemp);
				}
				if(m==asd.size()-1)
				{
					maxCount=asd.get(m).getCount();
					temparrays.add(temp);
				}
			}
			return temparrays;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public static CopyOnWriteArrayList<Node> sort(CopyOnWriteArrayList<Node> array) {
        if (array.size() == 0) {
            return null;
        }
        try{
        for(int i=0;i<array.size();i++)
        {
        	int index=0;
        	for(int j=i+1;j<array.size();j++)
        	{
        		if(array.get(i).getCount()<array.get(j).getCount())
        		{
        			  index=j;
        			Node temp= new Node();
        			temp=(Node)array.get(index).clone();
        			array.get(index).setCount(array.get(i).getCount());
        			array.get(index).setAsci(array.get(i).getAsci());
        			array.get(index).setCharct(array.get(i).getCharct());
        			array.get(i).setCount(temp.getCount());
        			array.get(i).setAsci(temp.getAsci());
        			array.get(i).setCharct(temp.getCharct());
        		}
        	}
        }
        array.get(0).setBinRep("0");
        array.get(1).setBinRep("1");
        for(int i=2;i<array.size();i++)
        {
        	
        	if(i%2==0)
        	{
        		array.get(i).setBinRep("0");
        	}
        	else
        	{
        		array.get(i).setBinRep("1");
        	}
        }
        System.out.println(array);
        return array;
        }
        catch(Exception e)
        {
        	
        }
        return null;
    }

}
