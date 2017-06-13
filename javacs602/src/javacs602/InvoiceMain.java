package javacs602;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InvoiceMain {

	public static void main(String args[])
	{
		Invoice invoice=new Invoice();
		Invoice invoice2=new Invoice();
		Invoice invoice3=new Invoice();
		Invoice invoice4=new Invoice();
		Invoice invoice5=new Invoice();
		Invoice invoice6=new Invoice();
		Invoice invoice7=new Invoice();
		Invoice invoice8=new Invoice();
		invoice.setPartDescription("Electric sander");
		invoice2.setPartDescription("Power saw");
		invoice3.setPartDescription("Sledge hammer");
		invoice4.setPartDescription("Hammer");
		invoice5.setPartDescription("Lawn mower");
		invoice6.setPartDescription("Screwdriver");
		invoice7.setPartDescription("Jig saw");
		invoice8.setPartDescription("Wrench");
		ArrayList<Invoice> arr= new ArrayList<Invoice>();
		arr.add(invoice);
		arr.add(invoice2);
		arr.add(invoice3);
		arr.add(invoice4);
		arr.add(invoice5);
		arr.add(invoice6);
		arr.add(invoice7);
		arr.add(invoice8);
		
		sortPartDescription(arr);
	}
	public static void sortPartDescription(ArrayList<Invoice> arr)
	{
		Collections.sort(arr,(Invoice i1,Invoice i2)->i1.getPartDescription().compareTo(i2.getPartDescription()));
		for(Invoice i:arr)
		{
			System.out.println(i.getPartDescription());
		}
		System.out.println();
		 Comparator<Invoice> byEmployeeNumber = (e1, e2) ->
		            e1.getPartDescription().compareTo(e2.getPartDescription());

		 arr.stream().sorted(byEmployeeNumber)
		            .forEach(e -> System.out.println(e.getPartDescription()));
	}
}
