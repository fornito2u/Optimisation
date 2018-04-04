package Main;

import java.util.Scanner;

import Model.IntCouple;
import Model.Model;
import Model.Processor;
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
		while(i1 < 0)
		{
			System.out.println("Incorrect value, try again");
			s1 = sc.nextLine();
			i1 = Integer.parseInt(s1);
		}
		System.out.println("How many tasks ?");
		s2 = sc.nextLine();
		i2 = Integer.parseInt(s2);
		while(i2 < 0)
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
		while(i3 < 1 || i3 > 3)
		{
			System.out.println("Incorrect value, try again");
			s3 = sc.nextLine();
			i3 = Integer.parseInt(s3);
		}
		
		if(i3 == 1)
		{
			
			System.out.println("Temperature de depart");
			int nbIt=sc.nextInt();
			while(nbIt <0) {
				System.out.println("La temperature de depart doit etre positive");
				nbIt=sc.nextInt();
			}
			Model res=model.recuitSimule(nbIt);
			int max=-1;
			int min=Integer.MAX_VALUE;
			for(Processor p : res.getProcessorList()) {
				if(p.getTotalTime()>max) {
					max=p.getTotalTime();
				}
				if(p.getTotalTime()<min) {
					min=p.getTotalTime();
				}
			}
			System.out.println("Le temps total sera de : "+max+" secondes \nLe processeur qui finira en premier aura mis : "+min+" secondes.");
			
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
				System.out.println(model.allTaskAffected()); // Vérification que chacune des taches soit affectées
				System.out.println("-------");
				IntCouple ic = new IntCouple(0,0);
				ic = model.one_Task_Sucessor(t0);
				// On donne une tache t0 à one_Task_Sucessor qui va cacluler toutes les 
				// permutations possibles pour cette tache --> renvoit le couple d'entier représentant la
				// permutation donnant un temps de fin d'éxécution des taches pour les processeurs.
				// Ce temps est le minimum possible en permutant la tache donné à one_Task_Sucessor
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
