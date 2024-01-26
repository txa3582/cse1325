public enum Pitch
{
	C("C",60), Db("D♭",61), D("D",62), Eb("E♭",63), E("E",64), F("F",65), Gb("G♭",66), G("G",67), Ab("A♭",68), A("A",69), Bb("B♭",70), B("B",71);

	//fields
	private String pitch;

	private int value;
	//constructors
	private Pitch(String pitch, int value)
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
	public int toValue()
	{
		return value;
	}
		 
}
