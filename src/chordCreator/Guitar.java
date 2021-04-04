 
package chordCreator;

import java.util.*;


public class Guitar {
	
	static class Scale{
		String type; 
		String root;
		ArrayList<String> scaleNotes;
		public static HashMap<String, String> patternsMap = new HashMap<String, String>();
		
		public Scale(String root, String type) {
			populatePatternsMap();
			scaleNotes = new ArrayList<String>();
			this.type = type;
			this.root = root;
			int note = notesMap.get(root);
			String pattern = patternsMap.get(type);
			for(int i = 0; i < pattern.length(); i++) {
				char inst = pattern.charAt(i);
				scaleNotes.add(numberMap.get(note));
				if(inst == 'W') note = (note+2)%12;
				else if(inst == 'H') note = (note+1)%12;
				else if(inst == 'E') note = (note+3)%12;
			}
		}
		
		static void populatePatternsMap() {
			patternsMap.put("major", "WWHWWWH");
			patternsMap.put("minor", "WHWWHWW");
			patternsMap.put("melodic", "WHWWWWH");
			patternsMap.put("harmonic", "WHWWHWEH");
			patternsMap.put("dorian", "WHWWWHW");
			patternsMap.put("phrygian", "HWWWHWW");
			patternsMap.put("lydian", "WWWHWWH");
			patternsMap.put("mixolydian", "WWHWWHW");
			patternsMap.put("locrian", "HWWHWWW");
		}
		
		void printScale() {
			for(int i = 0; i < scaleNotes.size(); i++) {
				System.out.print(scaleNotes.get(i) + " ");
			}
			System.out.println();
		}
		
		String getRoot() {
			return this.root;
		}
		
		String getType() {
			return this.type;
		}
		
		ArrayList<String> getScaleArray(){
			return scaleNotes;
		}
		
		void transposeScale(int amount) {
			String transposedRoot = numberMap.get((notesMap.get(this.root) + amount)%12);
			root = transposedRoot;
			for(int i = 0; i < scaleNotes.size(); i++) {
				int transposed = (notesMap.get(scaleNotes.get(i)) + amount)%12;
				String newNote = numberMap.get(transposed);
				scaleNotes.set(i, newNote);
			}
		}
		
		void changeModes(int mode) {
			int modeAmount = mode;
			for(int i = 0; i < scaleNotes.size(); i++) {
				String newNote = scaleNotes.get((i + modeAmount)%scaleNotes.size());
				scaleNotes.set(i, newNote);
			}
		}
		
	}

	public static String[] notesArray = {"A", "A#/Bb","B", "C", "C#/Db", "D", "D#/Eb","E", "F", 
			"F#/Gb","G", "G#/Ab"};
	public static HashMap<String, Integer> notesMap = new HashMap<String, Integer>();
	public static HashMap<Integer, String> numberMap = new HashMap<Integer, String>();
	int numberOfStrings;
	int numberOfFrets;
	List<String> tuning;
	String name;
	String[][] stringArray;
	
	public Guitar(int numberOfStrings, int numberOfFrets, List<String> tuningnotes, String name) {
		populateNotesMap();
		populateNumberMap();
		this.stringArray = new String[numberOfStrings][numberOfFrets];
		this.numberOfStrings = numberOfStrings;
		this.numberOfFrets = numberOfFrets;
		this.tuning = tuningnotes;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public int getNumberOfFrets() {
		return numberOfFrets;
	}
	
	public int getNumberOfStrings() {
		return numberOfStrings;
	}
	
	public List<String> getTuning() {
		return tuning;
	}
	
	public String[][] getStringArray(){
		return stringArray;
	}
	
	public String getName(){
		return name;
	}
	
	static void populateNotesMap() {
		notesMap.put("C", 0);
		notesMap.put("C#/Db", 1);
		notesMap.put("D", 2);
		notesMap.put("D#/Eb", 3);
		notesMap.put("E", 4);
		notesMap.put("F", 5);
		notesMap.put("F#/Gb", 6);
		notesMap.put("G", 7);
		notesMap.put("G#/Ab", 8);
		notesMap.put("A", 9);
		notesMap.put("A#/Bb", 10);
		notesMap.put("B", 11);
	}
	
	static void populateNumberMap() {
		numberMap.put(0, "C");
		numberMap.put(1, "C#/Db");
		numberMap.put(2, "D");
		numberMap.put(3, "D#/Eb");
		numberMap.put(4, "E");
		numberMap.put(5, "F");
		numberMap.put(6, "F#/Gb");
		numberMap.put(7, "G");
		numberMap.put(8, "G#/Ab");
		numberMap.put(9, "A");
		numberMap.put(10, "A#/Bb");
		numberMap.put(11, "B");
	}
	
	void createFretboard() {
		
		int fretCount = 0;
		int stringCount = 0;
		
		for(int i = tuning.size()-1; i >= 0; i++) {
			String opennote = tuning.get(i);
			this.stringArray[fretCount++][0] = opennote;
			stringCount++;
		}
		if(stringCount != numberOfStrings) {
			System.out.println("Invalid tuning/number of strings!");
			System.exit(0);
		}
		for(int stringIt = 0; stringIt < numberOfStrings; stringIt++) {
			int index = Arrays.binarySearch(notesArray, stringArray[stringIt][0]); 
			for(int fretIt = 1; fretIt < numberOfFrets; fretIt++) {
				 String currnote = notesArray[++index%notesArray.length];
				 stringArray[stringIt][fretIt] = currnote; 
			}
		}
	}
		
}


