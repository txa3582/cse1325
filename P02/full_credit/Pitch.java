public class Note
{
	//field1: pitch enum
	private enum Pitch
	{
		C, Db, D, Eb, E, F, Gb, G, Ab, A, B, B
	}
	private Pitch pitch;
	//field2: octave
	private int octave;

	//contructor
	public Note()
	{
		pitch = Pitch.C;
		octave  = 0;

		if(-5 >= octave || octave  >= 4)
			throw IllegalArguementException
				("octave must be between -5 and 4");
	}

}

