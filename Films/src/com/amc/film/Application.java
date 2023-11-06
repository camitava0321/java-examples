/*
 *	This example lists details of various films (preset list).
 *	It gets the details of the films using OMDb API.
 * 
 */
package com.amc.film;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author ibm
 *
 */
public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Application film = new Application();
		
		OMDBDemos.getAllMovies("Batman",0);
		OMDBDemos.exampleB();
		
		//For - http://www.omdbapi.com/?t=Game of Thrones&Season=1&Episode=1
		OMDBDemos.genericQuery("t=Game+of+Thrones&Season=1&Episode=1");
		//For - http://www.omdbapi.com/?t=Game of Thrones&Season=1
		OMDBDemos.genericQuery("t=Game+of+Thrones&Season=1");
		//For - http://www.omdbapi.com/?i=tt0944947&Season=1
		OMDBDemos.genericQuery("i=tt0944947&Season=1");
		//For - http://www.omdbapi.com/?t=*for*&y=1980&plot=full&r=json
		//This will fail, we still cannot process XML
		//OMDBDemos.genericQuery("t=*for*&y=1980&plot=full&r=xml");
		OMDBDemos.getMultipleFilms();
		
		//Get multiple films with a word
		OMDBDemos.genericQuery("s=throne");
	}
}
