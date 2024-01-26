import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;

public class Note
{
	//field1: pitch enum
	private Pitch pitch;
	//field2: octave
	private int octave;

	private String octaveString;


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

		//superscript
		switch(this.octave)
		{
			case -5:
				octaveString = ("⁻⁵");
			break;	
			case -4:
				octaveString = ("⁻⁴");
			break;	
			case -3:
				octaveString = ("⁻³");
			break;	
			case -2:
				octaveString = ("⁻²");
			break;	
			case -1:
				octaveString = ("⁻¹");
			break;	
			case 1:
				octaveString = ("¹");
			break;	
			case 2:
				octaveString = ("²");
			break;	
			case 3:
				octaveString = ("³");
			break;	
			case 4:
				octaveString = ("⁴");
			break;
		}
	}

	// methods
	@Override 
	public String toString()
	{

		if (pitch != null)
		{

			if (octave != 0)
			{
				return pitch + "" + octaveString;
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

