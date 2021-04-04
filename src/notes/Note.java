package notes;

public abstract class Note {
	
	public boolean pitchEquals(Note aNote) {
		return this.semiToneCount() == aNote.semiToneCount();
	}

	protected abstract int semiToneCount();
	
	public void initialize() {
		NaturalNote A = new NaturalNote("A", 1);
		
		SharpNote Asharp = new SharpNote(A);
		A.sharp = Asharp;
		DblSharpNote AdblSharp = new DblSharpNote(A);
		Asharp.sharp = AdblSharp;
		FlatNote Aflat = new FlatNote(A);
		A.flat = Aflat;
		DblFlatNote AdblFlat = new DblFlatNote(A);
		Aflat.flat = AdblFlat;
		
		NaturalNote B = new NaturalNote("B", 3);
		
		SharpNote Bsharp = new SharpNote(B);
		B.sharp = Bsharp;
		DblSharpNote BdblSharp = new DblSharpNote(B);
		Bsharp.sharp = BdblSharp;
		FlatNote Bflat = new FlatNote(B);
		B.flat = Bflat;
		DblFlatNote BdblFlat = new DblFlatNote(B);
		Bflat.flat = BdblFlat;
		
		NaturalNote C = new NaturalNote("C", 4);
		
		SharpNote Csharp = new SharpNote(C);
		C.sharp = Csharp;
		DblSharpNote CdblSharp = new DblSharpNote(C);
		Csharp.sharp = CdblSharp;
		FlatNote Cflat = new FlatNote(C);
		C.flat = Cflat;
		DblFlatNote CdblFlat = new DblFlatNote(C);
		Cflat.flat = CdblFlat;
		
		NaturalNote D = new NaturalNote("D", 6);
		
		SharpNote Dsharp = new SharpNote(D);
		D.sharp = Dsharp;
		DblSharpNote DdblSharp = new DblSharpNote(D);
		Dsharp.sharp = DdblSharp;
		FlatNote Dflat = new FlatNote(D);
		D.flat = Dflat;
		DblFlatNote DdblFlat = new DblFlatNote(D);
		Dflat.flat = DdblFlat;
		
		NaturalNote E = new NaturalNote("E", 8);
		
		SharpNote Esharp = new SharpNote(E);
		E.sharp = Esharp;
		DblSharpNote EdblSharp = new DblSharpNote(E);
		Esharp.sharp = EdblSharp;
		FlatNote Eflat = new FlatNote(E);
		E.flat = Eflat;
		DblFlatNote EdblFlat = new DblFlatNote(E);
		Eflat.flat = EdblFlat;
		
		NaturalNote F = new NaturalNote("F", 9);
		
		SharpNote Fsharp = new SharpNote(F);
		F.sharp = Fsharp;
		DblSharpNote FdblSharp = new DblSharpNote(F);
		Fsharp.sharp = FdblSharp;
		FlatNote Fflat = new FlatNote(F);
		F.flat = Fflat;
		DblFlatNote FdblFlat = new DblFlatNote(F);
		Fflat.flat = FdblFlat;
		
		NaturalNote G = new NaturalNote("G", 11);
		
		SharpNote Gsharp = new SharpNote(G);
		G.sharp = Gsharp;
		DblSharpNote GdblSharp = new DblSharpNote(G);
		Gsharp.sharp = GdblSharp;
		FlatNote Gflat = new FlatNote(G);
		G.flat = Gflat;
		DblFlatNote GdblFlat = new DblFlatNote(G);
		Gflat.flat = GdblFlat;
		
		A.following = B;
		B.following = C;
		C.following = D;
		D.following = E;
		E.following = F;
		F.following = G;
		G.following = A;
		
		B.preceding = A;
		C.preceding = B;
		D.preceding = C;
		E.preceding = D;
		F.preceding = E;
		G.preceding = F;
		A.preceding = G;
	}
}
