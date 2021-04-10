package data;

import beans.Verse;

public interface DataAccessInterface {

	public Verse findVerse(String book, int chapter, int verse);
}
