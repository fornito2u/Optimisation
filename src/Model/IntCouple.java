package Model;

/**
 * Représente une permutation de tache (tache d'id x permute avec tache d'id y)
 * @author Marvin
 *
 */
public class IntCouple 
{
	private int x;
	private int y;
	private int newTotalTime; // Nouveau temps total après avoir effectuer la permutation de la tache d'id x avec la tache d'id y
	
	public IntCouple(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.newTotalTime = -1;
	}

	public int getNewTotalTime() 
	{
		return newTotalTime;
	}

	public void setNewTotalTime(int newTotalTime) 
	{
		this.newTotalTime = newTotalTime;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	@Override
	public String toString() {
		return "IntCouple [x=" + x + ", y=" + y + ", newTotalTime=" + newTotalTime + ", getNewTotalTime()="
				+ getNewTotalTime() + ", getX()=" + getX() + ", getY()=" + getY() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
