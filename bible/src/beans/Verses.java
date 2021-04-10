package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import business.VerseBusinessInterface;

@ManagedBean
@RequestScoped
public class Verses {	
	List<Verse> verses = new ArrayList<Verse>();
	
	@Inject
	VerseBusinessInterface service;
	
	public Verses() {
		
	}

	@PostConstruct
	public void service() {
		System.out.println(verses.size());
		verses = service.getVerses();
	}

	
	public List<Verse> getVerses() {
		return verses;
	}

	public void setVerses(List<Verse> verses) {
		this.verses = verses;
	}
	
	
}
