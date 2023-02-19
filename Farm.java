package ue205_farm_merk_spiel;

public class Farm 
{
	Tier[] animal = new Tier[3];
	int stelle = 0;

	public Farm() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void tierAufnehmen(Tier neuesTier)
	{
		animal[stelle] = neuesTier;
		stelle++;
	}
	
	public int getLength()
	{
		return animal.length;
	}

	public boolean fuettern(int boxNr, char futter) 
	{
		return animal[boxNr].fuettern(futter);
	}
}
