package notes;

import notes.Note;
import notes.FlatNote;
import notes.NaturalNote;
import notes.SharpNote;
import notes.DblSharpNote;

public class DblFlatNote extends AlteredNote{
	
	public DblFlatNote(NaturalNote natural) {
		super(natural);
	}

	public FlatNote sharp() {
		return natural.flat();
	}
	
	public NaturalNote dblSharp() {
		return natural;
	}

	@Override
	protected int semiToneCount() {
		return natural.semiToneCount()-2;
	}
}
