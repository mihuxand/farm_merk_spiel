package ue205_farm_merk_spiel;

public class Tier 
{
	char meinFutter;
	String soundZufrieden;
	String soundWuetend;
	
	public Tier(char meinFutter,String soundZufrieden,String soundWuetend)
	{
		this.meinFutter = meinFutter;
		this.soundZufrieden = soundZufrieden;
		this.soundWuetend = soundWuetend;
	}
		public boolean fuettern(char futter) 
		{
			boolean futterOk;
			if (futter == meinFutter) 
			{
				zufrieden();
				futterOk = true;
			}
			else 
			{
				wuetend();
				futterOk = false;
			}
			return futterOk;
		}
		public void zufrieden() 
		{ 
			System.out.println(soundZufrieden); 
		}
		public void wuetend() 
		{
			System.out.println(soundWuetend); 
		}
}	
