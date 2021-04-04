package notes;

import notes.DblFlatNote;
import notes.FlatNote;
import notes.NaturalNote;
import notes.SharpNote;
import notes.DblSharpNote;

public abstract class AlteredNote extends Note{
	NaturalNote natural;
	
	public AlteredNote(NaturalNote natural) {
		this.natural = natural;
	}
}
