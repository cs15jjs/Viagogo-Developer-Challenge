import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainActivity {

	static Event[][] playingField = new Event[21][21];
	static int[][] topFive = new int[4][1];

	private static void AssignCoords()
	{

	}
	private static int CreateRandomData()
	{
		//assumption = there can be a maximum of 500 tickets
		int min = 1;
		int max = 500;
		Random rand = new Random();
		int finalNumber = rand.nextInt((max - min) + 1) + min;
		return finalNumber;
	}
	private static int CreateRandomCoord()
	{
		//create random co-ordinates
		int max = 20;
		Random rand = new Random();
		int finalNumber = rand.nextInt(max);
		return finalNumber;
	}
	private static void SearchMap(int x1, int y1)
	{
		int x2 = 0;	
		int y2 = 1;

		CheckLoop:
			for (int i = 0; i < 21; i++)
			{
				for (int j = 0; j < 21; j++)
				{
					if (((x1 - x2) + (y1 - y2)) < 5)
					{		
						topFive[x2][0] = i;
						topFive[x2][1] = j;
						x2++;
						y2++;
						if (x2 == 5) break CheckLoop;
					}
				}
			}

		int x3 = 0;
		for (int i = 0; i < 5; i++)
		{
			int new_x = topFive[x3][0];
			int new_y = topFive[x3][1];
			mDistance(x1, y1, new_x, new_y);
			x3++;
		}
	}
	public static int mDistance(int x1, int y1, int x2, int y2) 
	{
		//computing Manhattan Distance
		int x = Math.abs(x1 - x2);
		int y = Math.abs(y1 - y2);
		int z = (x + y);
		//Displaying Manhattan Distance
		System.out.println("Manhattan distance is:"+z);
		return z;
	}
	public static boolean Validation(int x_axis, int y_axis) 
	{
		if (x_axis > -10 && y_axis > -10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args) 
	{

		//		for (int i = 0; i < 21; i++)
		//		{
		//			for (int j = 0; j < 21; j++)
		//			{
		//				if (MainActivity.playingField[i][j] == null) 
		//				{
		//					Event f = new Event(Event.GetId(), Event.CheapTicketSearch(), 1);
		//					playingField[i][j] = f;
		//				}
		//			}
		//		}

		System.out.println("Please enter your co-ordinates in the form of:");
		System.out.println("x y");
		Scanner keyboard = new Scanner(System.in);
		String x = keyboard.nextLine();
		String input = x.toString();
		String[] splitStrings = input.split(" ");
		System.out.println(splitStrings[0]);
		String parse1 = splitStrings[0];
		String parse2 = splitStrings[1];
		int x_axis = Integer.parseInt(parse1);
		int y_axis = Integer.parseInt(parse2);

		if (Validation(x_axis, y_axis))
		{
			keyboard.close();
		}
		else
		{
			System.out.println("Values must be between -10 and 10...!!");
			System.out.println("Please re-enter your co-ordinates in the form of:");
			System.out.println("x,y");
			keyboard.next();
		}
		SearchMap(x_axis, y_axis);



	}
}


