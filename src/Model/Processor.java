package Model;

import java.util.ArrayList;

public class Processor 
{
	private ArrayList<Task> taskList;
	private int id;
	
	public Processor(int id)
	{
		this.id = id;
		this.taskList = new ArrayList<Task>();
	}
	
	public int getTotalTime()
	{
		int totalTime = 0;
		for(int i = 0; i < this.taskList.size(); ++i)
		{
			totalTime += this.taskList.get(i).getExecutionTime();
		}
		return totalTime;
	}
	
	public void addTaskToProcessor(Task t)
	{
		t.setIdProcessorAffected(this.id);
		t.setAffected(true);
		this.taskList.add(t);
	}

	public ArrayList<Task> getTaskList() 
	{
		return taskList;
	}

	public void setTaskList(ArrayList<Task> taskList) 
	{
		this.taskList = taskList;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	@Override
	public String toString() 
	{
		return "Processor [taskList=" + taskList + ", id=" + id + ", getTotalTime()=" + getTotalTime()
				+ ", getTaskList()=" + getTaskList() + ", getId()=" + getId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
