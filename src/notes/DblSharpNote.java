package notes;

import notes.Note;
import notes.DblFlatNote;
import notes.FlatNote;
import notes.NaturalNote;
import notes.SharpNote;


public class DblSharpNote extends AlteredNote {
	
		
	public DblSharpNote(NaturalNote natural) {
		super(natural);
	}

	public NaturalNote dblFlat() {
		return natural;
	}
	
	public SharpNote flat() {
		return natural.sharp();
	}

	@Override
	protected int semiToneCount() {
		return natural.semiToneCount()+2;
	}

}
