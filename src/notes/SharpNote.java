package notes;

import notes.Note;
import notes.DblFlatNote;
import notes.FlatNote;
import notes.NaturalNote;
import notes.DblSharpNote;

public class SharpNote extends AlteredNote {
	DblSharpNote sharp;
	
	public SharpNote(NaturalNote natural) {
		super(natural);
	}
	
	public FlatNote dblFlat() {
		return natural.flat();
	}
	
	public NaturalNote flat() {
		return natural;
	}
	
	public DblSharpNote sharp() {
		return sharp;
	}

	@Override
	protected int semiToneCount() {
		return natural.semiToneCount()+1;
	}
}
