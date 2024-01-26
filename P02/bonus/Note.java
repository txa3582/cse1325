public class Note
{
	//field1: pitch enum
	private Pitch pitch;
	//field2: octave
	private int octave;

	//default constructor
	public Note()
	{
		this.pitch = null;
	}
	//contructor
	public Note(Pitch pitch, int octave)
	{
		this.pitch = pitch;
		this.octave = octave;
 
		//validate octave
		if(octave <= -5) 
			octave = -5;
		
		if(octave >= 4)
			octave = 4;
	}

	// methods
	@Override 
	public String toString()
	{

		if (pitch != null)
		{

			if (octave != 0)
			{
				return pitch + "" + octave;
			}
			else if(octave == -5)
			{
				return pitch + "" + "⁻⁵";
			}
			else if(octave == -4)
			{
				return pitch + "" + "⁻⁴";
			}
			else if(octave == -3)
			{
				return pitch + "" + "⁻³";
			}
			else if(octave == -2)
			{
				return pitch + "" + "⁻²";
			}
			else if(octave == -1)
			{
				return pitch + "" + "⁻¹";
			}
			else if(octave == 1)
			{
				return pitch + "" + "¹";
			}
			else if(octave == 2)
			{
				return pitch + "" + "²";
			}
			else if(octave == 3)
			{
				return pitch + "" + "³";
			}
			else if(octave == 4)
			{
				return pitch + "" + "⁴";
			}
			else
			{
				return pitch + "";
			}
		}

		else
		{
			return " ";
		}
	}


}

