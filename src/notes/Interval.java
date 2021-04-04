package notes;

public class Interval {
	
	// Could theoretically add methods that return Interval type for
	// common intervals but you don't need it rn just remember the
	// semitones and type manually.
	int type;
	int semiTones;
	
	public Interval(int type, int semiTones) {
		this.type = type;
		this.semiTones = semiTones;
	}
	
	public String toString() {
		String s = "";
		if(type == 2) {
			String[] names = {"diminished","minor","major","augmented"};
			s.concat(names[semiTones]);
		}
		else if(type == 3) {
			String[] names = {"minor","major"};
			s.concat(names[semiTones-3]);
		}
		else if(type == 4) {
			String[] names = {"diminished","perfect", "augmented"};
			s.concat(names[semiTones-4]);
		}
		else if(type == 5) {
			String[] names = {"diminished","perfect", "augmented"};
			s.concat(names[semiTones-6]);
		}
		else if(type == 6) {
			String[] names = {"minor","major", "augmented"};
			s.concat(names[semiTones-8]);
		}
		else if(type == 7) {
			String[] names = {"diminished","minor", "major"};
			s.concat(names[semiTones-9]);

		}
		
		s.concat(" ");
		
		String[] degree = {"octave", "second", "third", "fourth", "fifth", "sixth", "seventh"};
		s.concat(degree[type-1]);
		
		return s;
	}
	
}
