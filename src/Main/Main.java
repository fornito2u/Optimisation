package Main;

import java.util.Scanner;

import Model.IntCouple;
import Model.Model;
import Model.Task;

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
		if(i1 < 0)
		{
			System.out.println("Incorrect value, try again");
			s1 = sc.nextLine();
			i1 = Integer.parseInt(s1);
		}
		System.out.println("How many tasks ?");
		s2 = sc.nextLine();
		i2 = Integer.parseInt(s2);
		if(i2 < 0)
		{
			System.out.println("Incorrect value, try again");
			s2 = sc.nextLine();
			i2 = Integer.parseInt(s2);
		}
		Model model = new Model(i1, i2);
		
		System.out.println("Choose your algorithme : - Enter 1 for a simulated recuit"
				+ "									 - Enter 2 for a taboo research");
		s3 = sc.nextLine();
		i3 = Integer.parseInt(s3);
		if(i3 < 1 || i3 > 3)
		{
			System.out.println("Incorrect value, try again");
			s3 = sc.nextLine();
			i3 = Integer.parseInt(s3);
		}
		
		if(i3 == 1)
		{
			System.out.println("Yolo 1");
		}
		else
		{
			if(model.getProcessorList().size() >= 2)
			{
				Task t0 = model.getTaskList().get(0);
				Task t1 = model.getTaskList().get(1);
				Task t2 = model.getTaskList().get(2);
				Task t3 = model.getTaskList().get(3);
				model.getProcessorList().get(0).addTaskToProcessor(t0);
				model.getProcessorList().get(1).addTaskToProcessor(t1);
				model.getProcessorList().get(1).addTaskToProcessor(t2);
				model.getProcessorList().get(1).addTaskToProcessor(t3);
				model.globalTaskUpdate();
				System.out.println(model.allTaskAffected());
				System.out.println("-------");
				IntCouple ic = new IntCouple(0,0);
				ic = model.one_Task_Taboo_Sucessor(t0);
				System.out.println(" X : " + ic.getX() + " Y : " +  ic.getY());
			}
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
