package Objetos;

public class Ruleta 
{
	private static final String ROJO = "ROJO";
	private static final String NEGRO = "NEGRO";
	
	private int id;
	private boolean open; 
	
	public Ruleta(int id)
	{
		this.id = id; 
		this.open = false;
	}
	
	public int getId()
	{
		return id;
	}	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public boolean getOpen()
	{
		return open;
	}	
	public void setOpen(boolean open)
	{
		this.open = open;
	}
	
	public boolean apuesta(String apuesta)
	{
		if (apuesta.equals(ROJO) || apuesta.equals(NEGRO))
		{
			return (int) (Math.random( )*2 + 1) == 1;
		}
		else 
		{
			return (int) (Math.random( )*37 + 1) == 1;
		}
	}	
	
}
