public enum Pitch
{
	C("C"), Db("D♭"), D("D"), Eb("E♭"), E("E"), F("F"), Gb("G♭"), G("G"), Ab("A♭"), A("A"), Bb("B♭"), B("B");

	//field
	private String pitch;
	//constructor
	private Pitch(String pitch)
	{
		this.pitch = pitch;	
	}
	//methods
	@Override
	public String toString()
	{
		return pitch;
	}

		 
}
