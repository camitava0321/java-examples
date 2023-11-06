/**
 * 
 */
package com.amc.film;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


/**
 * @author Amitava Chakraborty Jun 2010
 *
 */
public class OMDBDemos {
	public static final String FILE_PROPERTIES = "config.properties";
	public static final String FILE_FILMNAMES = "films.txt";
	public static String FILE_NETWORK_PARAMETERS="";


	
	
	
	/**
	 * Search All Films with a searchstring and page number
	 */
	public static void getAllMovies(String searchString, int pageNumber)
	{
		JSONObject jsonObject=null;
		try {
			String URI="s="+searchString;
			if (pageNumber>0) {
				URI=URI+"&page="+pageNumber;
			}
			String URL=Configuration.buildURI(URI);
			jsonObject=JsonReader.readJsonFromUrl(URL);
			//JSONObject jsonObject=JsonReader.readJsonFromUrl("http://www.omdbapi.com/?t=berlin+jerusalem&y=&plot=short&r=json");
			
			//{"Response":"True","totalResults":"444","Search":[{"Type":"movie","Year":"2016","imdbID":"tt4853102","Poster":"https://m.media-amazon.com/images/M/MV5BMTdjZTliODYtNWExMi00NjQ1LWIzN2MtN2Q5NTg5NTk3NzliL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg","Title":"Batman: The Killing Joke"},{"Type":"movie","Year":"2013","imdbID":"tt2166834","Poster":"https://m.media-amazon.com/images/M/MV5BYTEzMmE0ZDYtYWNmYi00ZWM4LWJjOTUtYTE0ZmQyYWM3ZjA0XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg","Title":"Batman: The Dark Knight Returns, Part 2"},{"Type":"movie","Year":"1993","imdbID":"tt0106364","Poster":"https://m.media-amazon.com/images/M/MV5BYTRiMWM3MGItNjAxZC00M2E3LThhODgtM2QwOGNmZGU4OWZhXkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg","Title":"Batman: Mask of the Phantasm"},{"Type":"movie","Year":"2011","imdbID":"tt1672723","Poster":"https://m.media-amazon.com/images/M/MV5BNTJjMmVkZjctNjNjMS00ZmI2LTlmYWEtOWNiYmQxYjY0YWVhXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg","Title":"Batman: Year One"},{"Type":"movie","Year":"2014","imdbID":"tt3139086","Poster":"https://m.media-amazon.com/images/M/MV5BZDU1ZGRiY2YtYmZjMi00ZDQwLWJjMWMtNzUwNDMwYjQ4ZTVhXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg","Title":"Batman: Assault on Arkham"},{"Type":"movie","Year":"1966","imdbID":"tt0060153","Poster":"https://m.media-amazon.com/images/M/MV5BMmM1OGIzM2UtNThhZS00ZGNlLWI4NzEtZjlhOTNhNmYxZGQ0XkEyXkFqcGdeQXVyNTkxMzEwMzU@._V1_SX300.jpg","Title":"Batman: The Movie"},{"Type":"movie","Year":"2008","imdbID":"tt1117563","Poster":"https://m.media-amazon.com/images/M/MV5BM2I0YTFjOTUtMWYzNC00ZTgyLTk2NWEtMmE3N2VlYjEwN2JlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg","Title":"Batman: Gotham Knight"},{"Type":"game","Year":"2011","imdbID":"tt1568322","Poster":"https://m.media-amazon.com/images/M/MV5BZDE2ZDFhMDAtMDAzZC00ZmY3LThlMTItMGFjMzRlYzExOGE1XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg","Title":"Batman: Arkham City"},{"Type":"movie","Year":"2014","imdbID":"tt3139072","Poster":"https://m.media-amazon.com/images/M/MV5BYjdkZWFhNzctYmNhNy00NGM5LTg0Y2YtZWM4NmU2MWQ3ODVkXkEyXkFqcGdeQXVyNTA0OTU0OTQ@._V1_SX300.jpg","Title":"Son of Batman"},{"Type":"movie","Year":"2010","imdbID":"tt1673430","Poster":"https://m.media-amazon.com/images/M/MV5BMjk3ODhmNjgtZjllOC00ZWZjLTkwYzQtNzc1Y2ZhMjY2ODE0XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg","Title":"Superman/Batman: Apocalypse"}]}
			JSONArray results=null;
			if (Integer.parseInt(jsonObject.optString("totalResults"))>0) {
				results = jsonObject.getJSONArray("Search");
				//Print Raw JSON object
				System.out.println("Total Entries: "+results.length());
				System.out.println("Raw JSON: for search string="+
						searchString+" and Page="+
						pageNumber+"\n"+results+"\n");
				//Print Info for each entry
				for (int i = 0; i < results.length(); i++) {
					jsonObject = results.getJSONObject(i);
					for (Iterator iterator = jsonObject.keys(); iterator.hasNext();) {
						String type = (String) iterator.next();
						System.out.print(type+": "+jsonObject.get(type)+" ");
					} 
					System.out.println();
				}
			}
		} catch (JSONException | IOException e) {
			System.out.println(jsonObject);
			e.printStackTrace();
		}
	}
	
	public static void exampleB()
	{
		try {
			String URL=Configuration.buildURI("t=*for*&y=&plot=full&r=json");
			JSONObject jsonObject=JsonReader.readJsonFromUrl(URL);
			//JSONObject jsonObject=JsonReader.readJsonFromUrl("http://www.omdbapi.com/?t=berlin+jerusalem&y=&plot=short&r=json");
			String filmName="";
			String year=jsonObject.optString("Year");
			String duration=jsonObject.optString("Runtime");
			String director=jsonObject.optString("Director");
			String country=jsonObject.optString("Country");
			System.out.println(jsonObject);
			System.out.println(filmName+","+year+","+duration+","+director+","+country.replace(',', ' '));
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void genericQuery(String queryString)
	{
		try {
			String URL=Configuration.buildURI(queryString);
			JSONObject jsonObject=JsonReader.readJsonFromUrl(URL);
			//JSONObject jsonObject=JsonReader.readJsonFromUrl("http://www.omdbapi.com/?t=berlin+jerusalem&y=&plot=short&r=json");
			System.out.println(jsonObject);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void  getMultipleFilms()
	{
		try {
			Configuration.filmNames=OMDBDemos.readFilmNames();
		for (int i = 0; i < Configuration.filmNames.length; i++) {
			String URL=Configuration.buildURI("t=\""+Configuration.filmNames[i]+"\"&y=&plot=short&r=json");
			//System.out.println(URL);
			JSONObject jsonObject=JsonReader.readJsonFromUrl(URL);
			//JSONObject jsonObject=JsonReader.readJsonFromUrl("http://www.omdbapi.com/?t=berlin+jerusalem&y=&plot=short&r=json");
			String filmName=Configuration.filmNames[i].replace('+', ' ');
			String year=jsonObject.optString("Year");
			String duration=jsonObject.optString("Runtime");
			String director=jsonObject.optString("Director");
			String country=jsonObject.optString("Country");
			System.out.println(filmName+","+year+","+duration+","+director+","+country.replace(',', ' '));
		}
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String [] readFilmNames() throws IOException {
		 
		String filmName = "";
		ArrayList<String> list = new ArrayList<String>();
		String []filmNames=null;
		InputStream inputStream = null;
		try {
			
			inputStream = OMDBDemos.class.getClassLoader().getResourceAsStream(OMDBDemos.FILE_FILMNAMES);
 
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				while((filmName=reader.readLine())!=null){
					list.add(filmName);
				}
				filmNames = new String [list.size()];
				int count=0;
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					filmNames[count]=(String) iterator.next();
					count++;
				}
			} else {
				throw new FileNotFoundException("File with list of film names '" + OMDBDemos.FILE_FILMNAMES + 
						"' not found in the classpath");
			}
 
		} finally {
			if (inputStream != null) {
			inputStream.close();
			}
		}
		return (filmNames);
	}

	
	public static void getProperties() throws IOException {
		 
		String result = "";
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			
			inputStream = OMDBDemos.class.getClassLoader().getResourceAsStream(OMDBDemos.FILE_PROPERTIES);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + OMDBDemos.FILE_PROPERTIES + 
						"' not found in the classpath");
			}
 
			// get the property value and print it out
			OMDBDemos.FILE_NETWORK_PARAMETERS =  prop.getProperty("FILE_NETWORK_PARAMETERS");
		} finally {
			inputStream.close();
		}
	}


}
