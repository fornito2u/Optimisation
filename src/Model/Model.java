package Model;

import java.util.ArrayList;

/**
 * @author Marvin
 *
 */
public class Model 
{	
	private ArrayList<Processor> processorList;
	private ArrayList<Task> taskList;
	
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
			this.taskList.add(new Task());
		}
	}
	
	/**
	 * @return b
	 */
	public boolean allTaskAffected()
	{
		boolean b = true;
		for(Processor p : processorList)
		{
			for(Task t : p.getTaskList())
			{
				if(t.isAffected() == false)
				{
					b = false;
				}
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
			for(int j = 0; j < this.processorList.get(i).getTaskList().size(); ++j)
			{
				timeSum += this.processorList.get(i).getTaskList().get(j).getExecutionTime(); 
			}
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
	 * @return getProcessorListe()
	 */
	public ArrayList<Processor> getProcessorListe() 
	{
		return getProcessorListe();
	}

	/**
	 * @param processorListe
	 */
	public void setProcessorListe(ArrayList<Processor> processorListe) 
	{
		this.processorList = processorList;
	}

	/**
	 * @return taskList
	 */
	public ArrayList<Task> geTaskList() 
	{
		return taskList;
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
	public String toString() 
	{
		return "Model [processorList=" + processorList + ", taskList=" + taskList + ", allTaskAffected()="
				+ allTaskAffected() + ", longestProcessor()=" + longestProcessor() + ", getProcessorListe()="
				+ getProcessorListe() + ", geTaskList()=" + geTaskList() + ", getProcessorList()=" + getProcessorList()
				+ ", getTaskList()=" + getTaskList() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}	
}
