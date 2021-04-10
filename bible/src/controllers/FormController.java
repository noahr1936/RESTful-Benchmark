package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Verse;
import business.VerseBusinessService;

@ManagedBean
@ViewScoped
public class FormController {
	
	@Inject
	VerseBusinessService service;
	
	public String onSubmit() {
		FacesContext context = FacesContext.getCurrentInstance();
		Verse verse = context.getApplication().evaluateExpressionGet(context, "#{verse}", Verse.class);

//		System.out.println(verse.getBook());
//		System.out.println(verse.getChapter());
//		System.out.println(verse.getVerse());
		
		verse = service.findVerse(verse.getBook(), verse.getChapter(), verse.getVerse());
		
		
//		service.testVerse();
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("verse", verse);

		return "ReturnVerse.xhtml";
	}

}
