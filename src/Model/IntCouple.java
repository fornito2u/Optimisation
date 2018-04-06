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
	
	public IntCouple(int x, int y)
	{
		this.x = x;
		this.y = y;
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
	public String toString() 
	{
		return "IntCouple [x=" + x + ", y=" + y + ", getX()=" + getX() + ", getY()=" + getY() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
