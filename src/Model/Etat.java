package Model;

import java.util.ArrayList;

public class Etat 
{
	private ArrayList<Processor> listProcessor;
	
	public Etat(ArrayList<Processor> listProcessor)
	{
		this.listProcessor = listProcessor;
	}

	public ArrayList<Processor> getListProcessor() 
	{
		return listProcessor;
	}

	public void setListProcessor(ArrayList<Processor> listProcessor) 
	{
		this.listProcessor = listProcessor;
	}

	@Override
	public String toString() 
	{
		return "Etat [listProcessor=" + listProcessor + ", getListProcessor()=" + getListProcessor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}	
}
