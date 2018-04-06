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
		System.out.println("Combien de processeurs ?");
		s1 = sc.nextLine();
		i1 = Integer.parseInt(s1);
		while(i1 < 0)
		{
			System.out.println("Valeur incorrecte");
			s1 = sc.nextLine();
			i1 = Integer.parseInt(s1);
		}
		System.out.println("Combien de tâches ?");
		s2 = sc.nextLine();
		i2 = Integer.parseInt(s2);
		while(i2 < 0)
		{
			System.out.println("Valeur incorrecte");
			s2 = sc.nextLine();
			i2 = Integer.parseInt(s2);
		}
		Model model = new Model(i1, i2);
		System.out.println("Système de base :");
		model.initModel();
		Model base = model;
		model.displaySituation();
		System.out.println("Choisir votre algorithme : Entrer 1 pour un recuit simulé ou entrer 2 pour une recherche taboo");
		s3 = sc.nextLine();
		i3 = Integer.parseInt(s3);
		while(i3 < 1 || i3 > 3)
		{
			System.out.println("Valeur incorrect");
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
			System.out.println("Système optimisé :");
			res.displaySituation();
			System.out.println("Le temps total sera de : "+max+" secondes \nLe processeur qui finira en premier aura mis : "+min+" secondes.");
			
		}
		else
		{
			System.out.println("Taille de la liste taboo ?");
			int tListTaboo=sc.nextInt();
			while(tListTaboo <= 0) 
			{
				System.out.println("La taille de la liste taboo doit etre positive");
				tListTaboo=sc.nextInt();
			}
			Model res = model.listTaboo(tListTaboo);
			int max = -1;
			int min = Integer.MAX_VALUE;
			for(Processor p : res.getProcessorList()) 
			{
				if(p.getTotalTime() > max) 
				{
					max=p.getTotalTime();
				}
				if(p.getTotalTime() < min) 
				{
					min=p.getTotalTime();
				}
			}
			System.out.println("Système optimisé :");
			res.displaySituation();
			System.out.println("Le temps total sera de : "+max+" secondes \nLe processeur qui finira en premier aura mis : "+min+" secondes.");
			boolean keepGoing = true;
			while(keepGoing == true)
			{
				System.out.println("Voulez-vous changer la taille de la liste taboo ? 1 = Oui | 2 = Non");
				tListTaboo=sc.nextInt();
				while(tListTaboo <1 || tListTaboo > 2) 
				{
					System.out.println("Réponse incorrecte, 1 = Oui | 2 = Non");
					tListTaboo=sc.nextInt();
				}
				if(tListTaboo == 2)
				{
					System.out.println("Fin de l'optimisation");
					keepGoing = false;
					break;
				}
				else
				{
					System.out.println("Nouvelle taille de la liste taboo ?");
					tListTaboo=sc.nextInt();
					while(tListTaboo <= 0) 
					{
						System.out.println("La taille de la liste taboo doit etre positive");
						tListTaboo=sc.nextInt();
					}
					res = base;
					res = res.listTaboo(tListTaboo);
					System.out.println("Système optimisé :");
					res.displaySituation();
					System.out.println("Le temps total sera de : "+max+" secondes \nLe processeur qui finira en premier aura mis : "+min+" secondes.");
				}
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
