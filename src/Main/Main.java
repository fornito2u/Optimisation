package Main;

import java.util.Scanner;

import Model.Model;

/**
 * @author Marvin
 *
 */
public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc  = new Scanner(System.in);
		String s1 = "";
		int i1 = -1;
		String s2 = "";
		int i2 = -1;
		String s3 = "";
		int i3 = -1;
		System.out.println("How many processor ?");
		s1 = sc.nextLine();
		i1 = Integer.parseInt(s1);
		if(i1 <= 0)
		{
			System.out.println("Incorrect value, try again");
			s1 = sc.nextLine();
			i1 = Integer.parseInt(s1);
		}
		System.out.println("How many tasks ?");
		s2 = sc.nextLine();
		i2 = Integer.parseInt(s2);
		if(i2 <= 0)
		{
			System.out.println("Incorrect value, try again");
			s2 = sc.nextLine();
			i2 = Integer.parseInt(s2);
		}
		Model model = new Model(i1, i2);
		
		System.out.println("Choose your algorithme : - Enter 1 for a simulated recuit"
				+ "									 - Enter 2 for a taboo research");
		if(i3 < 1 || i3 > 3)
		{
			System.out.println("Incorrect value, try again");
			s3 = sc.nextLine();
			i3 = Integer.parseInt(s3);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Main [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
