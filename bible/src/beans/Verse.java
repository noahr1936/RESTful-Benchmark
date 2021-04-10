package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@SessionScoped
@XmlRootElement(name="Verse")
public class Verse {

	String book;
	int chapter;
	int verse;
	String text;
	
	public Verse() {
		book = "John";
		chapter = 3;
		verse = 16;
	}

	public Verse(String book, int chapter, int verse, String text) {
		super();
		this.book = book;
		this.chapter = chapter;
		this.verse = verse;
		this.text = text;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public int getVerse() {
		return verse;
	}

	public void setVerse(int verse) {
		this.verse = verse;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return book + " " + chapter + ": " + verse + "  " + text;
	}
}
