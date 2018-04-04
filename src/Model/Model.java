package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Représente un état avec un certain nombre de processeurs, un certain nombre de tache, 
 * et certaines taches affectés à des processeurs
 * @author Marvin
 *
 */
public class Model 
{	
	private ArrayList<Processor> processorList;
	private ArrayList<Task> taskList;
	private ArrayList<IntCouple> tabooList;
	
	/**
	 * @param nbProcessor
	 * @param nbTask
	 */
	public Model(int nbProcessor, int nbTask)
	{
		this.processorList = new ArrayList<Processor>();
		this.taskList = new ArrayList<Task>();
		for(int i = 0; i < nbProcessor; ++i)
		{
			this.processorList.add(new Processor(i));
		}
		for(int j = 0; j < nbTask; ++j)
		{
			Task t = null;
			if( j == 0)
			{
				t = new Task(j, 50);
			}
			if(j == 1)
			{
				t = new Task(j, 200);
			}
			if(j > 1)
			{
				t = new Task(j, 100);
			}
			this.taskList.add(t);
		}
	}
	
	/**
	 * Permet de mettre a jour la liste des taches taskList par rapport à la liste des taches de chaque processeur
	 */
	public void globalTaskUpdate()
	{
		for(int i = 0; i < this.processorList.size(); ++i)
		{
			for(int j = 0; j < this.processorList.get(i).getTaskList().size(); ++j)
			{
				this.processorList.get(i).getTaskList().get(j).update(this);
			}
		}
	}
	
	/**
	 * @return b
	 */
	public boolean allTaskAffected()
	{
		boolean b = true;
		for(int i = 0; i < this.getTaskList().size()-1; ++i)
		{
			if(this.getTaskList().get(i).isAffected() == false)
			{
				b = false;
			}
		}
		return b;
	}
	
	/**
	 * @return id
	 */
	public int longestProcessor()
	{
		int[] tabTimeByProcessor = new int[this.processorList.size()];
		int timeSum = 0;
		int actualBestTime = -1;
		int id = -1;
		for(int i = 0; i < this.processorList.size(); ++i)
		{
			timeSum += this.processorList.get(i).getTotalTime();
			tabTimeByProcessor[i] = timeSum;
			timeSum = 0;
		}
		id = 0;
		for(int k = 0; k < tabTimeByProcessor.length; ++k)
		{
			if(tabTimeByProcessor[k] > actualBestTime)
			{
				actualBestTime = tabTimeByProcessor[k];
				id = k;
			}
		}
		return id;
	}

	/**
	 * Renvoit le meilleur exchange possible pour 1 tache
	 * @return
	 */
	public IntCouple one_Task_Sucessor(Task t)
	{
		Model m = new Model(0, 0);
		m.processorList = this.getProcessorList();
		m.taskList = this.getTaskList();
		m.tabooList = this.getTabooList();
		int idLongestProcessor = m.longestProcessor(); 
		int timeLongestProcessor = m.getProcessorList().get(idLongestProcessor).getTotalTime(); // Temps total du processeur le plus long
		IntCouple ic = new IntCouple(t.getId(), -1);
		if(this.allTaskAffected())
		{
			for(int i = 0; i < this.processorList.size(); ++i)
			{
				if(this.processorList.get(i).getId() != t.getIdProcessorAffected())
				{
					for(int j = 0; j < this.processorList.get(i).getTaskList().size(); ++j)
					{
						int idProcessorT = t.getIdProcessorAffected();
						int positionT = this.processorList.get(idProcessorT).getTaskList().indexOf(t);
						m.exchangeTask(t, this.processorList.get(i).getTaskList().get(j));
						m.globalTaskUpdate();
						// Si le temps de l'ancien plus long processeur est supérieur au temps
						// du nouveau plus long processeur = si l'échange a diminuer le temps maximum global
						if(timeLongestProcessor > m.getProcessorList().get(m.longestProcessor()).getTotalTime())
						{
							ic.setY(m.getProcessorList().get(idProcessorT).getTaskList().get(positionT).getId());
							idLongestProcessor = m.longestProcessor();
							timeLongestProcessor = m.getProcessorList().get(idLongestProcessor).getTotalTime();
							ic.setNewTotalTime(timeLongestProcessor);
							System.out.println(timeLongestProcessor);
						} 
					}
				}
			}
		}
		return ic;
	}
	
	/**
	 * Permet d'échanger la position entre 2 taches
	 * @param t1
	 * @param t2
	 */
	public boolean exchangeTask(Task t1, Task t2)
	{
		if(t1 != t2)
		{
			int idProcessor1 = t1.getIdProcessorAffected();
			int idProcessor2 = t2.getIdProcessorAffected();
			int positionTask1 = this.processorList.get(idProcessor1).getTaskList().indexOf(t1);
			int positionTask2 = this.processorList.get(idProcessor2).getTaskList().indexOf(t2);
			//Pas besoin de supprimer de la liste, la fonction set remplace directement
			//this.processorList.get(idProcessor1).getTaskList().remove(positionTask1);
			//this.processorList.get(idProcessor2).getTaskList().remove(positionTask2);
			t1.setIdProcessorAffected(idProcessor2);
			t2.setIdProcessorAffected(idProcessor1);
			this.processorList.get(idProcessor1).getTaskList().set(positionTask1, t2); // Ajoute le second task a la position du premier task dans le processeur du premier task
			this.processorList.get(idProcessor2).getTaskList().set(positionTask2, t1); // Ajoute le premoer task a la position du second task dans le processeur du second task	
			return true;
		}
		else
		{
			System.out.println("You tried to exchange a task with himself !");
			return false;
		}
	}
	public Model successeur(Model mod) {
		Model m=new Model(mod.getProcessorList().size(),mod.getTaskList().size());
		m.initModel();
		if(m.allTaskAffected()) {
			Random r=new Random();
			int swapTask1=r.nextInt(m.getTaskList().size());
			int swapTask2=r.nextInt(m.getTaskList().size());
			while(swapTask1==swapTask2 || m.getTaskList().get(swapTask1).getIdProcessorAffected()==m.getTaskList().get(swapTask2).getIdProcessorAffected()) {
				swapTask1=r.nextInt(m.getTaskList().size());
				swapTask2=r.nextInt(m.getTaskList().size());
			}
			m.exchangeTask(m.getTaskList().get(swapTask1), m.getTaskList().get(swapTask2));
			m.globalTaskUpdate();
		}else {
			return mod;
		}
		return m;
	}
	
	public int valeur(Model mod) {
		return mod.getProcessorList().get(mod.longestProcessor()).getTotalTime()/25;
	}
	
	public void initModel() {
		for(int i=0;i<taskList.size();i++) {
			if(!taskList.get(i).isAffected()) {
				processorList.get((i%processorList.size())).addTaskToProcessor(taskList.get(i));
			}
		}
		globalTaskUpdate();
	}
	
	
	public Model recuitSimule(int nbIteration) {
		this.initModel();
		Model n=this;
		Model suc;
		double T;
		int compare;
		for(int i=0;i<nbIteration;i++) {
			T=0.09*i;
			suc=successeur(n);
			compare=valeur(n)-valeur(suc);
			if(compare>=0) {
				n=suc;
			}else {
				if(Math.random()>Math.exp((compare/T))){
					n=suc;
				}
			}
		}
		return n;
	}
	
	public ArrayList<IntCouple> getTabooList() 
	{
		return tabooList;
	}

	public void setTabooList(ArrayList<IntCouple> tabooList) 
	{
		this.tabooList = tabooList;
	}
	
	/**
	 * @param processorListe
	 */
	public void setProcessorListe(ArrayList<Processor> processorListe) 
	{
		this.processorList = processorList;
	}


	/**
	 * @return processorList
	 */
	public ArrayList<Processor> getProcessorList() 
	{
		return processorList;
	}

	public void setProcessorList(ArrayList<Processor> processorList) 
	{
		this.processorList = processorList;
	}

	public ArrayList<Task> getTaskList() 
	{
		return taskList;
	}

	/**
	 * @param taskList
	 */
	public void setTaskList(ArrayList<Task> taskList) 
	{
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		return "Model [processorList=" + processorList + ", taskList=" + taskList + ", tabooList=" + tabooList
				+ ", allTaskAffected()=" + allTaskAffected() + ", longestProcessor()=" + longestProcessor()
				+ ", getTabooList()=" + getTabooList() + ", getProcessorList()=" + getProcessorList()
				+ ", getTaskList()=" + getTaskList() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}	
}
