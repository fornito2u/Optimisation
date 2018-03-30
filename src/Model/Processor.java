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
		return "Processor [taskList=" + taskList + ", id=" + id + ", getTaskList()=" + getTaskList() + ", getId()="
				+ getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
