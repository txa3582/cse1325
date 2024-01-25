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
		this.octave = 0;
	}
	//contructor
	public Note(Pitch pitch, int octave)
	{
		this.pitch = pitch;
		this.octave = octave;
 
		//validate octave
		if(-5 >= octave)
			octave = -5;
		
		if(octave >= 4)
			octave = 4;
	}

	// methods
	@Override 
	public String toString()
	{
		return pitch + "" + octave;
		
	}


}

