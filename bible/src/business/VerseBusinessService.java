package business;

import beans.Verse;
import data.VerseDataService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class VerseBusinessService
 */
@Stateless
@Local(VerseBusinessInterface.class)
@LocalBean
@Alternative
public class VerseBusinessService implements VerseBusinessInterface {

	@EJB
	VerseDataService service;
	
	List<Verse> verses = new ArrayList<Verse>();
	
	Verse returnedVerse = new Verse();
	
    public VerseBusinessService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Verse findVerse(String book, int chapter, int verse) {
		returnedVerse = service.findVerse(book, chapter, verse);
		
		verses.add(returnedVerse);
		
		return returnedVerse;
	}
	
	public void testVerse() {
		
		returnedVerse = service.testVerse();
		System.out.println(returnedVerse);
	}

	@Override
	public List<Verse> getVerses() {
		
		return verses;
	}


	
    

}
