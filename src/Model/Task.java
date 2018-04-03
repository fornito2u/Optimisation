package Model;

public class Task 
{
	private int id;
	private int executionTime;
	private boolean isAffected;
	private int idProcessorAffected;

	public Task(int id)
	{
		this.id = id;
		this.isAffected = false;
		this.executionTime = (int)(Math.random()*100)+1;
	}
	
	public Task(int id, int executionTime)
	{
		this.id = id;
		this.isAffected = false;
		this.executionTime = executionTime;
	}

	public void update(Model m)
	{
		if(m != null && m.getTaskList() != null && m.getTaskList().get(this.id) != null)
		{
			m.getTaskList().set(this.id, this);
		}
	}
	
	public float getExecutionTime() 
	{
		return executionTime;
	}

	public void setExecutionTime(int executionTime) 
	{
		this.executionTime = executionTime;
	}

	public boolean isAffected() 
	{
		return isAffected;
	}

	public void setAffected(boolean isAffected) 
	{
		this.isAffected = isAffected;
	}

	public int getIdProcessorAffected() 
	{
		return idProcessorAffected;
	}

	public void setIdProcessorAffected(int idProcessorAffected) 
	{
		this.idProcessorAffected = idProcessorAffected;
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
		return "Task [executionTime=" + executionTime + ", isAffected=" + isAffected + ", idProcessorAffected="
				+ idProcessorAffected + ", getExecutionTime()=" + getExecutionTime() + ", isAffected()=" + isAffected()
				+ ", getIdProcessorAffected()=" + getIdProcessorAffected() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
