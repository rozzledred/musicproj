package chordCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import chordCreator.Guitar.Scale;
import chordCreator.Guitar;

public class Runner {
	
	public static HashMap<String, Integer> notesMap = new HashMap<String, Integer>();
	public static HashMap<Integer, String> numberMap = new HashMap<Integer, String>();
	
	static void printFretboard(Guitar guitar){
		int nostrings = guitar.getNumberOfStrings();
		int nofrets = guitar.getNumberOfFrets();
		String[][] array = guitar.getStringArray();
		for(int i = 0; i < nostrings; i++) {
			for(int j = 0; j < nofrets; j++) {
				System.out.print(array[i][j] + "     ");
			}
			System.out.println();
		}
	}
	
	static boolean checkTuning(List<String> tuning, int nostrings) {
		if(tuning.size() != nostrings) return false;
		for(int i = 0; i < tuning.size(); i++) {
			String curr = tuning.get(i);
			if(!notesMap.containsKey(curr)) return false;
		}
		return true;
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
	
	//create temp input w scanner and eventually gui shtuff l8r
		public static void main(String[] args) {
			ArrayList<Scale> scalelist = new ArrayList<Scale>();
			ArrayList<Guitar> guitarlist = new ArrayList<Guitar>();
			Scanner input = new Scanner(System.in);
			
			populateNotesMap();
			populateNumberMap();
			
			System.out.println("Welcome to gamer swag guitar simulator that isn't finished yet B)");
			System.out.println("Commands: guitar, scale, printguitarlist, printfretboard, exit\n");
			while(true) {
				System.out.print("Enter a command: ");
				String choice = input.nextLine();
				choice = choice.toLowerCase();
				switch(choice) {
					case "guitar":
						//Strings
						System.out.print("How many strings: ");
						int nostrings;
						if(input.hasNextInt()) {
							nostrings = input.nextInt();
							input.nextLine();
						}
						else {
							while(!input.hasNextInt()) {
								System.out.print("Not a valid input! Try again: ");
								input.nextLine();
							}
							nostrings = input.nextInt();
							input.nextLine();
						}
						
						//Frets
						System.out.print("How many frets?: ");
						int nofrets;
						if(input.hasNextInt()) {
							nofrets = input.nextInt();
							input.nextLine();
						}
						else {
							while(!input.hasNextInt()) {
								System.out.print("Not a valid input! Try again: ");
								input.next();
							}
							nofrets = input.nextInt();
							System.out.print("# Frets:" + nofrets);
							input.nextLine();
						}
						
						//Tuning
						System.out.print("Tuning (space separated)?: ");
						String tuning = input.nextLine();
						List<String> tuningnotes = Arrays.asList(tuning.split("\\s+"));
						Guitar guitar;
						String gname;
						if(checkTuning(tuningnotes, nostrings)) {
							System.out.print("Guitar name?: ");
							gname = input.nextLine();
							guitar = new Guitar(nostrings, nofrets, tuningnotes, gname);
							guitarlist.add(guitar);
						}
						else {
							while(!checkTuning(tuningnotes, nostrings)) {
								System.out.print("Not a valid input! Try again: ");
								tuning = input.nextLine();
								tuningnotes = Arrays.asList(tuning.split("\\s+"));
							}
							System.out.print("Guitar name?: ");
							gname = input.nextLine();
							guitar = new Guitar(nostrings, nofrets, tuningnotes, gname);
						}
						break;
					
					case "printguitarlist":
						for(int i = 0; i < guitarlist.size(); i++) {
							System.out.println((i+1) + ": " + guitarlist.get(i).getName());
						}
						break;
					
					case "printfretboard":
						boolean found = false;
						int gfound = -1;
						System.out.println("Which guitar?: ");
						String printname = input.nextLine();
						for(int i = 0; i < guitarlist.size(); i++) {
							Guitar guitarname = guitarlist.get(i);
							String name = guitarname.getName();
							if(name.equals(printname)) {
								gfound = i;
								found = true;
								break;
							}
						}
						if(found) {
							Guitar coolfound = guitarlist.get(gfound);
							printFretboard(coolfound);
						}
						else {
							System.out.println("Guitar not found!");
							break;
						}
					
					case "exit":
						System.exit(0);
				}
			}
		}

}
