public enum Pitch
{
	C("C"), Db("D♭"), D("D"), Eb("E♭"), E("E"), F("F"), Gb("G♭"), G("G"), Ab("A♭"), A("A"), Bb("B♭"), B("B");

	//fields
	private String pitch;

	private int value;
	//constructor
	private Pitch(String pitch)
	{
		this.pitch = pitch;	
		this.value = 60;
	}
	//methods
	@Override
	public String toString()
	{
		return pitch;
	}

		 
}
