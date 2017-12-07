import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Event {

	String eventId;    
	double eventPrice;    
	int eventDistance; 
	static int finalId = 0;
	MainActivity m = new MainActivity();
	private static String id;
	private static ArrayList<Double> TicketPrices = new ArrayList<Double>();

	public Event(String s, double p, int d)
	{
		eventId = s; 
		eventPrice = p;
		eventDistance = d;
	}
	public static String GetId()
	{
		finalId++;
		id = id + finalId;
		if (finalId > 9)
		{
			String newFinalId = id.substring(1, id.length());
			id = newFinalId;
		}
		return id;
	}
	public static double CheapTicketSearch()
	{
		double min = 1;
		for (int i = 0; i < 10; i++)
		{
			Random r = new Random();
			TicketPrices.add(r.nextDouble() - min);
		}		
		double smallValue = 0.0;
		for (int i = 0; i < TicketPrices.size(); i++)
		{
			if (TicketPrices.get(i) < smallValue)
			{
				smallValue = TicketPrices.get(i);
			}
		}
		return smallValue;
	}	
}


