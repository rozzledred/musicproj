package notes;


import notes.Note;
import notes.DblFlatNote;
import notes.NaturalNote;
import notes.SharpNote;
import notes.DblSharpNote;

public class FlatNote extends AlteredNote {
	DblFlatNote flat;
	
	public FlatNote(NaturalNote natural) {
		super(natural);
	}
	
	public DblFlatNote flat() {
		return flat;
	}
	
	public NaturalNote sharp() {
		return this.natural;
	}
	
	public SharpNote dblSharp() {
		return natural.sharp();
	}

	@Override
	protected int semiToneCount() {
		return natural.semiToneCount()-1;
	}
}
