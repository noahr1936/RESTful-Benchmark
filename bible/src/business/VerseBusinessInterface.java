package business;

import java.util.List;

import javax.ejb.Local;

import beans.Verse;

@Local
public interface VerseBusinessInterface {

	public Verse findVerse(String book, int chapter, int verse);
	
	public List<Verse> getVerses();
	
	
	
}
