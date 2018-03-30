package Model;

public class Task 
{
	private int executionTime;
	private boolean isAffected;
	private boolean idProcessorAffected;
	
	public Task()
	{
		this.isAffected = false;
		this.executionTime = (int) (Math.random()*100);
	}
	
	public Task(int executionTime)
	{
		this.isAffected = false;
		this.executionTime = executionTime;
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

	public boolean isIdProcessorAffected() 
	{
		return idProcessorAffected;
	}

	public void setIdProcessorAffected(boolean idProcessorAffected) 
	{
		this.idProcessorAffected = idProcessorAffected;
	}

	@Override
	public String toString() 
	{
		return "Task [executionTime=" + executionTime + ", isAffected=" + isAffected + ", idProcessorAffected="
				+ idProcessorAffected + ", getExecutionTime()=" + getExecutionTime() + ", isAffected()=" + isAffected()
				+ ", isIdProcessorAffected()=" + isIdProcessorAffected() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
