package notes;

import java.util.*;

import notes.AlteredNote;
import notes.DblFlatNote;
import notes.FlatNote;
import notes.SharpNote;
import notes.DblSharpNote;



public class NaturalNote extends Note {
	static final String[] naturalNotes = {"A","B","C","D","E","F","G"};
	String name;
	int semiToneCount;
	NaturalNote following;
	NaturalNote preceding;
	SharpNote sharp;
	FlatNote flat;
	
	public NaturalNote(String name, int semiToneCount) {
		this.name = name;
		this.semiToneCount = semiToneCount;
	}
	
	public SharpNote sharp() {
		return this.sharp;
	}
	
	public FlatNote flat() {
		return this.flat;
	}
	
	public NaturalNote following() {
		return this.following;
	}
	
	public NaturalNote preceding() {
		return this.preceding;
	}

	@Override
	protected int semiToneCount() {
		return this.semiToneCount;
	}
}


